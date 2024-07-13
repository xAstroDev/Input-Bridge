package com.catfixture.inputbridge.ui.tabs;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.activity.main.ErrorH;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabController {
    private final Context context;
    private List<ITabFragment> fragmentList = new ArrayList();
    private boolean isPortraitMode = true;
    private final View marker;
    private Action<Integer> onChanged;
    private int selectedTab;
    private final int tabButtonLayout;
    private final ViewGroup tabsButtonsContainer;
    private final ViewGroup tabsContentContainer;

    public TabController(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        this.context = viewGroup.getContext();
        this.tabsButtonsContainer = viewGroup;
        this.tabsContentContainer = viewGroup2;
        this.tabButtonLayout = i;
        this.marker = ((View) viewGroup.getParent()).findViewById(R.id.marker);
    }

    public void SetPortrait(boolean z) {
        this.isPortraitMode = z;
    }

    public void AddTab(String str, int i, ITabFragment iTabFragment) {
        InitButton(str, i, this.fragmentList.size());
        this.fragmentList.add(iTabFragment);
        View GetRoot = iTabFragment.GetRoot();
        LayoutUtils.SetMatchWrap(GetRoot);
        this.tabsContentContainer.addView(GetRoot);
    }

    private void InitButton(String str, int i, int i2) {
        View inflate = View.inflate(this.tabsButtonsContainer.getContext(), this.tabButtonLayout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.text)).setText(str);
        ((ImageView) inflate.findViewById(R.id.icon)).setImageResource(i);
        inflate.setOnTouchListener(new TabController$$ExternalSyntheticLambda0(this, i2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        inflate.setLayoutParams(layoutParams);
        this.tabsButtonsContainer.addView(inflate);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InitButton$0$com-catfixture-inputbridge-ui-tabs-TabController  reason: not valid java name */
    public /* synthetic */ boolean m240lambda$InitButton$0$comcatfixtureinputbridgeuitabsTabController(int i, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            ToggleTab(i);
            this.onChanged.Invoke(Integer.valueOf(i));
            view.performClick();
        }
        return true;
    }

    private void ToggleTab(int i) {
        try {
            this.selectedTab = i;
            for (ITabFragment Hide : this.fragmentList) {
                Hide.Hide();
            }
            this.fragmentList.get(i).Show();
            SetMarker();
        } catch (Exception e) {
            ErrorH.RaiseCrash(this.context, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    private void SetMarker() {
        LayoutUtils.RunJustBeforeBeingDrawn(this.marker, new TabController$$ExternalSyntheticLambda1(this, LayoutUtils.GetDP(this.context, 3)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetMarker$1$com-catfixture-inputbridge-ui-tabs-TabController  reason: not valid java name */
    public /* synthetic */ void m241lambda$SetMarker$1$comcatfixtureinputbridgeuitabsTabController(int i) {
        int width = this.tabsButtonsContainer.getChildAt(0).getWidth();
        if (this.isPortraitMode) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, i);
            layoutParams.leftMargin = width * this.selectedTab;
            layoutParams.topMargin = this.tabsButtonsContainer.getHeight() - i;
            this.marker.setLayoutParams(layoutParams);
            return;
        }
        int height = this.tabsButtonsContainer.getChildAt(0).getHeight();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, height);
        layoutParams2.topMargin = height * this.selectedTab;
        this.marker.setLayoutParams(layoutParams2);
    }

    public void Create() {
        this.tabsButtonsContainer.requestLayout();
    }

    public void SetTab(int i) {
        ToggleTab(i);
    }

    public void OnTabsSelectionChanged(Action<Integer> action) {
        this.onChanged = action;
    }

    public void OnResume() {
        this.fragmentList.get(this.selectedTab).Show();
    }

    public void OnDestroy() {
        for (ITabFragment OnDestroy : this.fragmentList) {
            OnDestroy.OnDestroy();
        }
    }

    public int GetSelectedTab() {
        return this.selectedTab;
    }
}
