package com.catfixture.inputbridge.ui.activity.editors.touchEditor;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.internal.view.SupportMenu;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.Const;
import com.catfixture.inputbridge.core.colorpicker.ColorPickerUtils;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.input.codes.MouseCodes;
import com.catfixture.inputbridge.core.input.codes.XInputCodes;
import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.TouchDeviceOverlayFragment;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.FineTuneEditor;
import com.catfixture.inputbridge.core.input.utils.DragAndDropHandle;
import com.catfixture.inputbridge.core.input.utils.EventUtils;
import com.catfixture.inputbridge.core.input.utils.IDraggable;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.core.input.utils.ITouchable;
import com.catfixture.inputbridge.core.input.utils.ITransformable;
import com.catfixture.inputbridge.core.localization.Languages;
import com.catfixture.inputbridge.core.utils.ModeSwitcher;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.android.IActivityLaunchable;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.math.Int2;
import com.catfixture.inputbridge.core.utils.types.Event;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.core.weakmsg.WeakMsg;
import com.catfixture.inputbridge.ui.custom.Crosshair;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class TouchEditorActivity extends AppCompatActivity implements ITransformable, ITouchable, IDraggable, IActivityLaunchable {
    /* access modifiers changed from: private */
    public InputConfigData cfg;
    private RelativeLayout controlsView;
    private ImageView copyElementStyleTool;
    private ImageView copyElementTool;
    private IInputWindowElement copyPasteElement;
    private IInputWindowElement copyPasteElementStyle;
    private View createControl;
    private ViewGroup customContainer;
    private LinearLayout editorBgColor;
    private ViewGroup editorWin;
    private Object fineTuneData;
    private IInputWindowElement fineTuneParentItem;
    private int fineTuneType;
    private SeekBar globalSensivity;
    /* access modifiers changed from: private */
    public TextView globalSensivityText;
    private Float2 lastTouchPos = new Float2(250.0f, 250.0f);
    private ActivityResultLauncher<Intent> launchSomeActivity;
    private ModeSwitcher modeSwitcher = new ModeSwitcher();
    private View noItemErr;
    public Event onClick = new Event();
    public Event onDown = new Event();
    public Event onMove = new Event();
    private Action<ActivityResult> onResult;
    public Event onUp = new Event();
    private ImageView pasteElementStyleTool;
    private ImageView pasteElementTool;
    private Int2 posCache = new Int2(0, 0);
    private LinearLayout pressTintColor;
    private RelativeLayout root;
    private CheckBox screenAsMouse;
    private Size screenSize = new Size(0, 0);
    private int selectedItemId = -1;
    private CheckBox showBackground;
    private ImageView showToolbar;
    private SeekBar snappingSize;
    /* access modifiers changed from: private */
    public TextView snappingSizeText;
    private Button toggleSettings;
    private LinearLayout toolbar;
    private LinearLayout toolbarRoot;
    private int toolbarWidth = -1;
    private SeekBar uiOpacity;
    /* access modifiers changed from: private */
    public TextView uiOpacityText;
    private final List<IInputWindowElement> windowElements = new ArrayList();

    static /* synthetic */ void lambda$onCreate$13() {
    }

    public Int2 GetSize() {
        return null;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AndroidUtils.HideSystemUI(getWindow().getDecorView());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.launchSomeActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new TouchEditorActivity$$ExternalSyntheticLambda3(this));
        if (!ConfigContext.data.HasCurrentProfile()) {
            onBackPressed();
            return;
        }
        InputConfigData inputConfigData = ConfigContext.data;
        this.cfg = inputConfigData;
        InputConfigProfile GetCurrentProfile = inputConfigData.GetCurrentProfile();
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(this, R.layout.activity_editor, (ViewGroup) null);
        this.root = relativeLayout;
        setContentView((View) relativeLayout);
        this.screenSize = AndroidUtils.GetRealDisplaySize(getWindowManager());
        this.root.setOnTouchListener(new TouchEditorActivity$$ExternalSyntheticLambda26(this));
        Float2 float2 = this.cfg.GetCurrentProfile().lastTouchPos;
        if (float2.x == 0.0f && float2.y == 0.0f) {
            Size GetRealDisplaySize = AndroidUtils.GetRealDisplaySize((WindowManager) getSystemService(WindowManager.class));
            Float2 float22 = new Float2(((float) GetRealDisplaySize.getWidth()) / 2.0f, ((float) GetRealDisplaySize.getHeight()) / 2.0f);
            this.lastTouchPos = float22;
            UpdateCrosshair(float22);
        } else {
            Float2 float23 = this.cfg.GetCurrentProfile().lastTouchPos;
            this.lastTouchPos = float23;
            UpdateCrosshair(float23);
        }
        this.editorWin = (ViewGroup) this.root.findViewById(R.id.editorWin);
        this.controlsView = (RelativeLayout) this.root.findViewById(R.id.controlsView);
        this.toggleSettings = (Button) this.root.findViewById(R.id.editorSettings);
        this.noItemErr = this.root.findViewById(R.id.noItemErr);
        this.createControl = this.root.findViewById(R.id.createControl);
        this.customContainer = (ViewGroup) this.root.findViewById(R.id.customContainer);
        ViewGroup viewGroup = (ViewGroup) this.root.findViewById(R.id.fineTuneContainer);
        this.uiOpacity = (SeekBar) this.root.findViewById(R.id.uiOpacity);
        this.uiOpacityText = (TextView) this.root.findViewById(R.id.uiOpacityText);
        this.globalSensivity = (SeekBar) this.root.findViewById(R.id.globalSensivity);
        this.globalSensivityText = (TextView) this.root.findViewById(R.id.globalSensivityText);
        this.screenAsMouse = (CheckBox) this.root.findViewById(R.id.screenAsMouse);
        this.showBackground = (CheckBox) this.root.findViewById(R.id.showBackground);
        this.snappingSizeText = (TextView) this.root.findViewById(R.id.snappingSizeText);
        this.snappingSize = (SeekBar) this.root.findViewById(R.id.snappingSize);
        this.pressTintColor = (LinearLayout) this.root.findViewById(R.id.pressTintColor);
        this.editorBgColor = (LinearLayout) this.root.findViewById(R.id.editorBgColor);
        this.showToolbar = (ImageView) this.root.findViewById(R.id.showToolbar);
        LinearLayout linearLayout = (LinearLayout) this.root.findViewById(R.id.toolbar);
        this.toolbar = linearLayout;
        linearLayout.measure(0, 0);
        this.toolbarWidth = this.toolbar.getMeasuredWidth();
        this.showToolbar.setOnClickListener(new TouchEditorActivity$$ExternalSyntheticLambda24(this, GetCurrentProfile));
        ((TextView) this.noItemErr.findViewById(R.id.text)).setTextColor(getColor(R.color.white));
        EventUtils.InitializeITouchableEvents(this.editorWin, this);
        this.toggleSettings.setOnClickListener(new TouchEditorActivity$$ExternalSyntheticLambda21(this));
        this.toggleSettings.setOnLongClickListener(new TouchEditorActivity$$ExternalSyntheticLambda25(this));
        ((Button) this.root.findViewById(R.id.exit)).setOnClickListener(new TouchEditorActivity$$ExternalSyntheticLambda22(this));
        this.createControl.setOnClickListener(new TouchEditorActivity$$ExternalSyntheticLambda23(this));
        this.uiOpacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                TouchEditorActivity.this.cfg.GetCurrentProfile().SetUiOpacity(i);
                TouchEditorActivity.this.uiOpacityText.setText(TouchEditorActivity.this.getString(R.string.ui_opacity, new Object[]{Integer.valueOf(i)}));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                TouchEditorActivity.this.m143lambda$onCreate$14$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity();
            }
        });
        this.globalSensivity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                TouchEditorActivity.this.cfg.GetCurrentProfile().SetGlobalSensitivity(i);
                TouchEditorActivity.this.globalSensivityText.setText(TouchEditorActivity.this.getString(R.string.global_sensivity, new Object[]{Integer.valueOf(i)}));
            }
        });
        this.screenAsMouse.setOnCheckedChangeListener(new TouchEditorActivity$$ExternalSyntheticLambda1(this));
        this.showBackground.setOnCheckedChangeListener(new TouchEditorActivity$$ExternalSyntheticLambda2(this));
        this.snappingSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                TouchEditorActivity.this.cfg.GetCurrentProfile().SetSnappingSize(i);
                TouchEditorActivity.this.snappingSizeText.setText(TouchEditorActivity.this.getString(R.string.snapping_size_text, new Object[]{Integer.valueOf(i)}));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                TouchEditorActivity.this.m143lambda$onCreate$14$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity();
            }
        });
        DragAndDropHandle dragAndDropHandle = new DragAndDropHandle(this);
        dragAndDropHandle.onDragged.addObserver(new TouchEditorActivity$$ExternalSyntheticLambda18(this));
        dragAndDropHandle.onPositionChanged.addObserver(new TouchEditorActivity$$ExternalSyntheticLambda17(this));
        m143lambda$onCreate$14$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity();
        InitToolbar();
        ToggleToolbar(GetCurrentProfile.isToolbarShown);
        this.root.post(new TouchEditorActivity$$ExternalSyntheticLambda10(this));
        this.modeSwitcher.AddMode(0, (ViewGroup) this.root.findViewById(R.id.controlsContainer), TouchEditorActivity$$ExternalSyntheticLambda16.INSTANCE);
        this.modeSwitcher.AddMode(1, (ViewGroup) this.root.findViewById(R.id.settingsContainer), new TouchEditorActivity$$ExternalSyntheticLambda13(this), new TouchEditorActivity$$ExternalSyntheticLambda14(this));
        this.modeSwitcher.AddMode(2, viewGroup, new TouchEditorActivity$$ExternalSyntheticLambda15(this, viewGroup));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$0$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m138lambda$onCreate$0$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(ActivityResult activityResult) {
        Action<ActivityResult> action = this.onResult;
        if (action != null) {
            action.Invoke(activityResult);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$1$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ boolean m139lambda$onCreate$1$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return true;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        ResetSelection();
        this.modeSwitcher.SetMode(0);
        this.lastTouchPos = new Float2(motionEvent.getX(), motionEvent.getY());
        this.cfg.GetCurrentProfile().SetLastTouchPos(this.lastTouchPos);
        UpdateCrosshair(this.lastTouchPos);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$2$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m147lambda$onCreate$2$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(InputConfigProfile inputConfigProfile, View view) {
        inputConfigProfile.isToolbarShown = !inputConfigProfile.isToolbarShown;
        inputConfigProfile.Save();
        ToggleToolbar(inputConfigProfile.isToolbarShown);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$3$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m148lambda$onCreate$3$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(View view) {
        ToggleSettingsView();
        ResetSelection();
        InitEditorView();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$4$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ boolean m149lambda$onCreate$4$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(View view) {
        this.modeSwitcher.SetMode(3);
        ResetSelection();
        InitEditorView();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$5$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m150lambda$onCreate$5$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$6$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m151lambda$onCreate$6$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(View view) {
        InputConfigProfile GetCurrentProfile = this.cfg.GetCurrentProfile();
        int GetInternalId = GetCurrentProfile.GetInternalId();
        GetCurrentProfile.AddControlElement(GetInternalId, this.lastTouchPos);
        m143lambda$onCreate$14$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity();
        SetSelected(GetInternalId);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$7$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m152lambda$onCreate$7$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(CompoundButton compoundButton, boolean z) {
        this.cfg.GetCurrentProfile().SetScreenAsMouse(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$8$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m153lambda$onCreate$8$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(CompoundButton compoundButton, boolean z) {
        this.cfg.GetCurrentProfile().SetShowBackground(z);
        m143lambda$onCreate$14$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$9$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m154lambda$onCreate$9$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(Observable observable, Object obj) {
        SetToolbarPos(((Int2) obj).x, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$10$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m140lambda$onCreate$10$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(Observable observable, Object obj) {
        this.cfg.SetTouchEditorPosition(((Int2) obj).x);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$12$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m142lambda$onCreate$12$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity() {
        SetPosition(this.cfg.touchEditorPosition, 0);
        this.root.post(new TouchEditorActivity$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$11$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m141lambda$onCreate$11$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity() {
        SetToolbarPos(this.cfg.touchEditorPosition, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$15$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m144lambda$onCreate$15$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity() {
        this.toggleSettings.getBackground().setColorFilter(getColor(R.color.lightGray), PorterDuff.Mode.MULTIPLY);
        this.toggleSettings.setTextColor(getColor(R.color.orangeSat));
        InputConfigProfile GetCurrentProfile = this.cfg.GetCurrentProfile();
        int i = GetCurrentProfile.uiOpacity;
        this.uiOpacity.setProgress(i);
        this.uiOpacityText.setText(getString(R.string.ui_opacity, new Object[]{Integer.valueOf(i)}));
        int i2 = GetCurrentProfile.globalSensivity;
        this.globalSensivity.setProgress(i2);
        this.globalSensivityText.setText(getString(R.string.global_sensivity, new Object[]{Integer.valueOf(i2)}));
        int i3 = GetCurrentProfile.snappingSize;
        this.snappingSize.setProgress(i3);
        this.snappingSizeText.setText(getString(R.string.snapping_size_text, new Object[]{Integer.valueOf(i3)}));
        this.screenAsMouse.setChecked(GetCurrentProfile.screenAsMouse);
        this.showBackground.setChecked(GetCurrentProfile.showBackground);
        ColorPickerUtils.InitColorPicker(this, "Press tint color", this.pressTintColor, GetCurrentProfile.pressTintColor, (Runnable) null);
        ColorPickerUtils.InitColorPicker(this, "Editor background", this.editorBgColor, GetCurrentProfile.editorBgColor, new TouchEditorActivity$$ExternalSyntheticLambda12(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$16$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m145lambda$onCreate$16$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity() {
        this.toggleSettings.getBackground().setColorFilter((ColorFilter) null);
        this.toggleSettings.setTextColor(getColor(R.color.white));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$17$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m146lambda$onCreate$17$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(ViewGroup viewGroup) {
        FineTuneEditor.Load(this.fineTuneParentItem, viewGroup, this.fineTuneType, this.fineTuneData);
    }

    private void InitToolbar() {
        this.copyElementTool = (ImageView) this.toolbar.findViewById(R.id.copyElementTool);
        this.copyElementStyleTool = (ImageView) this.toolbar.findViewById(R.id.copyElementStyleTool);
        this.pasteElementTool = (ImageView) this.toolbar.findViewById(R.id.pasteElementTool);
        this.pasteElementStyleTool = (ImageView) this.toolbar.findViewById(R.id.pasteElementStyleTool);
        this.copyElementTool.setOnClickListener(new TouchEditorActivity$$ExternalSyntheticLambda0(this));
        this.pasteElementTool.setOnClickListener(new TouchEditorActivity$$ExternalSyntheticLambda11(this));
        this.copyElementStyleTool.setOnClickListener(new TouchEditorActivity$$ExternalSyntheticLambda19(this));
        this.pasteElementStyleTool.setOnClickListener(new TouchEditorActivity$$ExternalSyntheticLambda20(this));
        SwitchToolbarCopyToolsToGone();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InitToolbar$19$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m131lambda$InitToolbar$19$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(View view) {
        TryGetWindowElementById(this.selectedItemId, new TouchEditorActivity$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InitToolbar$18$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m130lambda$InitToolbar$18$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(IInputWindowElement iInputWindowElement) {
        this.copyPasteElement = iInputWindowElement;
        SetPasteElementToolEnabled(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InitToolbar$20$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m132lambda$InitToolbar$20$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(View view) {
        IInputWindowElement iInputWindowElement = this.copyPasteElement;
        if (iInputWindowElement == null) {
            SetPasteElementToolEnabled(false);
            return;
        }
        InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) AndroidUtils.DeepClone(iInputWindowElement.GetData(), InputTouchControlElementData.class);
        InputConfigProfile GetCurrentProfile = this.cfg.GetCurrentProfile();
        inputTouchControlElementData.SetId(GetCurrentProfile.GetInternalId());
        Int2 GetSize = this.copyPasteElement.GetSize();
        inputTouchControlElementData.SetPosition(new Int2(((int) GetCurrentProfile.lastTouchPos.x) - (GetSize.x / 2), ((int) GetCurrentProfile.lastTouchPos.y) - (GetSize.y / 2)));
        this.cfg.GetCurrentProfile().touchControlElements.add(inputTouchControlElementData);
        m143lambda$onCreate$14$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity();
        SetSelected(inputTouchControlElementData.id);
        this.copyPasteElement = null;
        SetPasteElementToolEnabled(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InitToolbar$22$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m134lambda$InitToolbar$22$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(View view) {
        TryGetWindowElementById(this.selectedItemId, new TouchEditorActivity$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InitToolbar$21$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m133lambda$InitToolbar$21$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(IInputWindowElement iInputWindowElement) {
        this.copyPasteElementStyle = iInputWindowElement;
        SetPasteElementStyleToolEnabled(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InitToolbar$24$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m136lambda$InitToolbar$24$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(View view) {
        if (this.copyPasteElementStyle == null) {
            SetPasteElementStyleToolEnabled(false);
            return;
        }
        TryGetWindowElementById(this.selectedItemId, new TouchEditorActivity$$ExternalSyntheticLambda6(this));
        this.copyPasteElementStyle = null;
        SetPasteElementStyleToolEnabled(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InitToolbar$23$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m135lambda$InitToolbar$23$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(IInputWindowElement iInputWindowElement) {
        try {
            ((InputTouchControlElementData) iInputWindowElement.GetData()).CopyStyle((InputTouchControlElementData) this.copyPasteElementStyle.GetData());
            this.copyPasteElementStyle = null;
            iInputWindowElement.Reinflate();
        } catch (Exception unused) {
            D.E("Err can't copy style!");
        }
    }

    private void SetPasteElementToolEnabled(boolean z) {
        this.pasteElementTool.setEnabled(z);
        if (z) {
            this.pasteElementTool.setColorFilter((ColorFilter) null);
        } else {
            this.pasteElementTool.setColorFilter(-7829368);
        }
    }

    private void SetPasteElementStyleToolEnabled(boolean z) {
        this.pasteElementStyleTool.setEnabled(z);
        if (z) {
            this.pasteElementStyleTool.setColorFilter((ColorFilter) null);
        } else {
            this.pasteElementStyleTool.setColorFilter(-7829368);
        }
    }

    private void SetCopyElementToolEnabled(boolean z) {
        this.copyElementTool.setEnabled(z);
        if (z) {
            this.copyElementTool.setColorFilter((ColorFilter) null);
        } else {
            this.copyElementTool.setColorFilter(-7829368);
        }
    }

    private void SetCopyElementStyleToolEnabled(boolean z) {
        this.copyElementStyleTool.setEnabled(z);
        if (z) {
            this.copyElementStyleTool.setColorFilter((ColorFilter) null);
        } else {
            this.copyElementStyleTool.setColorFilter(-7829368);
        }
    }

    private void SwitchToolbarCopyToolsToGone() {
        SetCopyElementToolEnabled(false);
        SetCopyElementStyleToolEnabled(false);
    }

    private void SetToolbarPos(int i, int i2) {
        int width = this.editorWin.getWidth();
        int width2 = this.screenSize.getWidth();
        int i3 = this.toolbarWidth;
        int i4 = i - i3;
        if (i4 >= (-i3)) {
            if (i4 < 0) {
                width += i;
            } else {
                int i5 = width2 - width;
                width = i4 > i5 - i3 ? i5 - i3 : i4;
            }
        }
        this.toolbar.setX((float) width);
        this.toolbar.setY((float) i2);
    }

    private void ToggleToolbar(boolean z) {
        if (z) {
            this.showToolbar.setColorFilter(SupportMenu.CATEGORY_MASK);
            this.toolbar.setVisibility(0);
            SetPasteElementToolEnabled(false);
            SetPasteElementStyleToolEnabled(false);
            return;
        }
        this.showToolbar.setColorFilter((ColorFilter) null);
        this.toolbar.setVisibility(8);
        SetPasteElementToolEnabled(false);
        SetPasteElementStyleToolEnabled(false);
        SwitchToolbarCopyToolsToGone();
    }

    private void UpdateCrosshair(Float2 float2) {
        ((Crosshair) this.root.findViewById(R.id.mainCrosshair)).SetXY((int) float2.x, (int) float2.y);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.cfg.GetCurrentProfile().Save();
        this.windowElements.clear();
        WeakMsg.Send((Context) this, (int) Const.BCAST_ACTION_UPDATE_AFTER_EDITOR_EDIT);
        try {
            System.gc();
        } catch (Exception unused) {
        }
    }

    /* renamed from: UpdateAll */
    public void m143lambda$onCreate$14$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity() {
        TouchDeviceOverlayFragment.InflateControls(this, (IInputDevice) null, this.controlsView, this.windowElements, true, new TouchEditorActivity$$ExternalSyntheticLambda8(this));
        InitEditorView();
    }

    public void ToggleSettingsView() {
        ModeSwitcher modeSwitcher2 = this.modeSwitcher;
        modeSwitcher2.SetMode(modeSwitcher2.GetMode() == 0 ? 1 : 0);
    }

    private void InitEditorView() {
        boolean HasCurrentProfile = this.cfg.HasCurrentProfile();
        int i = 0;
        boolean z = HasCurrentProfile && this.selectedItemId != -1;
        this.noItemErr.setVisibility((z || !HasCurrentProfile) ? 8 : 0);
        this.customContainer.setVisibility(z ? 0 : 8);
        View view = this.createControl;
        if (!HasCurrentProfile || this.selectedItemId != -1) {
            i = 8;
        }
        view.setVisibility(i);
        this.root.setBackgroundColor(this.cfg.GetCurrentProfile().editorBgColor.color);
    }

    private void ResetSelection() {
        this.selectedItemId = -1;
        this.customContainer.removeAllViews();
        DeselectAll();
        InitEditorView();
    }

    public void DeselectAll() {
        SwitchToolbarCopyToolsToGone();
        for (IInputWindowElement Deselect : this.windowElements) {
            try {
                Deselect.Deselect();
            } catch (Exception unused) {
            }
        }
    }

    public void SetSelected(int i) {
        if (i == -2) {
            ResetSelection();
        } else if (i == -1) {
            int i2 = this.selectedItemId;
            if (i2 != -1) {
                SetSelected(i2);
            }
        } else {
            ResetSelection();
            this.selectedItemId = i;
            InitEditorView();
            if (this.modeSwitcher.GetMode() == 2) {
                this.modeSwitcher.SetMode(0);
            }
            SetCopyElementToolEnabled(true);
            SetCopyElementStyleToolEnabled(true);
            TryGetWindowElementById(i, new TouchEditorActivity$$ExternalSyntheticLambda7(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetSelected$25$com-catfixture-inputbridge-ui-activity-editors-touchEditor-TouchEditorActivity  reason: not valid java name */
    public /* synthetic */ void m137lambda$SetSelected$25$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity(IInputWindowElement iInputWindowElement) {
        iInputWindowElement.Select(this.customContainer);
    }

    /* access modifiers changed from: package-private */
    public void TryGetWindowElementById(int i, Action<IInputWindowElement> action) {
        for (IInputWindowElement next : this.windowElements) {
            if (next.GetId() == i) {
                action.Invoke(next);
                return;
            }
        }
    }

    public void DropContent(int i) {
        m143lambda$onCreate$14$comcatfixtureinputbridgeuiactivityeditorstouchEditorTouchEditorActivity();
        SetSelected(i);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(Languages.CreateLanguageCTXWrapper(context));
        MouseCodes.Load(this);
        XInputCodes.Load(this);
    }

    public Event OnDown() {
        return this.onDown;
    }

    public Event OnMove() {
        return this.onMove;
    }

    public Event OnUp() {
        return this.onUp;
    }

    public Event OnClick() {
        return this.onClick;
    }

    public Event OnEnter() {
        return this.onMove;
    }

    public Event OnExit() {
        return this.onMove;
    }

    public Int2 GetPosition() {
        return this.posCache;
    }

    public void SetPosition(int i, int i2) {
        Int2 int2 = new Int2(Math.min(Math.max(i, 0), this.screenSize.getWidth() - this.editorWin.getWidth()), 0);
        this.posCache = int2;
        ViewGroup viewGroup = this.editorWin;
        if (viewGroup != null) {
            LayoutUtils.SetRelativeLayoutPos(viewGroup, int2.x, 0);
        }
    }

    public void Launch(Intent intent, Action<ActivityResult> action) {
        this.onResult = action;
        this.launchSomeActivity.launch(intent);
    }

    public void ToggleFineTuneView(IInputWindowElement iInputWindowElement, int i, Object obj) {
        this.fineTuneParentItem = iInputWindowElement;
        this.fineTuneType = i;
        this.fineTuneData = obj;
        this.modeSwitcher.SetMode(2);
    }
}
