package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings.TinyRender;

import android.renderscript.Float3;

public class Material {
    public Shader shader;

    public Material(Shader shader2) {
        this.shader = shader2;
    }

    public void Apply(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2) {
        this.shader.Apply(fArr, fArr2, fArr3, i, i2);
    }

    public void SetVec3(String str, Float3 float3) {
        this.shader.SetUniformVec3(str, float3);
    }

    public void Destroy() {
        this.shader.Destroy();
    }
}
