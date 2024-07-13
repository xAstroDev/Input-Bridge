package com.catfixture.inputbridge.ui.activity.main.fragments.helpSettings;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.utils.android.ActivityActions;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;
import com.catfixture.inputbridge.ui.activity.dbg.DBGActivity;
import com.catfixture.inputbridge.ui.custom.Chapter;
import com.catfixture.inputbridge.ui.tabs.DefaultTabFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HelpFragment extends DefaultTabFragment {
    private View dbg;
    private TextView thanksView;

    public void OnDestroy() {
    }

    public HelpFragment(Activity activity) {
        super(activity);
    }

    private void InflateThanks(TextView textView) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("AkaGloomy");
        arrayList.add("Seven768");
        arrayList.add("DeNiS");
        arrayList.add("mr.frolof");
        arrayList.add("Cylbox");
        Collections.shuffle(arrayList, new Random(System.nanoTime()));
        arrayList.add(0, "❤fxsxdev - SW Engineer");
        arrayList.add(1, "Kind people from Exagear International");
        StringBuilder sb = new StringBuilder();
        for (String append : arrayList) {
            sb.append(append);
            sb.append("\n");
        }
        textView.setText(sb.toString());
    }

    private void LoadHelp(ViewGroup viewGroup, String str) {
        viewGroup.removeAllViews();
        WebView webView = new WebView(GetContext());
        WebSettings settings = webView.getSettings();
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setGeolocationEnabled(false);
        settings.setSaveFormData(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        webView.loadUrl("file:///android_asset/help_" + str + ".html");
        webView.setBackgroundColor(GetContext().getColor(R.color.transparent));
        LayoutUtils.SetMatchMatch(webView);
        viewGroup.addView(webView);
    }

    public View OnCreate() {
        Context GetContext = GetContext();
        GetActivity();
        View inflate = View.inflate(GetContext, R.layout.fragment_help, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.dbg);
        this.dbg = findViewById;
        findViewById.setOnClickListener(new HelpFragment$$ExternalSyntheticLambda2(this));
        this.thanksView = (TextView) inflate.findViewById(R.id.thanksNames);
        ((Button) inflate.findViewById(R.id.manualButton)).setOnClickListener(new HelpFragment$$ExternalSyntheticLambda0(GetContext));
        if (GetContext.getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 5, 0, 0);
            ((Chapter) inflate.findViewById(R.id.thankChapter)).setLayoutParams(layoutParams);
            ((LinearLayout) inflate.findViewById(R.id.authorChapter)).setVisibility(0);
        }
        ((ImageView) inflate.findViewById(R.id.discordHook)).setOnClickListener(new HelpFragment$$ExternalSyntheticLambda1(GetContext));
        return inflate;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$OnCreate$0$com-catfixture-inputbridge-ui-activity-main-fragments-helpSettings-HelpFragment  reason: not valid java name */
    public /* synthetic */ void m213lambda$OnCreate$0$comcatfixtureinputbridgeuiactivitymainfragmentshelpSettingsHelpFragment(View view) {
        GetContext();
        ActivityActions.startActivity(GetContext(), DBGActivity.class);
    }

    public void onResume() {
        InflateThanks(this.thanksView);
        this.dbg.setVisibility(ConfigContext.data.debugEnabled ? 0 : 8);
    }
}
