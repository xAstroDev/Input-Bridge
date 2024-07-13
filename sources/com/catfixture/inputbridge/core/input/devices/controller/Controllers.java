package com.catfixture.inputbridge.core.input.devices.controller;

import android.content.Context;
import android.os.Build;
import android.view.InputDevice;
import androidx.core.view.InputDeviceCompat;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.ControllerConfigData;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import java.util.ArrayList;
import java.util.List;

public class Controllers {
    public static List<Controller> FindAllControllers(Context context) {
        ArrayList arrayList = new ArrayList();
        InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
        int[] deviceIds = InputDevice.getDeviceIds();
        int length = deviceIds.length;
        int i = 0;
        while (i < length) {
            InputDevice device = InputDevice.getDevice(deviceIds[i]);
            int sources = device.getSources();
            if (Build.VERSION.SDK_INT < 29) {
                try {
                    if (!((Boolean) InputDevice.class.getMethod("isExternal", new Class[0]).invoke(device, new Object[0])).booleanValue()) {
                        i++;
                    }
                } catch (Exception unused) {
                }
            } else if (!device.isExternal()) {
                i++;
            }
            boolean z = true;
            boolean z2 = (sources & 257) == 257;
            boolean z3 = (sources & InputDeviceCompat.SOURCE_GAMEPAD) == 1025;
            boolean z4 = (sources & InputDeviceCompat.SOURCE_JOYSTICK) == 16777232;
            boolean z5 = (sources & 8194) == 8194;
            if (Build.VERSION.SDK_INT < 26 || (sources & 131076) != 131076) {
                z = false;
            }
            if (z2 && !z3 && !z4) {
                CreateConfigForInputDevice(context, GetCurrentProfile, device, 12);
                i++;
            } else if (z3 && z4) {
                CreateConfigForInputDevice(context, GetCurrentProfile, device, 10);
                i++;
            } else if (z5 || z) {
                CreateConfigForInputDevice(context, GetCurrentProfile, device, 11);
                i++;
            } else {
                i++;
            }
        }
        for (ControllerConfigData next : GetCurrentProfile.controllersDatas) {
            Controller controller = new Controller();
            controller.SetData(next);
            for (int device2 : deviceIds) {
                if (next.Equals(InputDevice.getDevice(device2))) {
                    controller.SetOnline();
                }
            }
            arrayList.add(controller);
        }
        return arrayList;
    }

    private static void CreateConfigForInputDevice(Context context, InputConfigProfile inputConfigProfile, InputDevice inputDevice, int i) {
        ControllerConfigData GetControllerConfig = inputConfigProfile.GetControllerConfig(inputDevice);
        if (GetControllerConfig == null) {
            GetControllerConfig = new ControllerConfigData(inputDevice.getName());
            inputConfigProfile.AddController(GetControllerConfig);
        }
        GetControllerConfig.type = i;
        GetControllerConfig.vendorID = inputDevice.getVendorId();
        GetControllerConfig.deviceID = inputDevice.getProductId();
        switch (i) {
            case 10:
                GetControllerConfig.mac = TryRetrieveMac(context, inputDevice.getName());
                break;
            case 11:
            case 12:
                GetControllerConfig.mac = inputDevice.getDescriptor().substring(0, 16);
                break;
        }
        inputConfigProfile.Save();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String TryRetrieveMac(android.content.Context r2, java.lang.String r3) {
        /*
            android.bluetooth.BluetoothAdapter r0 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()
            java.lang.String r1 = "android.permission.BLUETOOTH_CONNECT"
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r2, r1)
            if (r2 == 0) goto L_0x003f
            java.util.Set r2 = r0.getBondedDevices()
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x003f
            java.util.Iterator r2 = r2.iterator()
        L_0x001a:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x003f
            java.lang.Object r0 = r2.next()
            android.bluetooth.BluetoothDevice r0 = (android.bluetooth.BluetoothDevice) r0
            java.lang.String r1 = r0.getName()
            boolean r1 = r1.contains(r3)
            if (r1 != 0) goto L_0x003a
            java.lang.String r1 = r0.getName()
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x001a
        L_0x003a:
            java.lang.String r2 = r0.getAddress()
            return r2
        L_0x003f:
            java.lang.String r2 = "No permission to get MAC"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.catfixture.inputbridge.core.input.devices.controller.Controllers.TryRetrieveMac(android.content.Context, java.lang.String):java.lang.String");
    }
}
