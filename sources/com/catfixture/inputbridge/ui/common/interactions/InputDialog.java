package com.catfixture.inputbridge.ui.common.interactions;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.core.utils.types.delegates.Action2;

public class InputDialog {
    public static void Show(Context context, String str, String str2, String str3, Action<String> action) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle((CharSequence) str);
        TextView textView = new TextView(context);
        textView.setText("Name");
        EditText editText = new EditText(context);
        editText.setText(str2);
        editText.setHint(R.string.name);
        editText.setInputType(1);
        editText.setBackgroundResource(R.color.default_field_color);
        editText.setTextColor(context.getColor(R.color.darkGray));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 100);
        layoutParams.setMargins(60, 10, 60, 0);
        editText.setLayoutParams(layoutParams);
        editText.setPadding(10, 0, 10, 0);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView((View) linearLayout);
        builder.setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) new InputDialog$$ExternalSyntheticLambda0(action, editText));
        builder.show();
    }

    static /* synthetic */ void lambda$Show$0(Action action, EditText editText, DialogInterface dialogInterface, int i) {
        action.Invoke(editText.getText().toString());
        dialogInterface.cancel();
    }

    public static void ShowLabeled(Context context, String str, String str2, String str3, String str4, Action<String> action) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle((CharSequence) str);
        TextView textView = new TextView(context);
        textView.setText(str3);
        EditText editText = new EditText(context);
        editText.setText(str2);
        editText.setHint(R.string.name);
        editText.setInputType(1);
        editText.setBackgroundResource(R.color.default_field_color);
        editText.setTextColor(context.getColor(R.color.darkGray));
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, 100));
        editText.setPadding(10, 0, 10, 0);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setPadding(60, 10, 60, 10);
        linearLayout.setOrientation(1);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView((View) linearLayout);
        builder.setPositiveButton((CharSequence) str4, (DialogInterface.OnClickListener) new InputDialog$$ExternalSyntheticLambda1(action, editText));
        builder.show();
    }

    static /* synthetic */ void lambda$ShowLabeled$1(Action action, EditText editText, DialogInterface dialogInterface, int i) {
        action.Invoke(editText.getText().toString());
        dialogInterface.cancel();
    }

    public static void ShowMegaCustom(Context context, int i, String str, Action2<LinearLayout, AlertDialog> action2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle((CharSequence) str);
        LinearLayout linearLayout = (LinearLayout) LinearLayout.inflate(context, i, (ViewGroup) null);
        builder.setView((View) linearLayout);
        action2.Invoke(linearLayout, builder.show());
    }
}
