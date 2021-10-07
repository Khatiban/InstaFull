package com.fury.instafull;

/**
 * Created by fury on 3/23/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Patterns;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class StoryDownloader {
    static final String TAG = "SSS";
    File file;
    OkHttpClient http_client;
    public int mid;
    Intent resultIntent;
    Context cntext;
    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    /* renamed from: io.soheil.isave.StoryDownloader.1 */
    class C03551 implements Runnable {
        final /* synthetic */ String val$type;
        final /* synthetic */ String val$url;
        final /* synthetic */ String val$username;
        final /* synthetic */ String val$user;
        final /* synthetic */ String all;

        /* renamed from: io.soheil.isave.StoryDownloader.1.1 */
        class C03531 implements Runnable {
            C03531() {
            }

            public void run() {
                Toast.makeText(cntext, "Error : Not Save Story!", Toast.LENGTH_SHORT).show();
            }
        }

        C03551(String str, String str2, String str3, String str4,String str5) {
            this.val$url = str;
            this.val$type = str2;
            this.val$username = str3;
            this.val$user = str4;
            this.all = str5;
        }

        public void run() {
            if (Patterns.WEB_URL.matcher(this.val$url).matches()) {
                String file_url = this.val$url;
                String name_video = one_play_preferences.getString("STORY_VIDEO", "InstaFull/Story/Video");
                String name_image = one_play_preferences.getString("STORY_IMAGE", "InstaFull/Story/Image");
                String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) ;
                String file_path = Environment.getExternalStorageDirectory().getPath() + File.separator + (this.val$type.equals("v") ? name_video : name_image) + File.separator + timeStamp + this.val$username + "." + (this.val$type.equals("v") ? "mp4" : "jpg");
                try {
                    ResponseBody body = http_client.newCall(new Request.Builder().url(file_url).build()).execute().body();
                    long contentLength = body.contentLength();
                    BufferedSource source = body.source();
                    file = new File(file_path);
                    BufferedSink sink = Okio.buffer(Okio.sink(file));
                    sink.writeAll(source);
                    sink.flush();
                    sink.close();
                    return;
                } catch (Exception e) {
                    try {
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
            }
            new C03531();
        }
    }

    public StoryDownloader(Context context) {
        this.file = null;
        this.http_client = new OkHttpClient();
        cntext = context;
        one_play_preferences = cntext.getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        one_play_editor = one_play_preferences.edit();
    }

    public void download(String url, String type, String username, String user, int all) {
        String alls = String.valueOf(all);
        new Thread(new C03551(url, type, username, user, alls)).start();
    }
}

