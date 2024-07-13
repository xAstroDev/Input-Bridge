package com.catfixture.inputbridge.core.input.data;

import com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence;
import com.catfixture.inputbridge.core.context.ConfigContext;
import java.util.ArrayList;
import java.util.List;

public class InputConfigData {
    public String appFolder = "Download";
    public long appLaunchedDateTime;
    public boolean autoCheckUpdates = true;
    public int currentGamepadEditorTab;
    public int currentKeyboardEditorTab;
    public int currentMainTab;
    public int currentProfile = -1;
    public boolean debugEnabled;
    public int internalProfileID;
    public int language;
    public List<InputConfigProfile> profiles = new ArrayList();
    public List<SensorPresence> sensorsSet = new ArrayList();
    public int touchEditorPosition;
    public String updateServerAddr;

    public void SetUpdateServerAddr(String str) {
        this.updateServerAddr = str;
        Save();
    }

    public void SetTouchEditorPosition(int i) {
        this.touchEditorPosition = i;
    }

    public void Save() {
        ConfigContext.Save();
    }

    public void AddProfile(InputConfigProfile inputConfigProfile) {
        this.profiles.add(inputConfigProfile);
        Save();
    }

    public void RemoveProfile(int i) {
        this.profiles.remove(i);
        Save();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.currentProfile;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean HasCurrentProfile() {
        /*
            r2 = this;
            java.util.List<com.catfixture.inputbridge.core.input.data.InputConfigProfile> r0 = r2.profiles
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0016
            int r0 = r2.currentProfile
            if (r0 < 0) goto L_0x0016
            java.util.List<com.catfixture.inputbridge.core.input.data.InputConfigProfile> r1 = r2.profiles
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.catfixture.inputbridge.core.input.data.InputConfigData.HasCurrentProfile():boolean");
    }

    public InputConfigProfile GetCurrentProfile() {
        if (HasCurrentProfile()) {
            return this.profiles.get(this.currentProfile);
        }
        return null;
    }

    public InputConfigProfile FindProfileByID(Integer num) {
        int i = 0;
        for (InputConfigProfile next : this.profiles) {
            int i2 = i + 1;
            if (i == num.intValue()) {
                return next;
            }
            i = i2;
        }
        return null;
    }

    public void RemoveCurrentProfile() {
        if (HasCurrentProfile()) {
            this.profiles.remove(this.currentProfile);
            if (this.profiles.size() == 0) {
                this.currentProfile = -1;
            } else {
                this.currentProfile = this.profiles.size() - 1;
            }
            Save();
        }
    }

    public void SetCurrentProfile(int i) {
        this.currentProfile = i;
        Save();
    }

    public void SetLanguage(int i) {
        this.language = i;
        Save();
    }

    public void SetCurrentMainTab(int i) {
        this.currentMainTab = i;
        Save();
    }

    public void SetCurrentGamepadEditorTab(int i) {
        this.currentGamepadEditorTab = i;
        Save();
    }

    public void SetCurrentKeyboardEditorTab(int i) {
        this.currentKeyboardEditorTab = i;
        Save();
    }

    public void ToggleDebugging(boolean z) {
        this.debugEnabled = z;
        Save();
    }

    public void ToggleAutoCheckUpdates(boolean z) {
        this.autoCheckUpdates = z;
        Save();
    }

    public void SetAppLaunchedDate(long j) {
        this.appLaunchedDateTime = j;
        Save();
    }

    public void SetAppFolder(String str) {
        this.appFolder = str;
        Save();
    }

    public void AddSensorToSet(SensorPresence sensorPresence) {
        this.sensorsSet.add(sensorPresence);
        Save();
    }

    public void RemoveSensorFromSet(SensorPresence sensorPresence) {
        this.sensorsSet.remove(sensorPresence);
        Save();
    }
}
