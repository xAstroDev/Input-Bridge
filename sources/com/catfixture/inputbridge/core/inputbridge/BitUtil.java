package com.catfixture.inputbridge.core.inputbridge;

import kotlin.UByte;

public class BitUtil {
    private static final byte[] _IntToByteArray_CACHE = new byte[4];
    private static final byte[] _ShortToByteArray_CACHE = new byte[2];

    public static byte[] IntToByteArray(int i) {
        byte[] bArr = _IntToByteArray_CACHE;
        bArr[3] = (byte) ((i >>> 24) & 255);
        bArr[2] = (byte) ((i >>> 16) & 255);
        bArr[1] = (byte) ((i >>> 8) & 255);
        bArr[0] = (byte) (i & 255);
        return bArr;
    }

    public static byte[] ShortToByteArray(short s) {
        byte[] bArr = _ShortToByteArray_CACHE;
        bArr[1] = (byte) ((s >>> 8) & 255);
        bArr[0] = (byte) (s & 255);
        return bArr;
    }

    public static int BytesArrayToInt(byte[] bArr) {
        return (bArr[0] & UByte.MAX_VALUE) | ((bArr[3] & UByte.MAX_VALUE) << 24) | ((bArr[2] & UByte.MAX_VALUE) << 16) | ((bArr[1] & UByte.MAX_VALUE) << 8);
    }

    public static short BytesArrayToShort(byte[] bArr) {
        return (short) ((bArr[0] & UByte.MAX_VALUE) | ((bArr[1] & UByte.MAX_VALUE) << 8));
    }

    public static int BytesArrayToInt(byte[] bArr, int i) {
        return (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8);
    }

    public static short BytesArrayToShort(byte[] bArr, int i) {
        return (short) ((bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8));
    }

    public static int BytesArrayToShortInt(byte[] bArr, int i) {
        return (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8);
    }

    public static byte[] FloatToByteArray(float f) {
        int floatToIntBits = Float.floatToIntBits(f);
        byte[] bArr = _IntToByteArray_CACHE;
        bArr[3] = (byte) ((floatToIntBits >>> 24) & 255);
        bArr[2] = (byte) ((floatToIntBits >>> 16) & 255);
        bArr[1] = (byte) ((floatToIntBits >>> 8) & 255);
        bArr[0] = (byte) (floatToIntBits & 255);
        return bArr;
    }
}
