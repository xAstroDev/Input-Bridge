package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings.TinyRender;

public class Mesh {
    public final int[] indices;
    public final float[] normals;
    public final float[] uvs;
    public final float[] vertices;

    public Mesh(float[] fArr, float[] fArr2, float[] fArr3, int[] iArr) {
        this.vertices = fArr;
        this.uvs = fArr2;
        this.normals = fArr3;
        this.indices = iArr;
    }
}
