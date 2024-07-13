package com.catfixture.inputbridge.ui.common.interactions;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.windows.MinimalWindow;

public class OverlayActionProgressAsync {
    private static TextView currentTaskEl;
    private static ProgressBar progressBarEl;
    private final MinimalWindow mw;

    public OverlayActionProgressAsync(Activity activity, String str, boolean z) {
        MinimalWindow minimalWindow = new MinimalWindow(activity);
        this.mw = minimalWindow;
        minimalWindow.SetFullscreen().EnableEvents().SetOverlay().SetTranslucent().Create();
        ViewGroup viewGroup = (ViewGroup) View.inflate(activity, R.layout.overlay_action_progress_frame, minimalWindow.GetContainer());
        currentTaskEl = (TextView) viewGroup.findViewById(R.id.currentTask);
        progressBarEl = (ProgressBar) viewGroup.findViewById(R.id.progressBar);
        ((TextView) viewGroup.findViewById(R.id.title)).setText(str);
        if (z) {
            Button button = (Button) viewGroup.findViewById(R.id.stopOk);
            button.setVisibility(0);
            button.setText(activity.getString(R.string.cancel_text));
            button.setOnClickListener(new OverlayActionProgressAsync$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-catfixture-inputbridge-ui-common-interactions-OverlayActionProgressAsync  reason: not valid java name */
    public /* synthetic */ void m232lambda$new$0$comcatfixtureinputbridgeuicommoninteractionsOverlayActionProgressAsync(View view) {
        this.mw.Destroy();
    }

    public void SetProgress(int i, String str) {
        currentTaskEl.setText(str);
        progressBarEl.setProgress(i);
    }

    public void Close() {
        MinimalWindow minimalWindow = this.mw;
        if (minimalWindow != null) {
            minimalWindow.Destroy();
        }
    }

    public void Init(String str) {
        currentTaskEl.setText(str);
        progressBarEl.setProgress(0);
    }
}
