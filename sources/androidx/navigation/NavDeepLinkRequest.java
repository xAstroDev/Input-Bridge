package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0011B%\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007B\u000f\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest;", "", "uri", "Landroid/net/Uri;", "action", "", "mimeType", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getAction", "()Ljava/lang/String;", "getMimeType", "getUri", "()Landroid/net/Uri;", "toString", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavDeepLinkRequest.kt */
public class NavDeepLinkRequest {
    private final String action;
    private final String mimeType;
    private final Uri uri;

    public Uri getUri() {
        return this.uri;
    }

    public String getAction() {
        return this.action;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public NavDeepLinkRequest(Uri uri2, String str, String str2) {
        this.uri = uri2;
        this.action = str;
        this.mimeType = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDeepLinkRequest(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (getUri() != null) {
            sb.append(" uri=");
            sb.append(String.valueOf(getUri()));
        }
        if (getAction() != null) {
            sb.append(" action=");
            sb.append(getAction());
        }
        if (getMimeType() != null) {
            sb.append(" mimetype=");
            sb.append(getMimeType());
        }
        sb.append(" }");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest$Builder;", "", "()V", "action", "", "mimeType", "uri", "Landroid/net/Uri;", "build", "Landroidx/navigation/NavDeepLinkRequest;", "setAction", "setMimeType", "setUri", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NavDeepLinkRequest.kt */
    public static final class Builder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String action;
        private String mimeType;
        private Uri uri;

        public /* synthetic */ Builder(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static final Builder fromAction(String str) {
            return Companion.fromAction(str);
        }

        @JvmStatic
        public static final Builder fromMimeType(String str) {
            return Companion.fromMimeType(str);
        }

        @JvmStatic
        public static final Builder fromUri(Uri uri2) {
            return Companion.fromUri(uri2);
        }

        private Builder() {
        }

        public final Builder setUri(Uri uri2) {
            Intrinsics.checkNotNullParameter(uri2, "uri");
            this.uri = uri2;
            return this;
        }

        public final Builder setAction(String str) {
            Intrinsics.checkNotNullParameter(str, "action");
            if (str.length() > 0) {
                this.action = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.".toString());
        }

        public final Builder setMimeType(String str) {
            Intrinsics.checkNotNullParameter(str, "mimeType");
            if (new Regex("^[-\\w*.]+/[-\\w+*.]+$").matches(str)) {
                this.mimeType = str;
                return this;
            }
            throw new IllegalArgumentException(("The given mimeType " + str + " does not match to required \"type/subtype\" format").toString());
        }

        public final NavDeepLinkRequest build() {
            return new NavDeepLinkRequest(this.uri, this.action, this.mimeType);
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLinkRequest$Builder;", "action", "", "fromMimeType", "mimeType", "fromUri", "uri", "Landroid/net/Uri;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NavDeepLinkRequest.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Builder fromUri(Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                Builder builder = new Builder((DefaultConstructorMarker) null);
                builder.setUri(uri);
                return builder;
            }

            @JvmStatic
            public final Builder fromAction(String str) {
                Intrinsics.checkNotNullParameter(str, "action");
                if (str.length() > 0) {
                    Builder builder = new Builder((DefaultConstructorMarker) null);
                    builder.setAction(str);
                    return builder;
                }
                throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.".toString());
            }

            @JvmStatic
            public final Builder fromMimeType(String str) {
                Intrinsics.checkNotNullParameter(str, "mimeType");
                Builder builder = new Builder((DefaultConstructorMarker) null);
                builder.setMimeType(str);
                return builder;
            }
        }
    }
}
