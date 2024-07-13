package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings.TinyRender;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.renderscript.Float3;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TinyRenderer implements GLSurfaceView.Renderer {
    int i = 0;
    private MeshRenderer mr;
    float[] pMatrix = new float[16];
    float[] vMatrix = new float[16];
    float[] vPMatrix = new float[16];
    private MeshRenderer xAxisMesh;
    private float xrot = 0.0f;
    private MeshRenderer yAxisMesh;
    private float yrot = 0.0f;
    private MeshRenderer zAxisMesh;

    public void Destroy() {
    }

    public void SetRotation(float f, float f2) {
        this.xrot = f;
        this.yrot = f2;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        MeshRenderer meshRenderer = new MeshRenderer(CubeMesh.CubeMesh, new Material(new Shader(EmbeddedShaders.VertexShaderCode, EmbeddedShaders.FragmentShaderCode)));
        this.mr = meshRenderer;
        Matrix.scaleM(meshRenderer.matrixM, 0, 1.2f, 0.15f, 0.8f);
        Material material = new Material(new Shader(EmbeddedShaders.UnlitVShader, EmbeddedShaders.UnlitFShader));
        MeshRenderer meshRenderer2 = new MeshRenderer(CubeMesh.CubeMesh, material);
        this.xAxisMesh = meshRenderer2;
        Matrix.scaleM(meshRenderer2.matrixM, 0, 1.75f, 0.04f, 0.04f);
        MeshRenderer meshRenderer3 = new MeshRenderer(CubeMesh.CubeMesh, material);
        this.yAxisMesh = meshRenderer3;
        Matrix.scaleM(meshRenderer3.matrixM, 0, 0.04f, 0.75f, 0.04f);
        MeshRenderer meshRenderer4 = new MeshRenderer(CubeMesh.CubeMesh, material);
        this.zAxisMesh = meshRenderer4;
        Matrix.scaleM(meshRenderer4.matrixM, 0, 0.04f, 0.04f, 1.5f);
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        GLES20.glEnable(2929);
        GLES20.glViewport(0, 0, i2, i3);
        Matrix.perspectiveM(this.pMatrix, 0, 90.0f, 1.0f, 0.01f, 100.0f);
    }

    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(256);
        GLES20.glClear(16384);
        Matrix.setLookAtM(this.vMatrix, 0, 0.0f, 0.0f, -1.5f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        Matrix.rotateM(this.vMatrix, 0, this.yrot, 0.0f, 0.0f, 1.0f);
        Matrix.rotateM(this.vMatrix, 0, -this.xrot, 1.0f, 0.0f, 0.0f);
        this.mr.Draw(this.vMatrix, this.pMatrix);
        this.xAxisMesh.GetMat().SetVec3(TypedValues.Custom.S_COLOR, new Float3(1.0f, 0.0f, 0.0f));
        this.xAxisMesh.Draw(this.vMatrix, this.pMatrix);
        this.yAxisMesh.GetMat().SetVec3(TypedValues.Custom.S_COLOR, new Float3(0.0f, 1.0f, 0.0f));
        this.yAxisMesh.Draw(this.vMatrix, this.pMatrix);
        this.zAxisMesh.GetMat().SetVec3(TypedValues.Custom.S_COLOR, new Float3(0.0f, 0.0f, 1.0f));
        this.zAxisMesh.Draw(this.vMatrix, this.pMatrix);
    }
}
