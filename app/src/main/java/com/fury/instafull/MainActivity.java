package com.fury.instafull;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fury.instafull.PageStart.PageStart;
import com.downloadme.service.ClipboardListenerService;
import com.google.firebase.crash.FirebaseCrash;
import com.instagram.data.Utils;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView on_app, toast_on_or_off, CoinSingle, off_app;

    RelativeLayout back_on, open_instagram, rel_1, toast_view, back_off;

    ImageView home, profile, image, story, setting, instagram_FURY, Telegram_FURY;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    Boolean on_or_off, auto_on, one_play, coin_play, coin_alfa,one_play_again;

    String coin;
    int anim_start;
    int coinint, outs;

    public static MainActivity act;
    File root, root1, root2, root3, root4, root5, root6, root7, root8, root9, root10, root11;

    int FreeN = 0;

    private static final String TAG = "UpdateCheck";
    String s64 = "0100110101001001010010010100001001001001011010100100000101001110010000100110011101101011011100010110100001101011011010010100011100111001011101110011000001000010010000010101000101000101010001100100000101000001010011110100001101000001010100010011100001000001010011010100100101001001010000100100001101100111010010110100001101000001010100010100010101000001011010100100110100110011011000110111000101100110011000110101100101101100010001100100000101001001011010000110111001000100011001110011000101001000011101100110001101010111011010110011100001110110001010110110111101001110010100000110010001010111010001100101011101001001011101000110011001101101011101000011000001101010001100100011010001010000010100100100001101101011011001110101010100110000011101110110110001110111001100110111100000111000010011100111001100101011011110010011010101010110001101010011001100110010010110000110110001100110010010000101011100101111011001100100010001101111010010110111000101000011010001110101000001110101010000010101011101001101011011100111100001101011011001110110100000111001011010000011100100111001011100110111000101101001010100100110010101110100001101010101001001010101010010100011000001100110011100010100101001110111010010010100010100101111011011100011000101110011011000100101001101110001010010010010101101101010010100100011100100110110010010100110010101011010011001000101000000110110010001110111001101001110010001100111011101001010010110100100110101010011011010000011011001110110011110100111000001010001001101110111100000110011001101110011000101100011001100110110101000110000011110000100110001000011011011010101010101110110011001110101101001111000010010100100110001010110010001000111100000101011011010110100000101001110010100000101001101000001011001100110111001010000010010000100011001100111001110010011001001100111011010100100010101100111010000100110110100101011011100110011100101000111011000110111000101011010010110100100000101100100011011110110110101100010011110000111001001110010001100110100110001100111011011100101001001111001011011100100010101000011010010100010101100110011010000100011010001010010011010100111000001100010001011110111100101011001011011110010111101011001011110000110011101010110010010100100011101000001011001110110001001100101011101000111010101001000001011110011001101101001011100100101101001011001011001010111001101100001011100110010111101000111011110100011000101101001010101000101000001101101011011110100001001011000011000010110100101001000010110000100110101000001011011000111011001001000011010110111101001001010010001010110101101111001001101110110101101000111001100000110001101000010011100110111000101111000001100100110100100101011010010110010101101111000011101110110000101010010010011000011010001100101011001110101001101000010011001110111001001000101011011000110101001000110010110100100001001110000011101010100101001111000011011100101001001110100001100110100110001101101011101010111011100111001011010110100101001000100011000100100100101001011011110000101001101110110010110000100100101000010001100100100101001000010001101000111000001101111010101000110011001100110010001000101010101010001010010010100010001000001010100010100000101000010";

    ScheduledThreadPoolExecutor mDialogDaemon_time, mDialogDaemon_coin;

    String currentVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            currentVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        one_play_editor = one_play_preferences.edit();

        on_or_off = one_play_preferences.getBoolean("on_or_off_app", false);
        auto_on = one_play_preferences.getBoolean("AUTO_ON", false);
        one_play = one_play_preferences.getBoolean("one_play", false);
        coin_play = one_play_preferences.getBoolean("coin_play", false);
        coin_alfa = one_play_preferences.getBoolean("COIN_Alfa", false);
        one_play_again = one_play_preferences.getBoolean("one_play_again", false);
        coinint = one_play_preferences.getInt("COIN", 0);
        coin = String.valueOf(coinint);
        if (auto_on) {

            one_play_editor.putBoolean("on_or_off_app", true);
            one_play_editor.apply();

            Intent startIntent = new Intent(MainActivity.this, ForegroundService.class);
            startIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
            startService(startIntent);
            startService(new Intent(getApplicationContext(), ClipboardListenerService.class));
            openApplication("com.instagram.android");
            finish();

        }

        if (coin_play) {

            (new DialogCoinStart(MainActivity.this)).showDialog();

            one_play_editor.putBoolean("coin_play", false);
            one_play_editor.apply();
        }

        if (!one_play) {

            one_play_editor.putString("S64", s64);
            one_play_editor.putBoolean("one_play_again", true);
            one_play_editor.putBoolean("one_play", true);
            one_play_editor.apply();

            Intent start = new Intent(this, PageStart.class);
            startActivity(start);
            overridePendingTransition(0, 0);
            finish();

        }

        if (one_play_again){

            root2 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/log_app_instafull");
            root3 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log");
            root4 = new File(Environment.getExternalStorageDirectory(), "Android/data/com.android.fury.instafull/log_app_instafull");
            root5 = new File(Environment.getExternalStorageDirectory(), "Android/data/com.android.fury.instafull");
            root6 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/a000");
            root7 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/b000");
            root8 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/c000");
            root9 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/d000");
            root10 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/ab000");
            root11 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/c0000");

            if (!root4.exists() && !root5.exists() && !root3.exists() && !root2.exists()) {
                FreeN = 1;
            }else {

            }


            if (!root2.exists()) {
                if (!root3.exists()) {
                    generateNoteOnSD(getApplicationContext(), "log_app_instafull", "junhn s;i 0");
                } else {
                    ///0
                }
            } else {
                ///0
            }

            if (!root4.exists()) {
                if (!root5.exists()) {
                    generateNoteOnSD2(getApplicationContext(), "log_app_instafull", "junhn s;i 0");
                } else {
                    ///0
                }
            } else {
                ///0
            }

            if (root11.exists()) {
                FreeN = 2;
                root11.delete();
            } else if (root10.exists()) {
                FreeN = 3;
                root10.delete();
            } else if (root9.exists()) {
                FreeN = 4;
                root9.delete();
            } else if (root8.exists()) {
                FreeN = 5;
                root8.delete();
            } else if (root7.exists()) {
                FreeN = 6;
                root7.delete();
            } else if (root6.exists()) {
                FreeN = 7;
                root6.delete();
            }
        }

        setContentView(R.layout.activity_main);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Utils.f100w = dm.widthPixels;
        Utils.f99h = dm.heightPixels;

        on_app = (TextView) findViewById(R.id.on_app_insta);
        off_app = (TextView) findViewById(R.id.off_app_insta);
        CoinSingle = (TextView) findViewById(R.id.CoinSingle);
        toast_on_or_off = (TextView) findViewById(R.id.toast_on_or_off);
        back_on = (RelativeLayout) findViewById(R.id.back_on);
        back_off = (RelativeLayout) findViewById(R.id.back_off);
        open_instagram = (RelativeLayout) findViewById(R.id.open_instagram);
        toast_view = (RelativeLayout) findViewById(R.id.toast_view);
        rel_1 = (RelativeLayout) findViewById(R.id.rel_1);
        home = (ImageView) findViewById(R.id.home_page);
        profile = (ImageView) findViewById(R.id.profile);
        image = (ImageView) findViewById(R.id.image_page);
        story = (ImageView) findViewById(R.id.story);
        setting = (ImageView) findViewById(R.id.setting);
        instagram_FURY = (ImageView) findViewById(R.id.instagram_FURY);
        Telegram_FURY = (ImageView) findViewById(R.id.Telegram_FURY);

        int min = 1;
        int max = 3;
        Random r = new Random();
        int khodkar_1 = r.nextInt(max - min + 1) + min;
        if (khodkar_1 == 1){
            open_instagram.setBackgroundResource(R.drawable.instagram_back_1);
        }else if (khodkar_1 == 2){
            open_instagram.setBackgroundResource(R.drawable.instagram_back_1);
        }else if (khodkar_1 == 3){
            open_instagram.setBackgroundResource(R.drawable.instagram_back_1);
        }

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/A-Chamran.ttf");

        on_app.setTypeface(face);
        toast_on_or_off.setTypeface(face);
        off_app.setTypeface(face);

        if (coin_alfa) {
            CoinSingle.setText("Unlimited");
        } else {

            if (mDialogDaemon_time != null) {
                try {
                    mDialogDaemon_time.shutdown();
                    mDialogDaemon_time = null;
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("12"));
                }
            }
            try {
                mDialogDaemon_time = new ScheduledThreadPoolExecutor(1);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("13"));
            }
            try {
                mDialogDaemon_time.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                try{
                                    coinint = one_play_preferences.getInt("COIN", 0);
                                    coin = String.valueOf(coinint);
                                    CoinSingle.setText(coin);
                                }catch (Exception e){
                                    mDialogDaemon_time.shutdown();
                                    mDialogDaemon_time = null;
                                    FirebaseCrash.report(new Exception("14"));
                                }

                            }
                        });
                    }
                }, 0L, 2000L, TimeUnit.MILLISECONDS);

            } catch (Exception e) {
                mDialogDaemon_time.shutdown();
                mDialogDaemon_time = null;
                FirebaseCrash.report(new Exception("14"));
            }

        }

        if (FreeN == 1) {
            anim_coin(2000);
            one_play_editor.putInt("COIN", 2000);
            one_play_editor.apply();
        }

        if (FreeN == 2) {
            one_play_editor.putBoolean("COIN_Alfa", true);
            one_play_editor.putInt("COIN", 5000000);
            one_play_editor.apply();
        } else if (FreeN == 3) {
            anim_coin(5000000);
            one_play_editor.putInt("COIN", 5000000);
            one_play_editor.apply();
        } else if (FreeN == 4) {
            anim_coin(2000000);
            one_play_editor.putInt("COIN", 2000000);
            one_play_editor.apply();
        } else if (FreeN == 5) {
            anim_coin(500000);
            one_play_editor.putInt("COIN", 500000);
            one_play_editor.apply();
        } else if (FreeN == 6) {
            anim_coin(200000);
            one_play_editor.putInt("COIN", 200000);
            one_play_editor.apply();
        } else if (FreeN == 7) {
            anim_coin(20000);
            one_play_editor.putInt("COIN", 20000);
            one_play_editor.apply();
        } else if (FreeN == 8) {
            coinint = one_play_preferences.getInt("COIN", 0);
            int coinupdate = coinint + 4000;
            anim_coin(coinupdate);
            one_play_editor.putInt("COIN", coinupdate);
            one_play_editor.apply();
        }


        home.setImageResource(R.drawable.dock_home_whiteout);

        open_instagram.setVisibility(View.INVISIBLE);

        if (on_or_off) {
            if (app_net.getInstance(this).isOnline()) {

                back_off.setVisibility(View.GONE);
                back_on.setVisibility(View.VISIBLE);
                Intent startIntent = new Intent(MainActivity.this, ForegroundService.class);
                startIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
                startService(startIntent);
                startService(new Intent(getApplicationContext(), ClipboardListenerService.class));
                card_start();
                toast_on_or_off.setBackgroundResource(R.color.color_toast_green);
                toast_on_or_off.setText("Instafull Active");

                if (anim_start == 0) {
                    animtoast();
                } else {
                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            animtoast();
                        }
                    }, 2000);
                }
            } else {

                back_on.setVisibility(View.GONE);
                back_off.setVisibility(View.VISIBLE);
                sendBroadcast(new Intent(Constants.ACTION.STOPFOREGROUND_ACTION));
                stopService(new Intent(getApplicationContext(), ClipboardListenerService.class));
                card_end();

            }
        }

        back_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one_play_editor.putBoolean("on_or_off_app", false);
                one_play_editor.apply();

                back_on.setVisibility(View.GONE);
                back_off.setVisibility(View.VISIBLE);
                sendBroadcast(new Intent(Constants.ACTION.STOPFOREGROUND_ACTION));
                stopService(new Intent(getApplicationContext(), ClipboardListenerService.class));
                card_end();


                toast_on_or_off.setBackgroundResource(R.color.color_toast_red);
                toast_on_or_off.setText("Instafull Disabled");

                if (anim_start == 0) {
                    animtoast();
                } else {
                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            animtoast();
                        }
                    }, 2000);
                }

            }
        });

        back_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (app_net.getInstance(MainActivity.this).isOnline()) {

                    boolean isAppInstalled = appInstalledOrNot("com.instagram.android");

                    one_play_editor.putBoolean("on_or_off_app", true);
                    one_play_editor.apply();

                    back_off.setVisibility(View.GONE);
                    back_on.setVisibility(View.VISIBLE);

                    if(isAppInstalled) {
                        Intent startIntent = new Intent(MainActivity.this, ForegroundService.class);
                        startIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
                        startService(startIntent);
                        startService(new Intent(getApplicationContext(), ClipboardListenerService.class));
                    } else {

                    }

                    card_start();

                    toast_on_or_off.setBackgroundResource(R.color.color_toast_green);
                    toast_on_or_off.setText("Instafull Active");

                    if (anim_start == 0) {
                        animtoast();
                    } else {
                        new Handler().postDelayed(new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                animtoast();
                            }
                        }, 2000);
                    }

                } else {

                    toast_on_or_off.setBackgroundResource(R.color.color_toast_blue);
                    toast_on_or_off.setText("Disconnect Internet");
                    if (anim_start == 0) {
                        animtoast();
                    } else {
                        new Handler().postDelayed(new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                animtoast();
                            }
                        }, 2000);
                    }

                }
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent profile = new Intent(MainActivity.this, Profile_page.class);
                startActivity(profile);
                overridePendingTransition(0, 0);

            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent post = new Intent(MainActivity.this, Post_view.class);
                startActivity(post);
                overridePendingTransition(0, 0);

            }
        });

        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent post = new Intent(MainActivity.this, Story_view.class);
                startActivity(post);
                overridePendingTransition(0, 0);

            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent setting = new Intent(MainActivity.this, Setting.class);
                startActivity(setting);
                overridePendingTransition(0, 0);

            }
        });


        instagram_FURY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/fury_studio_ir");
                Intent inestagram = new Intent(Intent.ACTION_VIEW, uri);
                inestagram.setPackage("com.instagram.android");
                try {
                    startActivity(inestagram);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/fury_studio_ir")));
                }
            }
        });

        Telegram_FURY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://t.me/Fury_studio");
                Intent inestagram = new Intent(Intent.ACTION_VIEW, uri);
                inestagram.setPackage("org.telegram.messenger");
                try {
                    startActivity(inestagram);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://t.me/Fury_studio")));
                }
            }
        });

        open_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApplication("com.instagram.android");
            }
        });


            new GetVersionCode().execute();
		
        FirebaseCrash.log("log 1");
        System.gc();

    }

    public void card_start() {

        try {
            open_instagram.setVisibility(View.VISIBLE);
            open_instagram.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.in));
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("card_start"));
        }
    }

    public void card_end() {

        try {
            open_instagram.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.out));
            open_instagram.setVisibility(View.INVISIBLE);
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("card_start"));
        }
    }

    public void openApplication(String packageN) {
        Intent i = getPackageManager().getLaunchIntentForPackage(packageN);
        if (i != null) {
            startActivity(i);
            return;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageN)));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + packageN)));
            FirebaseCrash.report(new Exception("open instagram go to google play"));
        }
    }


    //other


    public void addImageToList(String filePath) {
        //null
    }

    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {

            root = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            FirebaseCrash.report(new Exception("save log name : generateNoteOnSD"));
        }
    }

    public void generateNoteOnSD2(Context context, String sFileName, String sBody) {
        try {

            root1 = new File(Environment.getExternalStorageDirectory(), "Android/data/com.android.fury.instafull");
            if (!root1.exists()) {
                root1.mkdirs();
            }
            File gpxfile = new File(root1, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            FirebaseCrash.report(new Exception("save log name : generateNoteOnSD2"));
        }
    }

    public void animtoast() {
        anim_start = 1;
        toast_on_or_off.setVisibility(View.VISIBLE);
        toast_on_or_off.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.in_toast));
        new Handler().postDelayed(new Thread() {

            @Override
            public void run() {
                super.run();
                anim_start = 0;
                toast_on_or_off.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.out_toast));
                toast_on_or_off.setVisibility(View.INVISIBLE);
            }
        }, 3000);

        FirebaseCrash.log("log animtoast");
    }


    public void anim_coin(final int a) {
        int b;

        if (a >= 20000 && a <= 200000) {
            b = 10;
        } else if (a >= 200000 && a <= 500000) {
            b = 80;
        } else if (a >= 500000 && a <= 2000000) {
            b = 280;
        } else if (a >= 2000000 && a <= 5000000) {
            b = 2860;
        } else if (a >= 5000000) {
            b = 5860;
        } else {
            b = 1;
        }
        outs = 1;

        if (mDialogDaemon_coin != null) {
            try {
                mDialogDaemon_coin.shutdown();
                mDialogDaemon_coin = null;
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("12"));
            }
        }
        try {
            mDialogDaemon_coin = new ScheduledThreadPoolExecutor(1);
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("13"));
        }
        try {
            final int finalB = b;
            mDialogDaemon_coin.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                if (outs < a) {
                                    outs = outs + finalB;
                                    final int finalS = outs;
                                    String n = String.valueOf(finalS);
                                    CoinSingle.setText(n);
                                } else {
                                    mDialogDaemon_coin.shutdown();
                                    mDialogDaemon_coin = null;
                                }
                            } catch (Exception e) {
                                String n = String.valueOf(a);
                                CoinSingle.setText(n);
                            }

                        }
                    });
                }
            }, 0L, 1L, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            String n = String.valueOf(a);
            CoinSingle.setText(n);
            FirebaseCrash.report(new Exception("14"));
        }
    }



    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }


    private class GetVersionCode extends AsyncTask<Void, String, String> {
        @Override
        protected String doInBackground(Void... voids) {

            String newVersion = null;
            try {
                newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName() + "&hl=it")
                        .timeout(30000)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.google.com")
                        .get()
                        .select("div[itemprop=softwareVersion]")
                        .first()
                        .ownText();
                return newVersion;
            } catch (Exception e) {
                return newVersion;
            }
        }

        @Override
        protected void onPostExecute(String onlineVersion) {
            super.onPostExecute(onlineVersion);
            if (onlineVersion != null && !onlineVersion.isEmpty()) {
                try {
                    currentVersion = currentVersion.replace(".","");
                    onlineVersion = onlineVersion.replace(".","");
                    int i1 = Integer.parseInt(currentVersion);
                    int i2 = Integer.parseInt(onlineVersion);
                    if (i1 < i2) {
                    //show dialog
                        (new DialogUpdate(MainActivity.this)).showDialog();
                }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, currentVersion + " update "+ onlineVersion, Toast.LENGTH_LONG).show();
                }
            }
            Log.d("update", "Current version " + currentVersion + "playstore version " + onlineVersion);
        }
    }




}






