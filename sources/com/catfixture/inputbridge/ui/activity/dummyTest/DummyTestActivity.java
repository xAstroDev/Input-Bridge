package com.catfixture.inputbridge.ui.activity.dummyTest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;

public class DummyTestActivity extends AppCompatActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AndroidUtils.HideSystemUI(getWindow().getDecorView());
    }

    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
        setContentView(View.inflate(this, R.layout.dummy_test_act, (ViewGroup) null));
    }
}
