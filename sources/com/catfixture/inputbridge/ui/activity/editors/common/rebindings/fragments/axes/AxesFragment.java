package com.catfixture.inputbridge.ui.activity.editors.common.rebindings.fragments.axes;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.catfixture.inputbridge.ui.activity.editors.common.IEditor;
import com.catfixture.inputbridge.ui.activity.editors.common.rebindings.common.CommonEditorFragment;
import java.util.Observable;
import java.util.Observer;

public class AxesFragment extends CommonEditorFragment {
    private LinearLayoutManager layman;
    private Observer onNewAxis;

    public View OnCreate() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void UpdateBindings() {
    }

    public void onResume() {
    }

    public AxesFragment(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public void Init() {
        super.Init();
        this.onNewAxis = new AxesFragment$$ExternalSyntheticLambda0(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Init$0$com-catfixture-inputbridge-ui-activity-editors-common-rebindings-fragments-axes-AxesFragment  reason: not valid java name */
    public /* synthetic */ void m123lambda$Init$0$comcatfixtureinputbridgeuiactivityeditorscommonrebindingsfragmentsaxesAxesFragment(Observable observable, Object obj) {
        this.selectedItem = ((Integer) obj).intValue();
        UpdateBindings();
    }

    public void OnDestroy() {
        super.OnDestroy();
        ((IEditor) GetActivity()).OnNewAxisInput().deleteObserver(this.onNewAxis);
    }
}
