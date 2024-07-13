package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableButtonCommonBinding implements ViewBinding {
    public final Spinner buttonShape;
    public final EditText customText;
    public final TextView customTextLabel;
    public final ImageView openShapeSettings;
    public final ImageView openTextSettings;
    private final LinearLayout rootView;

    private EditableButtonCommonBinding(LinearLayout linearLayout, Spinner spinner, EditText editText, TextView textView, ImageView imageView, ImageView imageView2) {
        this.rootView = linearLayout;
        this.buttonShape = spinner;
        this.customText = editText;
        this.customTextLabel = textView;
        this.openShapeSettings = imageView;
        this.openTextSettings = imageView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableButtonCommonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableButtonCommonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_button_common, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableButtonCommonBinding bind(View view) {
        int i = R.id.buttonShape;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.buttonShape);
        if (spinner != null) {
            i = R.id.customText;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.customText);
            if (editText != null) {
                i = R.id.customTextLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.customTextLabel);
                if (textView != null) {
                    i = R.id.openShapeSettings;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.openShapeSettings);
                    if (imageView != null) {
                        i = R.id.openTextSettings;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.openTextSettings);
                        if (imageView2 != null) {
                            return new EditableButtonCommonBinding((LinearLayout) view, spinner, editText, textView, imageView, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
