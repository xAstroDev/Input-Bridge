package com.catfixture.inputbridge.core.GSS;

public class FrameDataUtils {
    public static final int D3D_API = 2;
    public static final int OPENGL_API = 1;
    public static final int VULKAN_API = 3;

    public static String CastAPIDescriptorToString(byte b, byte b2, byte b3) {
        String str = b2 + "." + b3;
        if (b == 0) {
            return "NONE";
        }
        if (b == 1) {
            return "OPENGL" + str;
        } else if (b == 2) {
            return "D3D" + str;
        } else if (b != 3) {
            return "NULL";
        } else {
            return "VULKAN" + str;
        }
    }
}
