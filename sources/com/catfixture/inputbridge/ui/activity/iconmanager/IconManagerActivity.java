package com.catfixture.inputbridge.ui.activity.iconmanager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.iconmanager.Icon;
import com.catfixture.inputbridge.core.iconmanager.IconPack;
import com.catfixture.inputbridge.core.utils.android.ActivityActions;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.android.IActivityLaunchable;
import com.catfixture.inputbridge.core.utils.files.FileUtils;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.activity.main.MainActivity;
import com.catfixture.inputbridge.ui.common.genAdapter.GenericListAdapter;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import com.catfixture.inputbridge.ui.common.interactions.InputDialog;
import okhttp3.HttpUrl;

public class IconManagerActivity extends AppCompatActivity implements IActivityLaunchable {
    private byte[] iconData = null;
    private GenericListAdapter<IconPack> iconsPackAdapter;
    private ActivityResultLauncher<Intent> launchSomeActivity;
    private Action<ActivityResult> onResult;

    static /* synthetic */ void lambda$onCreate$12() {
    }

    static /* synthetic */ void lambda$onCreate$13() {
    }

    static /* synthetic */ void lambda$onCreate$4() {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AppContext.cache.iconManager.LookupAllIconPacks(this);
        FoundedPackCountSet();
        InflateIconPacks();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_icon_manager);
        this.launchSomeActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new IconManagerActivity$$ExternalSyntheticLambda13(this));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.iconPacksView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));
        this.iconsPackAdapter = new GenericListAdapter<>(R.layout.icon_pack_item, new IconManagerActivity$$ExternalSyntheticLambda15(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.iconsPackAdapter);
        ((Button) findViewById(R.id.createNewIconPack)).setOnClickListener(new IconManagerActivity$$ExternalSyntheticLambda0(this));
        ((Button) findViewById(R.id.installIconPack)).setOnClickListener(new IconManagerActivity$$ExternalSyntheticLambda7(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$0$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m155lambda$onCreate$0$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(ActivityResult activityResult) {
        Action<ActivityResult> action = this.onResult;
        if (action != null) {
            action.Invoke(activityResult);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$6$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m164lambda$onCreate$6$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(IconPack iconPack, View view) {
        TextView textView = (TextView) view.findViewById(R.id.name);
        TextView textView2 = (TextView) view.findViewById(R.id.imagesCount);
        TextView textView3 = (TextView) view.findViewById(R.id.packSize);
        TextView textView4 = (TextView) view.findViewById(R.id.author);
        ImageView imageView = (ImageView) view.findViewById(R.id.preview);
        Bitmap GetBitmap = AppContext.cache.iconsCache.GetBitmap(iconPack.customIcon);
        if (GetBitmap != null) {
            imageView.setImageBitmap(GetBitmap);
        }
        if (iconPack.author == null || iconPack.author.equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
            textView4.setVisibility(8);
        } else {
            textView4.setVisibility(0);
            textView4.setText(getString(R.string.author_text) + " : " + iconPack.author);
        }
        textView.setText(getString(R.string.name) + " : " + iconPack.name);
        textView2.setText(getString(R.string.count_text) + " : " + iconPack.icons.size());
        textView3.setText(getString(R.string.size_text_no_percent, new Object[]{AndroidUtils.BytesToPrefixedString(iconPack.packSize)}));
        view.setOnClickListener(new IconManagerActivity$$ExternalSyntheticLambda10(this, iconPack));
        ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.enableIconPack);
        toggleButton.setOnClickListener(new IconManagerActivity$$ExternalSyntheticLambda11(this, iconPack));
        toggleButton.setChecked(iconPack.isEnabled);
        ((ImageView) view.findViewById(R.id.removeButton)).setOnClickListener(new IconManagerActivity$$ExternalSyntheticLambda12(this, iconPack));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$1$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m156lambda$onCreate$1$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(IconPack iconPack, View view) {
        Intent intent = new Intent(this, IconsViewActivity.class);
        intent.putExtra("packIndex", this.iconsPackAdapter.GetItems().indexOf(iconPack));
        startActivity(intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$2$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m161lambda$onCreate$2$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(IconPack iconPack, View view) {
        iconPack.isEnabled = !iconPack.isEnabled;
        AppContext.cache.iconManager.SavePack(this, iconPack);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$5$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m163lambda$onCreate$5$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(IconPack iconPack, View view) {
        ConfirmDialog.Show(this, getString(R.string.remove_icon_pack), getString(R.string.remove_icon_pack_confirm), getString(R.string.remove_no_caps), new IconManagerActivity$$ExternalSyntheticLambda3(this, iconPack), getString(R.string.cancel_text), IconManagerActivity$$ExternalSyntheticLambda6.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$3$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m162lambda$onCreate$3$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(IconPack iconPack) {
        AppContext.cache.iconManager.RemovePack(this, iconPack);
        InflateIconPacks();
        FoundedPackCountSet();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$11$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m158lambda$onCreate$11$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(View view) {
        InputDialog.ShowMegaCustom(this, R.layout.create_icon_pack_layout, getString(R.string.create_new_icon_pack), new IconManagerActivity$$ExternalSyntheticLambda14(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$10$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m157lambda$onCreate$10$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(LinearLayout linearLayout, AlertDialog alertDialog) {
        ((Button) linearLayout.findViewById(R.id.selectCustomIcon)).setOnClickListener(new IconManagerActivity$$ExternalSyntheticLambda8(this));
        ((Button) linearLayout.findViewById(R.id.createIconPack)).setOnClickListener(new IconManagerActivity$$ExternalSyntheticLambda9(this, (EditText) linearLayout.findViewById(R.id.name), (EditText) linearLayout.findViewById(R.id.author), alertDialog));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$8$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m166lambda$onCreate$8$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(View view) {
        FileUtils.OpenFileChooser(this, "image/*", new IconManagerActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$7$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m165lambda$onCreate$7$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(Uri uri) {
        try {
            this.iconData = FileUtils.ReadUriBytes(this, uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$9$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m167lambda$onCreate$9$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(EditText editText, EditText editText2, AlertDialog alertDialog, View view) {
        if (!HttpUrl.FRAGMENT_ENCODE_SET.equals(editText.getText().toString())) {
            CreateNewIconPack(editText.getText().toString(), editText2.getText().toString(), this.iconData);
            this.iconData = null;
            alertDialog.dismiss();
            FoundedPackCountSet();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$15$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m160lambda$onCreate$15$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(View view) {
        FileUtils.OpenFileChooser(this, "*/*", new IconManagerActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$14$com-catfixture-inputbridge-ui-activity-iconmanager-IconManagerActivity  reason: not valid java name */
    public /* synthetic */ void m159lambda$onCreate$14$comcatfixtureinputbridgeuiactivityiconmanagerIconManagerActivity(Uri uri) {
        if (uri.getPath().endsWith(".ipk")) {
            try {
                IconPack AddIconPackFromBytes = AppContext.cache.iconManager.AddIconPackFromBytes(this, FileUtils.TryGetName(uri), FileUtils.ReadUriBytes(this, uri));
                if (AddIconPackFromBytes != null) {
                    AppContext.cache.iconManager.SavePack(this, AddIconPackFromBytes);
                }
            } catch (Exception e) {
                e.printStackTrace();
                ConfirmDialog.Show(this, getString(R.string.error_file_broken), getString(R.string.error_file_broken_alert), "ok", IconManagerActivity$$ExternalSyntheticLambda4.INSTANCE);
            }
        } else {
            ConfirmDialog.Show(this, getString(R.string.error_wrong_file), getString(R.string.select_ipk_format_msg), "ok", IconManagerActivity$$ExternalSyntheticLambda5.INSTANCE);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        ActivityActions.startActivity(this, MainActivity.class);
        try {
            System.gc();
        } catch (Exception unused) {
        }
    }

    private void InflateIconPacks() {
        this.iconsPackAdapter.Flush();
        for (IconPack AddItem : AppContext.cache.iconManager.iconPacks) {
            this.iconsPackAdapter.AddItem(AddItem);
        }
        this.iconsPackAdapter.notifyDataSetChanged();
    }

    private void CreateNewIconPack(String str, String str2, byte[] bArr) {
        IconPack iconPack = new IconPack();
        iconPack.name = str;
        iconPack.author = str2;
        iconPack.customIcon = new Icon();
        iconPack.customIcon.name = str;
        iconPack.customIcon.bmpData.binData = bArr;
        AppContext.cache.iconManager.AddIconPack(this, iconPack);
        InflateIconPacks();
    }

    public void Launch(Intent intent, Action<ActivityResult> action) {
        this.onResult = action;
        this.launchSomeActivity.launch(intent);
    }

    private void FoundedPackCountSet() {
        ((TextView) findViewById(R.id.packsFoundCount)).setText(getString(R.string.found_packs, new Object[]{Integer.valueOf(AppContext.cache.iconManager.iconPacks.size())}));
    }
}
