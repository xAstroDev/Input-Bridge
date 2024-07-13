package com.catfixture.inputbridge.ui.common.interactions;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.windows.MinimalWindow;
import java.util.ArrayDeque;
import java.util.Queue;

public class OverlayActionProgressSync {
    private static TextView currentTaskEl;
    private static ProgressBar progressBarEl;
    private boolean aborted;
    private final Handler handler;
    private final MinimalWindow mw;
    private Runnable onAbort;
    private Runnable onDone;
    private Runnable onFail;
    private final Queue<Runnable> runnableQueue = new ArrayDeque();

    public OverlayActionProgressSync(Activity activity, String str) {
        MinimalWindow minimalWindow = new MinimalWindow(activity);
        this.mw = minimalWindow;
        minimalWindow.SetFullscreen().EnableEvents().SetOverlay().SetTranslucent().Create();
        ViewGroup viewGroup = (ViewGroup) View.inflate(activity, R.layout.overlay_action_progress_frame, minimalWindow.GetContainer());
        currentTaskEl = (TextView) viewGroup.findViewById(R.id.currentTask);
        progressBarEl = (ProgressBar) viewGroup.findViewById(R.id.progressBar);
        ((TextView) viewGroup.findViewById(R.id.title)).setText(str);
        Button button = (Button) viewGroup.findViewById(R.id.stopOk);
        button.setVisibility(0);
        button.setText(activity.getString(R.string.cancel_text));
        button.setOnClickListener(new OverlayActionProgressSync$$ExternalSyntheticLambda0(this));
        this.handler = new Handler();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-catfixture-inputbridge-ui-common-interactions-OverlayActionProgressSync  reason: not valid java name */
    public /* synthetic */ void m236lambda$new$0$comcatfixtureinputbridgeuicommoninteractionsOverlayActionProgressSync(View view) {
        this.aborted = true;
    }

    public <T> OverlayActionProgressSync Enqueue(String str, int i, Runnable runnable) {
        this.runnableQueue.add(new OverlayActionProgressSync$$ExternalSyntheticLambda3(this, str, i, runnable));
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Enqueue$3$com-catfixture-inputbridge-ui-common-interactions-OverlayActionProgressSync  reason: not valid java name */
    public /* synthetic */ void m235lambda$Enqueue$3$comcatfixtureinputbridgeuicommoninteractionsOverlayActionProgressSync(String str, int i, Runnable runnable) {
        this.handler.post(new OverlayActionProgressSync$$ExternalSyntheticLambda2(this, str, i, runnable));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Enqueue$2$com-catfixture-inputbridge-ui-common-interactions-OverlayActionProgressSync  reason: not valid java name */
    public /* synthetic */ void m234lambda$Enqueue$2$comcatfixtureinputbridgeuicommoninteractionsOverlayActionProgressSync(String str, int i, Runnable runnable) {
        currentTaskEl.setText(str);
        progressBarEl.setProgress(i);
        this.handler.post(new OverlayActionProgressSync$$ExternalSyntheticLambda1(this, runnable));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Enqueue$1$com-catfixture-inputbridge-ui-common-interactions-OverlayActionProgressSync  reason: not valid java name */
    public /* synthetic */ void m233lambda$Enqueue$1$comcatfixtureinputbridgeuicommoninteractionsOverlayActionProgressSync(Runnable runnable) {
        try {
            runnable.run();
            OnNextTask();
        } catch (Exception unused) {
            this.mw.Destroy();
            this.onFail.run();
        }
    }

    private void OnNextTask() {
        this.runnableQueue.poll();
        Execute();
    }

    public void Execute() {
        if (this.aborted) {
            this.onAbort.run();
            this.mw.Destroy();
        } else if (this.runnableQueue.size() == 0) {
            this.onDone.run();
            this.mw.Destroy();
        } else {
            this.handler.post(this.runnableQueue.peek());
        }
    }

    public void Init(String str) {
        this.aborted = false;
        this.runnableQueue.clear();
        currentTaskEl.setText(str);
        progressBarEl.setProgress(0);
    }

    public OverlayActionProgressSync OnDone(Runnable runnable) {
        this.onDone = runnable;
        return this;
    }

    public OverlayActionProgressSync OnFail(Runnable runnable) {
        this.onFail = runnable;
        return this;
    }

    public OverlayActionProgressSync OnAbort(Runnable runnable) {
        this.onAbort = runnable;
        return this;
    }
}
