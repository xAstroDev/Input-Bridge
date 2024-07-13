package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.icon;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.IconsCache;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.iconmanager.Icon;
import com.catfixture.inputbridge.core.input.data.IconData;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.activity.editors.touchEditor.TouchEditorActivity;
import com.catfixture.inputbridge.ui.common.genAdapter.DisplayType;
import com.catfixture.inputbridge.ui.common.genAdapter.GenericSpinnerAdapter;

public class IconElementCommons {
    static /* synthetic */ void lambda$InitIcons$0(Integer num) {
    }

    public static void InitIcons(Context context, LinearLayout linearLayout, final IconData iconData, final IInputWindowElement iInputWindowElement, String str) {
        final IconsCache iconsCache = AppContext.cache.iconsCache;
        TextView textView = (TextView) linearLayout.findViewById(R.id.text);
        if (str == null) {
            str = "Icon";
        }
        textView.setText(str);
        Spinner spinner = (Spinner) linearLayout.findViewById(R.id.icon);
        GenericSpinnerAdapter genericSpinnerAdapter = new GenericSpinnerAdapter(context, (int) R.layout.touch_controls_list_item_with_icon, iconsCache.icons, (Action<Integer>) IconElementCommons$$ExternalSyntheticLambda2.INSTANCE);
        genericSpinnerAdapter.EnableCustomItemAction(new IconElementCommons$$ExternalSyntheticLambda1(genericSpinnerAdapter, iconsCache));
        spinner.setAdapter(genericSpinnerAdapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        spinner.setSelection(iconsCache.IndexOf(iconData.iconName));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                try {
                    Icon icon = IconsCache.this.icons.get(i);
                    if (!icon.name.equals(iconData.iconName)) {
                        iconData.iconName = icon.name;
                        iInputWindowElement.Reinflate();
                    }
                } catch (Exception unused) {
                }
            }
        });
        ((ImageView) linearLayout.findViewById(R.id.openIconSettings)).setOnClickListener(new IconElementCommons$$ExternalSyntheticLambda0(context, iInputWindowElement, iconData));
    }

    static /* synthetic */ void lambda$InitIcons$1(GenericSpinnerAdapter genericSpinnerAdapter, IconsCache iconsCache, View view, Integer num, DisplayType displayType) {
        Icon icon = (Icon) genericSpinnerAdapter.getItem(num.intValue());
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        TextView textView = (TextView) view.findViewById(R.id.text);
        if (num.intValue() == 0) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        imageView.setImageBitmap(iconsCache.GetBitmap(icon));
    }

    static /* synthetic */ void lambda$InitIcons$2(Context context, IInputWindowElement iInputWindowElement, IconData iconData, View view) {
        if (context instanceof TouchEditorActivity) {
            ((TouchEditorActivity) context).ToggleFineTuneView(iInputWindowElement, 1, iconData.iconFineTuneData);
        } else {
            D.E("Error check code, context is not activity");
        }
    }
}
