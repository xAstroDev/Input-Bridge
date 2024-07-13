package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings.TinyRender;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.IntBuffer;

public class Renderut {
    public static int LoadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public static int GenBuffer(int i, Buffer buffer) {
        buffer.position(0);
        IntBuffer allocate = IntBuffer.allocate(1);
        GLES20.glGenBuffers(1, allocate);
        GLES20.glBindBuffer(i, allocate.get(0));
        GLES20.glBufferData(i, buffer.remaining() * 4, buffer, 35044);
        return allocate.get(0);
    }
}
