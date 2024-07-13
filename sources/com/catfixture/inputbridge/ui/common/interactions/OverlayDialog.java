package com.catfixture.inputbridge.ui.common.interactions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.windows.MinimalWindow;

public class OverlayDialog {
    public static void Show(Context context, String str, String str2, String str3, Runnable runnable) {
        Show(context, str, str2, str3, runnable, (String) null, (Runnable) null);
    }

    public static void Show(Context context, String str, String str2) {
        Show(context, str, str2, (String) null, (Runnable) null, (String) null, (Runnable) null);
    }

    public static void Show(Context context, String str, String str2, String str3, Runnable runnable, String str4, Runnable runnable2) {
        MinimalWindow minimalWindow = new MinimalWindow(context);
        minimalWindow.SetFullscreen().EnableEvents().EnableSystemUIHide().SetOverlay().SetTranslucent().Create();
        ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.overlay_dialog_frame, minimalWindow.GetContainer());
        Button button = (Button) viewGroup.findViewById(R.id.ok);
        Button button2 = (Button) viewGroup.findViewById(R.id.no);
        ((TextView) viewGroup.findViewById(R.id.title)).setText(str);
        ((TextView) viewGroup.findViewById(R.id.text)).setText(str2);
        if (str3 != null) {
            button.setVisibility(0);
            button.setText(str3);
            button.setOnClickListener(new OverlayDialog$$ExternalSyntheticLambda2(runnable, minimalWindow));
        } else {
            button.setOnClickListener(new OverlayDialog$$ExternalSyntheticLambda0(minimalWindow));
        }
        if (str4 != null) {
            button2.setVisibility(0);
            button2.setText(str4);
            button2.setOnClickListener(new OverlayDialog$$ExternalSyntheticLambda3(runnable2, minimalWindow));
            return;
        }
        button2.setOnClickListener(new OverlayDialog$$ExternalSyntheticLambda1(minimalWindow));
    }

    static /* synthetic */ void lambda$Show$0(Runnable runnable, MinimalWindow minimalWindow, View view) {
        runnable.run();
        minimalWindow.Destroy();
    }

    static /* synthetic */ void lambda$Show$2(Runnable runnable, MinimalWindow minimalWindow, View view) {
        runnable.run();
        minimalWindow.Destroy();
    }
}
