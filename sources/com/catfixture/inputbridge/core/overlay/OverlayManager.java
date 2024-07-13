package com.catfixture.inputbridge.core.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.input.utils.EventUtils;
import com.catfixture.inputbridge.core.input.utils.ITouchable;
import com.catfixture.inputbridge.core.utils.types.Event;
import com.catfixture.inputbridge.core.utils.windows.MinimalWindow;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class OverlayManager implements ITouchable {
    private final Context context;
    private final HashMap<Integer, IOverlayFragment> fragmentHashMap = new HashMap<>();
    public Event onClick = new Event();
    public Event onDown = new Event();
    public Event onMove = new Event();
    public Event onUp = new Event();
    private MinimalWindow window;

    public OverlayManager(Context context2) {
        this.context = context2;
    }

    public void InitializeWindow() {
        if (this.window == null) {
            MinimalWindow minimalWindow = new MinimalWindow(this.context);
            this.window = minimalWindow;
            minimalWindow.SetNoSize().SetGravity(BadgeDrawable.TOP_END).EnableEventsTouchOnly().EnableSystemUIHide().SetTranslucent().SetOverlay().Create();
            EventUtils.InitializeITouchableEvents(this.window.GetContainer(), this);
        }
    }

    public void Add(IOverlayFragment iOverlayFragment) {
        if (this.window == null) {
            InitializeWindow();
        }
        this.window.GetContainer().addView(iOverlayFragment.GetContainer());
        if (!this.fragmentHashMap.containsKey(Integer.valueOf(iOverlayFragment.GetID()))) {
            this.fragmentHashMap.put(Integer.valueOf(iOverlayFragment.GetID()), iOverlayFragment);
            ViewGroup GetContainer = iOverlayFragment.GetContainer();
            Objects.requireNonNull(iOverlayFragment);
            GetContainer.post(new OverlayManager$$ExternalSyntheticLambda0(iOverlayFragment));
            return;
        }
        throw new RuntimeException("Error duplicated ID! Check code");
    }

    public void Remove(IOverlayFragment iOverlayFragment) {
        if (this.fragmentHashMap.containsKey(Integer.valueOf(iOverlayFragment.GetID()))) {
            Hide(iOverlayFragment);
            this.fragmentHashMap.remove(Integer.valueOf(iOverlayFragment.GetID()));
            return;
        }
        D.E("No such key!");
    }

    public IOverlayFragment GetFragment(int i) {
        if (this.fragmentHashMap.containsKey(Integer.valueOf(i))) {
            return this.fragmentHashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public void Show(IOverlayFragment iOverlayFragment) {
        Show(iOverlayFragment.GetID());
    }

    public void Show(int i) {
        IOverlayFragment GetFragment = GetFragment(i);
        if (GetFragment == null) {
            D.E("Fragment null!!!");
            return;
        }
        GetFragment.GetContainer().setVisibility(0);
        GetFragment.OnFragmentShown();
    }

    public void Hide(IOverlayFragment iOverlayFragment) {
        Hide(iOverlayFragment.GetID());
    }

    public void Hide(int i) {
        IOverlayFragment GetFragment = GetFragment(i);
        if (GetFragment == null) {
            D.E("Fragment null!!!");
            return;
        }
        GetFragment.GetContainer().setVisibility(8);
        GetFragment.OnFragmentHidden();
    }

    public Event OnDown() {
        return this.onDown;
    }

    public Event OnMove() {
        return this.onMove;
    }

    public Event OnUp() {
        return this.onUp;
    }

    public Event OnClick() {
        return this.onClick;
    }

    public Event OnEnter() {
        return this.onMove;
    }

    public Event OnExit() {
        return this.onMove;
    }

    public boolean IsShown(IOverlayFragment iOverlayFragment) {
        return iOverlayFragment != null && iOverlayFragment.GetContainer().getVisibility() == 0;
    }

    public boolean IsShown(int i) {
        return IsShown(GetFragment(i));
    }

    public void Destroy() {
        MinimalWindow minimalWindow = this.window;
        if (minimalWindow != null) {
            minimalWindow.Destroy();
            this.window = null;
        }
    }

    public void SetVisibility(boolean z) {
        if (this.window == null) {
            InitializeWindow();
        }
        if (z) {
            this.window.Create();
        } else {
            this.window.Destroy();
        }
    }

    public void AddOnBottom(IOverlayFragment iOverlayFragment) {
        ViewGroup GetContainer = this.window.GetContainer();
        int childCount = GetContainer.getChildCount();
        ArrayList<View> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            arrayList.add(GetContainer.getChildAt(i));
        }
        GetContainer.removeAllViews();
        Add(iOverlayFragment);
        for (View addView : arrayList) {
            GetContainer.addView(addView);
        }
    }

    public void SetCollapsed(int i, int i2) {
        this.window.SetSize(i, i2).EnableEventsTouchOnly().Update();
    }

    public void SetExpanded() {
        this.window.SetFullscreen().EnableEvents().Update();
    }
}
