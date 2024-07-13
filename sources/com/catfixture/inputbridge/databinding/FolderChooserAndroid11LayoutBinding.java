package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class FolderChooserAndroid11LayoutBinding implements ViewBinding {
    public final Button chooseDownloadFolderButton;
    public final Button chooseOtherFolderButton;
    public final Button closeButton;
    private final LinearLayout rootView;

    private FolderChooserAndroid11LayoutBinding(LinearLayout linearLayout, Button button, Button button2, Button button3) {
        this.rootView = linearLayout;
        this.chooseDownloadFolderButton = button;
        this.chooseOtherFolderButton = button2;
        this.closeButton = button3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FolderChooserAndroid11LayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FolderChooserAndroid11LayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.folder_chooser_android11_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FolderChooserAndroid11LayoutBinding bind(View view) {
        int i = R.id.chooseDownloadFolderButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.chooseDownloadFolderButton);
        if (button != null) {
            i = R.id.chooseOtherFolderButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.chooseOtherFolderButton);
            if (button2 != null) {
                i = R.id.closeButton;
                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.closeButton);
                if (button3 != null) {
                    return new FolderChooserAndroid11LayoutBinding((LinearLayout) view, button, button2, button3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
