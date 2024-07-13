package com.catfixture.inputbridge.ui.activity.editors.common.rebindings.fragments.buttons;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.catfixture.inputbridge.ui.activity.editors.common.IEditor;
import com.catfixture.inputbridge.ui.activity.editors.common.rebindings.common.CommonEditorFragment;
import java.util.Observable;
import java.util.Observer;

public class ButtonsFragment extends CommonEditorFragment {
    private LinearLayoutManager layman;
    private Observer onNewButton;

    /* access modifiers changed from: protected */
    public void UpdateBindings() {
    }

    public void onResume() {
    }

    public ButtonsFragment(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public void Init() {
        super.Init();
        this.onNewButton = new ButtonsFragment$$ExternalSyntheticLambda0(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Init$0$com-catfixture-inputbridge-ui-activity-editors-common-rebindings-fragments-buttons-ButtonsFragment  reason: not valid java name */
    public /* synthetic */ void m124lambda$Init$0$comcatfixtureinputbridgeuiactivityeditorscommonrebindingsfragmentsbuttonsButtonsFragment(Observable observable, Object obj) {
        this.selectedItem = ((Integer) obj).intValue();
        UpdateBindings();
    }

    public View OnCreate() {
        GetContext();
        return null;
    }

    public void OnDestroy() {
        ((IEditor) GetActivity()).OnNewButtonInput().deleteObserver(this.onNewButton);
    }
}
