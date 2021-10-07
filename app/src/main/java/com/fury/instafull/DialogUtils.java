package com.fury.instafull;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.instagram.data.Utils;

import java.util.HashMap;
import java.util.Map;

@TargetApi(21)
public class DialogUtils {

    public interface DialogBtnClickListener {
        void onPositiveClick();
    }

    /* renamed from: shirazwebdevelopers.ehsankarimi.instaautodownloader.DialogUtils.1 */
    static class C15341 implements OnClickListener {
        private final /* synthetic */ Activity val$a;
        private final /* synthetic */ Editor val$mEdit;
        private final /* synthetic */ SharedPreferences val$mSharedPrefs;

        C15341(SharedPreferences sharedPreferences, Editor editor, Activity activity) {
            this.val$mSharedPrefs = sharedPreferences;
            this.val$mEdit = editor;
            this.val$a = activity;
        }

        public void onClick(DialogInterface arg0, int arg1) {
            arg0.dismiss();
            if (this.val$mSharedPrefs.getInt("yesCount", 0) > 0) {
                this.val$mEdit.putBoolean("neverRate", true);
            } else {
                this.val$mEdit.putInt("rateCount", 0);
                this.val$mEdit.putInt("yesCount", 1);
            }
            this.val$mEdit.commit();
            this.val$a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + this.val$a.getPackageName())));
        }
    }

    /* renamed from: shirazwebdevelopers.ehsankarimi.instaautodownloader.DialogUtils.2 */
    static class C15352 implements OnClickListener {
        private final /* synthetic */ Editor val$mEdit;
        private final /* synthetic */ SharedPreferences val$mSharedPrefs;

        C15352(SharedPreferences sharedPreferences, Editor editor) {
            this.val$mSharedPrefs = sharedPreferences;
            this.val$mEdit = editor;
        }

        public void onClick(DialogInterface arg0, int arg1) {
            arg0.dismiss();
            if (this.val$mSharedPrefs.getInt("noCount", 0) > 0) {
                this.val$mEdit.putBoolean("neverRate", true);
            } else {
                this.val$mEdit.putInt("rateCount", 0);
                this.val$mEdit.putInt("noCount", 1);
            }
            this.val$mEdit.commit();
        }
    }

    /* renamed from: shirazwebdevelopers.ehsankarimi.instaautodownloader.DialogUtils.3 */
    static class C15363 implements OnClickListener {
        C15363() {
        }

        public void onClick(DialogInterface arg0, int arg1) {
            arg0.dismiss();
        }
    }

    /* renamed from: shirazwebdevelopers.ehsankarimi.instaautodownloader.DialogUtils.4 */
    static class C15374 implements View.OnClickListener {
        private final /* synthetic */ Dialog val$d;

        C15374(Dialog dialog) {
            this.val$d = dialog;
        }

        public void onClick(View v) {
            this.val$d.dismiss();
        }
    }

    /* renamed from: shirazwebdevelopers.ehsankarimi.instaautodownloader.DialogUtils.5 */
    static class C15385 implements View.OnClickListener {
        private final /* synthetic */ Activity val$a;
        private final /* synthetic */ Dialog val$d;

        C15385(Dialog dialog, Activity activity) {
            this.val$d = dialog;
            this.val$a = activity;
        }

        public void onClick(View v) {
            this.val$d.dismiss();
            try {
                this.val$a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.ehsankarimi.unfollowers")));
            } catch (ActivityNotFoundException e) {
                this.val$a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://cafebazaar.ir/app/com.ehsankarimi.unfollowers/")));
            }
        }
    }

    /* renamed from: shirazwebdevelopers.ehsankarimi.instaautodownloader.DialogUtils.6 */
    static class C15396 implements View.OnClickListener {
        private final /* synthetic */ Activity val$act;
        private final /* synthetic */ Dialog val$d;

        C15396(Activity activity, Dialog dialog) {
            this.val$act = activity;
            this.val$d = dialog;
        }

        public void onClick(View rippleView) {
            try {
                this.val$act.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.ehsankarimi.unfollowers")));
            } catch (ActivityNotFoundException e2) {
                this.val$act.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://cafebazaar.ir/app/com.ehsankarimi.unfollowers/")));
            }
            this.val$d.dismiss();
        }
    }

    /* renamed from: shirazwebdevelopers.ehsankarimi.instaautodownloader.DialogUtils.7 */
    static class C15407 implements View.OnClickListener {
        private final /* synthetic */ Dialog val$d;

        C15407(Dialog dialog) {
            this.val$d = dialog;
        }

        public void onClick(View rippleView) {
            this.val$d.dismiss();
        }
    }

    /* renamed from: shirazwebdevelopers.ehsankarimi.instaautodownloader.DialogUtils.8 */
    static class C15418 implements View.OnClickListener {
        private final /* synthetic */ Dialog val$d;
        private final /* synthetic */ DialogBtnClickListener val$mListener;

        C15418(DialogBtnClickListener dialogBtnClickListener, Dialog dialog) {
            this.val$mListener = dialogBtnClickListener;
            this.val$d = dialog;
        }

        public void onClick(View rippleView) {
            this.val$mListener.onPositiveClick();
            this.val$d.dismiss();
        }
    }

    /* renamed from: shirazwebdevelopers.ehsankarimi.instaautodownloader.DialogUtils.9 */
    static class C15429 implements View.OnClickListener {
        private final /* synthetic */ Dialog val$d;

        C15429(Dialog dialog) {
            this.val$d = dialog;
        }

        public void onClick(View rippleView) {
            this.val$d.dismiss();
        }
    }

    public static boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static Map<String, String> getQueryMap(String query) {
        Map<String, String> map = new HashMap();
        String[] queryString = query.split("\\?");
        if (queryString.length > 1) {
            for (String param : queryString[1].split("&")) {
                map.put(param.split("=")[0], param.split("=")[1]);
            }
        }
        return map;
    }

    public static void showUpdateDialog(Activity act) {
        Dialog d = new Dialog(act, R.style.CustomDialogTheme);
        View v2 = act.getLayoutInflater().inflate(R.layout.delete_dialog, null);
        TextView tv2 = (TextView) v2.findViewById(R.id.textView1);
        tv2.setTypeface(Utils.tf);
        tv2.setText("UPDATE");
        TextView tv4 = (TextView) v2.findViewById(R.id.tv_dialogText);
        tv4.setTypeface(Utils.tf);
        tv4.setText("locker app needs update to use this feature");
        TextView tv5 = (TextView) v2.findViewById(R.id.tvDelete);
        tv5.setTypeface(Utils.tf);
        tv5.setText("UPDATE");
        TextView tv6 = (TextView) v2.findViewById(R.id.tvCancel);
        tv6.setTypeface(Utils.tf);
        tv6.setText("CANCEL");
        tv6.setTextColor(Color.DKGRAY);
        d.setContentView(v2);
        v2.findViewById(R.id.rlDelete).setOnClickListener(new C15396(act, d));
        v2.findViewById(R.id.rlCancel).setOnClickListener(new C15407(d));
        d.show();
    }

    public static void showDeleteDialog(Activity a, DialogBtnClickListener mListener) {
        Dialog d = new Dialog(a, R.style.CustomDialogTheme);
        View v2 = a.getLayoutInflater().inflate(R.layout.delete_dialog, null);
        ((TextView) v2.findViewById(R.id.textView2)).setTypeface(Utils.tf);
        ((TextView) v2.findViewById(R.id.tv_dialogText)).setTypeface(Utils.tf);
        d.setContentView(v2);
        v2.findViewById(R.id.rlDelete).setOnClickListener(new C15418(mListener, d));
        v2.findViewById(R.id.rlCancel).setOnClickListener(new C15429(d));
        d.show();
    }
}
