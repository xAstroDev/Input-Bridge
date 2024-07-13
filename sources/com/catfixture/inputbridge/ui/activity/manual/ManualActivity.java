package com.catfixture.inputbridge.ui.activity.manual;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.catfixture.inputbridge.R;

public class ManualActivity extends AppCompatActivity {
    private void Recreate() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) (ViewGroup) View.inflate(this, R.layout.activity_manual, (ViewGroup) null));
    }
}
