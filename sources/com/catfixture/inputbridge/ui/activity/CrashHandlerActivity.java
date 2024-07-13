package com.catfixture.inputbridge.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.catfixture.inputbridge.R;

public class CrashHandlerActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_crash_handler);
        Intent intent = getIntent();
        intent.getStringExtra("error_msg");
        intent.getStringExtra("error_stk");
    }
}
