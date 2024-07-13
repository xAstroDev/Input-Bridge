package com.catfixture.inputbridge.core.GSS.SysDev.discovery;

public class ThermalSensorsDiscover {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c A[SYNTHETIC, Splitter:B:29:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence> Discover() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0092 }
            java.lang.String r2 = "/sys/class/thermal/"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0092 }
            java.io.File[] r1 = r1.listFiles()     // Catch:{ Exception -> 0x0092 }
            if (r1 != 0) goto L_0x0013
            return r0
        L_0x0013:
            int r2 = r1.length     // Catch:{ Exception -> 0x0092 }
            r3 = 0
        L_0x0015:
            if (r3 >= r2) goto L_0x0096
            r4 = r1[r3]     // Catch:{ Exception -> 0x0092 }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0092 }
            java.lang.String r6 = "type"
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x0092 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0092 }
            java.lang.String r7 = "temp"
            r6.<init>(r4, r7)     // Catch:{ Exception -> 0x0092 }
            boolean r4 = r6.exists()     // Catch:{ Exception -> 0x0092 }
            if (r4 == 0) goto L_0x008f
            boolean r4 = r5.exists()     // Catch:{ Exception -> 0x0092 }
            if (r4 == 0) goto L_0x008f
            r4 = 0
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x008a }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x008a }
            java.lang.String r8 = "r"
            r7.<init>(r5, r8)     // Catch:{ Exception -> 0x008a }
            java.lang.String r4 = r7.readLine()     // Catch:{ Exception -> 0x0089 }
            java.util.Locale r5 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = r4.toLowerCase(r5)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r5 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r6 = "cpu"
            boolean r6 = r4.contains(r6)     // Catch:{ Exception -> 0x0089 }
            if (r6 == 0) goto L_0x0060
            com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence r6 = new com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence     // Catch:{ Exception -> 0x0089 }
            r8 = 20
            r6.<init>(r8, r5, r4)     // Catch:{ Exception -> 0x0089 }
            r0.add(r6)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0085
        L_0x0060:
            java.lang.String r6 = "gpu"
            boolean r6 = r4.contains(r6)     // Catch:{ Exception -> 0x0089 }
            if (r6 == 0) goto L_0x0073
            com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence r6 = new com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence     // Catch:{ Exception -> 0x0089 }
            r8 = 23
            r6.<init>(r8, r5, r4)     // Catch:{ Exception -> 0x0089 }
            r0.add(r6)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0085
        L_0x0073:
            java.lang.String r6 = "bat"
            boolean r6 = r4.contains(r6)     // Catch:{ Exception -> 0x0089 }
            if (r6 == 0) goto L_0x0085
            com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence r6 = new com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence     // Catch:{ Exception -> 0x0089 }
            r8 = 26
            r6.<init>(r8, r5, r4)     // Catch:{ Exception -> 0x0089 }
            r0.add(r6)     // Catch:{ Exception -> 0x0089 }
        L_0x0085:
            r7.close()     // Catch:{ Exception -> 0x0089 }
            goto L_0x008f
        L_0x0089:
            r4 = r7
        L_0x008a:
            if (r4 == 0) goto L_0x008f
            r4.close()     // Catch:{ Exception -> 0x0092 }
        L_0x008f:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0092:
            r1 = move-exception
            com.catfixture.inputbridge.core.debug.D.E((java.lang.Throwable) r1)
        L_0x0096:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.catfixture.inputbridge.core.GSS.SysDev.discovery.ThermalSensorsDiscover.Discover():java.util.List");
    }
}
