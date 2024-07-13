package com.catfixture.inputbridge.core.inputbridge;

public class InputBridgeProtocol {
    public static final byte ACTION_CONSTANT_MOUSE_SHIFT = 21;
    public static final byte ACTION_KEY_DOWN = 10;
    public static final byte ACTION_KEY_UP = 11;
    public static final byte ACTION_MOUSE_DOWN = 12;
    public static final byte ACTION_MOUSE_SHIFT = 20;
    public static final byte ACTION_MOUSE_UP = 13;
    public static final byte ACTION_SCROLL = 22;
    public static final byte ACTION_SET_MOUSE_POSITION = 23;
    public static final byte ACTION_SET_XI_STATE = 50;
    public static final byte ACTION_XI_KEY_DOWN = 14;
    public static final byte ACTION_XI_KEY_UP = 15;
    public static final int MAX_INTERCHANGE_FRAME_BUFFER_SIZE = 1024;
    public static final byte PROTOCOL_DISABLE = 101;
    public static final byte PROTOCOL_ENABLE = 100;
    public static final byte PROTOCOL_GET_VER = 103;
    public static final byte PROTOCOL_SET_FILTER_ACIONS = 104;
    public static final byte PROTOCOL_SET_FORCE_EVENTS = 107;
    public static final byte PROTOCOL_SET_MICE_CONTROL_STATE = 106;
    public static final byte PROTOCOL_SET_TARGET_DRIVER_RATE = 102;
    public static final byte PROTOCOL_SET_XINPUT_ENABLED_STATE = 105;
    public static final String SERVER_ADDR = "127.0.0.1";
    public static final int SERVER_PORT = 12544;
}
