package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings.TinyRender;

import android.opengl.GLES20;
import android.renderscript.Float3;

public class Shader {
    private int glProgram;
    private int matrixMHandle = GLES20.glGetUniformLocation(this.glProgram, "matrixM");
    private int matrixPHandle = GLES20.glGetUniformLocation(this.glProgram, "matrixP");
    private int matrixVHandle = GLES20.glGetUniformLocation(this.glProgram, "matrixV");
    private int normalsHandle = GLES20.glGetAttribLocation(this.glProgram, "vNormal");
    private int positionHandle = GLES20.glGetAttribLocation(this.glProgram, "vPosition");
    private int uvHandle = GLES20.glGetAttribLocation(this.glProgram, "a_texCoord0");

    public void Destroy() {
    }

    public Shader(String str, String str2) {
        int LoadShader = Renderut.LoadShader(35633, str);
        int LoadShader2 = Renderut.LoadShader(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        this.glProgram = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, LoadShader);
        GLES20.glAttachShader(this.glProgram, LoadShader2);
        GLES20.glLinkProgram(this.glProgram);
    }

    public void Apply(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2) {
        GLES20.glEnableVertexAttribArray(this.positionHandle);
        GLES20.glVertexAttribPointer(this.positionHandle, 3, 5126, false, 12, 0);
        GLES20.glEnableVertexAttribArray(this.uvHandle);
        GLES20.glVertexAttribPointer(this.uvHandle, 2, 5126, false, 8, i);
        GLES20.glEnableVertexAttribArray(this.normalsHandle);
        GLES20.glVertexAttribPointer(this.normalsHandle, 3, 5126, false, 12, i2);
        GLES20.glUseProgram(this.glProgram);
        GLES20.glUniformMatrix4fv(this.matrixVHandle, 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(this.matrixPHandle, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(this.matrixMHandle, 1, false, fArr3, 0);
    }

    public void SetUniformVec3(String str, Float3 float3) {
        GLES20.glUseProgram(this.glProgram);
        GLES20.glUniform3f(GLES20.glGetUniformLocation(this.glProgram, str), float3.x, float3.y, float3.z);
    }
}
