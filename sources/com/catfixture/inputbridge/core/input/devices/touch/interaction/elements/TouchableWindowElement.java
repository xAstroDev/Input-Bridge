package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.colorpicker.Colorut;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.utils.EventUtils;
import com.catfixture.inputbridge.core.input.utils.IDraggable;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.core.input.utils.ITouchable;
import com.catfixture.inputbridge.core.input.utils.ITransformable;
import com.catfixture.inputbridge.core.utils.math.Int2;
import com.catfixture.inputbridge.core.utils.types.Event;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import java.util.Observable;

public abstract class TouchableWindowElement extends View implements IInputWindowElement, ITouchable, IDraggable, ITransformable {
    protected ColorFilter colorFilter;
    protected Context context;
    protected InputTouchControlElementData data;
    private Action<Boolean> editorReset;
    private TouchableWindowElement handle;
    protected Int2 initialSize = new Int2(100, 100);
    protected boolean isSelected;
    protected boolean isTouched;
    protected RelativeLayout.LayoutParams lp;
    public Event onClick = new Event();
    public Event onDown = new Event();
    public Event onEnter = new Event();
    public Event onExit = new Event();
    public Event onMove = new Event();
    public Event onUp = new Event();
    private final Int2 pos = new Int2(0, 0);
    private InputConfigProfile profile;
    Runnable reinflate;
    protected int tintColor = -12369085;
    protected PorterDuffColorFilter tintPduff;

    public abstract void CreateEditorEvents();

    public abstract void CreateEventActions(IInputDevice iInputDevice);

    /* access modifiers changed from: protected */
    public void Save() {
    }

    /* access modifiers changed from: protected */
    public void CheckApplyMultPduff(Paint paint) {
        if (this.data.customIcon.iconFineTuneData.tintColor.color != -1) {
            int i = this.data.customIcon.iconFineTuneData.tintColor.color;
            if (this.isTouched) {
                i = Colorut.MultARGB(i, this.tintColor);
            }
            paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.MULTIPLY));
        }
    }

    public TouchableWindowElement(Context context2, InputTouchControlElementData inputTouchControlElementData) {
        super(context2);
        this.context = context2;
        this.data = inputTouchControlElementData;
        Init();
        this.profile = ConfigContext.data.GetCurrentProfile();
        try {
            this.tintColor = ConfigContext.data.GetCurrentProfile().pressTintColor.color;
        } catch (Exception unused) {
        }
        this.tintPduff = new PorterDuffColorFilter(this.tintColor, PorterDuff.Mode.MULTIPLY);
        this.colorFilter = new PorterDuffColorFilter(inputTouchControlElementData.customIcon.iconFineTuneData.tintColor.color, PorterDuff.Mode.MULTIPLY);
    }

    private void Init() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        this.lp = layoutParams;
        layoutParams.leftMargin = 0;
        this.lp.topMargin = 0;
        EventUtils.InitializeITouchableEvents(this, this);
        SetSize(-1, -1);
    }

    public TouchableWindowElement(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
    }

    public TouchableWindowElement(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
    }

    public int GetId() {
        return this.data.id;
    }

    public IInputWindowElement SetAlpha(float f) {
        InputConfigProfile inputConfigProfile = this.profile;
        setAlpha(f * ((inputConfigProfile != null ? (float) inputConfigProfile.uiOpacity : 100.0f) / 100.0f));
        return this;
    }

    public IInputWindowElement SetScale(int i) {
        float f = ((float) i) / 100.0f;
        SetSize((int) (((float) this.initialSize.x) * f), (int) (((float) this.initialSize.y) * f));
        return this;
    }

    public IInputWindowElement SetSize(int i, int i2) {
        this.lp.width = i;
        this.lp.height = i2;
        setLayoutParams(this.lp);
        return this;
    }

    public IInputWindowElement SetInitialSize(int i, int i2) {
        this.initialSize.Set((float) i, (float) i2);
        return this;
    }

    public void SetPosition(int i, int i2) {
        this.lp.leftMargin = i;
        this.lp.topMargin = i2;
        setLayoutParams(this.lp);
    }

    public Int2 GetPosition() {
        return new Int2(this.lp.leftMargin, this.lp.topMargin);
    }

    public Int2 GetSize() {
        return new Int2(this.lp.width, this.lp.height);
    }

    public Object GetData() {
        return this.data;
    }

    public TouchableWindowElement GetHandle() {
        return this.handle;
    }

    public void SetHandle(TouchableWindowElement touchableWindowElement) {
        this.handle = touchableWindowElement;
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

    public void SetReinflate(Runnable runnable) {
        this.reinflate = runnable;
    }

    public void Reinflate() {
        this.reinflate.run();
    }

    public void SetEditorReset(Action<Boolean> action) {
        this.editorReset = action;
    }

    public void ResetEditor(boolean z) {
        this.editorReset.Invoke(Boolean.valueOf(z));
    }

    public Event OnEnter() {
        return this.onEnter;
    }

    public Event OnExit() {
        return this.onExit;
    }

    public void InitEditorAppearance(boolean z) {
        if (z) {
            setBackgroundResource(R.color.whiteTrans);
        }
    }

    public void CreateActionDecorations(InputConfigProfile inputConfigProfile) {
        this.onDown.addObserver(new TouchableWindowElement$$ExternalSyntheticLambda1(this, inputConfigProfile, AppContext.app.vibrator));
        this.onUp.addObserver(new TouchableWindowElement$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateActionDecorations$0$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-TouchableWindowElement  reason: not valid java name */
    public /* synthetic */ void m52lambda$CreateActionDecorations$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsTouchableWindowElement(InputConfigProfile inputConfigProfile, Vibrator vibrator, Observable observable, Object obj) {
        this.isTouched = true;
        invalidate();
        if (inputConfigProfile.enableTouchRumble && inputConfigProfile.touchRumbleImpetusTime > 0 && vibrator != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot((long) inputConfigProfile.touchRumbleImpetusTime, -1));
            } else {
                vibrator.vibrate((long) inputConfigProfile.touchRumbleImpetusTime);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateActionDecorations$1$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-TouchableWindowElement  reason: not valid java name */
    public /* synthetic */ void m53lambda$CreateActionDecorations$1$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsTouchableWindowElement(Observable observable, Object obj) {
        this.isTouched = false;
        invalidate();
    }

    public void Select(ViewGroup viewGroup) {
        this.isSelected = true;
    }

    public void Deselect() {
        boolean z = this.isSelected;
        this.isSelected = false;
        if (z) {
            invalidate();
        }
    }
}
