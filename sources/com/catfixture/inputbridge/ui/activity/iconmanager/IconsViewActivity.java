package com.catfixture.inputbridge.ui.activity.iconmanager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.iconmanager.Icon;
import com.catfixture.inputbridge.core.iconmanager.IconPack;
import com.catfixture.inputbridge.core.utils.android.ActivityActions;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.android.IActivityLaunchable;
import com.catfixture.inputbridge.core.utils.files.AndroidSAFAbstraction;
import com.catfixture.inputbridge.core.utils.files.FileUtils;
import com.catfixture.inputbridge.core.utils.files.IFileAccessAbstraction;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.common.genAdapter.GenericListAdapter;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;

public class IconsViewActivity extends AppCompatActivity implements IActivityLaunchable {
    private GenericListAdapter<Icon> iconsAdapter;
    private ActivityResultLauncher<Intent> launchSomeActivity;
    private Action<ActivityResult> onResult;
    IconPack rootPack;

    static /* synthetic */ void lambda$CreateNewIcon$14() {
    }

    static /* synthetic */ void lambda$onCreate$10() {
    }

    static /* synthetic */ void lambda$onCreate$3() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("packIndex", -1);
        if (intExtra == -1) {
            D.E("Error pack null, activity should be launched from IconPack Manager");
            finish();
            return;
        }
        IconPack iconPack = AppContext.cache.iconManager.iconPacks.get(intExtra);
        this.rootPack = iconPack;
        if (iconPack == null) {
            D.E("Error pack null, activity should be launched from IconPack Manager");
            finish();
            return;
        }
        this.launchSomeActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new IconsViewActivity$$ExternalSyntheticLambda11(this));
        setContentView((int) R.layout.activity_icons_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.iconsView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));
        this.iconsAdapter = new GenericListAdapter<>(R.layout.icon_item, new IconsViewActivity$$ExternalSyntheticLambda12(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.iconsAdapter);
        ((Button) findViewById(R.id.addNewIcon)).setOnClickListener(new IconsViewActivity$$ExternalSyntheticLambda8(this));
        ((Button) findViewById(R.id.addAllFromFolder)).setOnClickListener(new IconsViewActivity$$ExternalSyntheticLambda9(this));
        ((Button) findViewById(R.id.exportIconPack)).setOnClickListener(new IconsViewActivity$$ExternalSyntheticLambda7(this));
        ((TextView) findViewById(R.id.packsContainsImagesCount)).setText(this.rootPack.name + getString(R.string.contains_icons, new Object[]{Integer.valueOf(this.rootPack.icons.size())}));
        InflateIcons();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$0$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m168lambda$onCreate$0$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(ActivityResult activityResult) {
        Action<ActivityResult> action = this.onResult;
        if (action != null) {
            action.Invoke(activityResult);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$5$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m175lambda$onCreate$5$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(Icon icon, View view) {
        Bitmap GetBitmap = AppContext.cache.iconsCache.GetBitmap(icon);
        ((TextView) view.findViewById(R.id.name)).setText("2131820836: " + icon.name);
        ((TextView) view.findViewById(R.id.size)).setText(getString(R.string.size_text_no_percent, new Object[]{AndroidUtils.BitmapSizeToString(GetBitmap)}));
        ((ImageView) view.findViewById(R.id.preview)).setImageBitmap(GetBitmap);
        view.setOnClickListener(new IconsViewActivity$$ExternalSyntheticLambda0(this));
        ((ImageView) view.findViewById(R.id.removeButton)).setOnClickListener(new IconsViewActivity$$ExternalSyntheticLambda10(this, icon));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$1$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m169lambda$onCreate$1$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(View view) {
        ActivityActions.startActivity(this, IconsViewActivity.class);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$4$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m174lambda$onCreate$4$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(Icon icon, View view) {
        ConfirmDialog.Show(this, "Remove icon", "Do you want to remove this icon?", "Remove", new IconsViewActivity$$ExternalSyntheticLambda3(this, icon), "Cancel", IconsViewActivity$$ExternalSyntheticLambda6.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$2$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m173lambda$onCreate$2$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(Icon icon) {
        this.rootPack.icons.remove(icon);
        AppContext.cache.iconManager.SavePack(this, this.rootPack);
        new Handler().post(new IconsViewActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$7$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m177lambda$onCreate$7$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(View view) {
        FileUtils.OpenFileChooser(this, "image/*", new IconsViewActivity$$ExternalSyntheticLambda13(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$6$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m176lambda$onCreate$6$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(Uri uri) {
        CreateNewIconFromUri(uri);
        AppContext.cache.iconManager.SavePack(this, this.rootPack);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$9$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m179lambda$onCreate$9$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(View view) {
        FileUtils.OpenDirectoryChooserUri(this, new IconsViewActivity$$ExternalSyntheticLambda14(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$8$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m178lambda$onCreate$8$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(Uri uri) {
        for (IFileAccessAbstraction GetUri : new AndroidSAFAbstraction(this, DocumentFile.fromSingleUri(this, uri)).GetFilesList()) {
            CreateNewIconFromUri(GetUri.GetUri());
        }
        AppContext.cache.iconManager.SavePack(this, this.rootPack);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$13$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m172lambda$onCreate$13$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(View view) {
        FileUtils.RequestFolderAccess(this, Uri.parse(Environment.getExternalStorageDirectory() + "/" + ConfigContext.data.appFolder), new IconsViewActivity$$ExternalSyntheticLambda15(this), new IconsViewActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$11$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m170lambda$onCreate$11$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity(IFileAccessAbstraction iFileAccessAbstraction) {
        if (!ConfigContext.data.appFolder.equals(iFileAccessAbstraction.GetEndSegment())) {
            ConfirmDialog.Show(this, getString(R.string.error_text), getString(R.string.error_use_only_downloads, new Object[]{ConfigContext.data.appFolder}), getString(R.string.close_text), (Runnable) null);
            return;
        }
        IFileAccessAbstraction CreateDir = iFileAccessAbstraction.CreateDir("InputBridge").CreateDir("IconPacks");
        CreateDir.Write(this.rootPack.name + ".ipk", AppContext.cache.iconManager.IconPackToBytes(this.rootPack));
        String string = getString(R.string.done_text);
        ConfirmDialog.Show(this, string, "Icon pack saved! " + ConfigContext.data.appFolder + "/InputBridge/IconPacks/" + this.rootPack.name + ".ipk", getString(R.string.close_text), IconsViewActivity$$ExternalSyntheticLambda5.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$12$com-catfixture-inputbridge-ui-activity-iconmanager-IconsViewActivity  reason: not valid java name */
    public /* synthetic */ void m171lambda$onCreate$12$comcatfixtureinputbridgeuiactivityiconmanagerIconsViewActivity() {
        getString(R.string.permissions_not_granted_text);
        D.E("CANT GET PERMS FOR FILE");
    }

    private void CreateNewIconFromUri(Uri uri) {
        try {
            CreateNewIcon(FileUtils.TryGetName(uri), FileUtils.ReadUriBytes(this, uri));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CreateNewIcon(String str, byte[] bArr) {
        Icon icon = new Icon();
        icon.path = str;
        icon.name = FileUtils.ExtractNameFromPathWithoutExtension(str);
        icon.scaleType = -1;
        icon.bmpData.binData = bArr;
        if (this.rootPack.Contains(icon)) {
            ConfirmDialog.Show(this, "Can't add icon", "Icon with such name already in list.", "Ok", IconsViewActivity$$ExternalSyntheticLambda4.INSTANCE);
            return;
        }
        this.rootPack.icons.add(icon);
        InflateIcons();
    }

    /* access modifiers changed from: private */
    public void InflateIcons() {
        this.iconsAdapter.Flush();
        for (Icon AddItem : this.rootPack.icons) {
            this.iconsAdapter.AddItem(AddItem);
        }
        this.iconsAdapter.notifyDataSetChanged();
    }

    public void Launch(Intent intent, Action<ActivityResult> action) {
        this.onResult = action;
        this.launchSomeActivity.launch(intent);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
