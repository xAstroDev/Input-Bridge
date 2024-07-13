package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings.TinyRender;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MeshRenderer {
    private final int ebo;
    private final Material material;
    float[] matrixM = new float[16];
    private final int normalsOffset;
    private final int uvOffset;
    private final int vbo;

    public MeshRenderer(Mesh mesh, Material material2) {
        this.material = material2;
        this.vbo = Renderut.GenBuffer(34962, ByteBuffer.allocateDirect((mesh.vertices.length * 4) + (mesh.uvs.length * 4) + (mesh.normals.length * 4)).order(ByteOrder.nativeOrder()).asFloatBuffer().put(mesh.vertices).put(mesh.uvs).put(mesh.normals));
        this.ebo = Renderut.GenBuffer(34963, ByteBuffer.allocateDirect((mesh.indices.length * 4) + (mesh.normals.length * 4)).order(ByteOrder.nativeOrder()).asIntBuffer().put(mesh.indices));
        Matrix.setIdentityM(this.matrixM, 0);
        int length = mesh.vertices.length * 4;
        this.uvOffset = length;
        this.normalsOffset = length + (mesh.uvs.length * 4);
    }

    public void Draw(float[] fArr, float[] fArr2) {
        this.material.Apply(fArr, fArr2, this.matrixM, this.uvOffset, this.normalsOffset);
        GLES20.glBindBuffer(34962, this.vbo);
        GLES20.glBindBuffer(34963, this.ebo);
        GLES20.glDrawElements(4, 36, 5125, 0);
    }

    public Material GetMat() {
        return this.material;
    }

    public void Destroy() {
        this.material.Destroy();
    }
}
