package com.fury.instafull;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.SkuDetails;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.firebase.crash.FirebaseCrash;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Store extends Activity implements View.OnClickListener, BillingProcessor.IBillingHandler {

    RelativeLayout card_free_coin_insta, ads_video, card_coin_telegram, card_coin_1000, card_coin_2000, card_coin_5000, card_coin_9000, card_coin_16000, card_coin_8;
    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    int coin_plus, outs;
    String tedad_coin;

    ImageView back_page_video;

    Boolean telegram_save, instagram_save, coin_alfa, click, start, log, not_one_ads;

    TextView off_6, off_5, off_4, off_3, off_2, off_1, CoinSingle, text_2, text_1, text_22, text_11, text_222, text_111, text_coin_number_1, text_money_2, text_coin_number_2, text_money_1, text_coin_number_3, text_money_3, text_coin_number_4, text_money_4, text_coin_number_5, text_money_5, text_coin_number_6, text_money_6;

    ScrollView scrollView;

    // SKUs for our products: the premium upgrade (non-consumable)
    static final String SKU_PREMIUM = "ttcgp";
    static final String SKU_PREMIUM2 = "thtcgp";
    static final String SKU_PREMIUM3 = "fhtcgp";
    static final String SKU_PREMIUM4 = "tmcgp";
    static final String SKU_PREMIUM5 = "fmcgp";
    static final String SKU_PREMIUM6 = "icgp";

    static String SKU, SCheck, b64key;

    int coinint, ads_plus,key_1,key_2,key_3,key_4,key_5,key_6;

    int nov = 0;

    File root, root1, root2, root3, root4, root5;

    private ScheduledThreadPoolExecutor mDialogDaemon_time, mDialogDaemon_coin;

    MyDatabaseHelper key_64;

    BillingProcessor bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        key_64 = new MyDatabaseHelper(this);
        StringBuffer dadeha = new StringBuffer();
        Cursor res_2 = key_64.showAllData();
        while (res_2.moveToNext()) {
            dadeha.append(res_2.getString(1));
        }
        b64key = dadeha.toString();
        String output = "";
        for (int i = 0; i <= b64key.length() - 8; i += 8) {
            int k = Integer.parseInt(b64key.substring(i, i + 8), 2);
            output += (char) k;
        }
        setContentView(R.layout.content_store);

        root = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/a000");
        root1 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/b000");
        root2 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/c000");
        root3 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/d000");
        root4 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/ab000");
        root5 = new File(Environment.getExternalStorageDirectory(), "InstaFull/Log/c0000");

        one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        one_play_editor = one_play_preferences.edit();
        SCheck = one_play_preferences.getString("S64", "");
        key_1 = one_play_preferences.getInt("key1", 0);
        key_2 = one_play_preferences.getInt("key2", 0);
        key_3 = one_play_preferences.getInt("key3", 0);
        key_4 = one_play_preferences.getInt("key4", 0);
        key_5 = one_play_preferences.getInt("key5", 0);
        key_6 = one_play_preferences.getInt("key6", 0);

        click = false;
        start = false;
        log = false;
        not_one_ads = false;

        card_free_coin_insta = (RelativeLayout) findViewById(R.id.card_free_coin_insta);
        ads_video = (RelativeLayout) findViewById(R.id.ads_video);
        card_coin_telegram = (RelativeLayout) findViewById(R.id.card_coin_telegram);
        card_coin_1000 = (RelativeLayout) findViewById(R.id.card_coin_1000);
        card_coin_2000 = (RelativeLayout) findViewById(R.id.card_coin_2000);
        card_coin_5000 = (RelativeLayout) findViewById(R.id.card_coin_5000);
        card_coin_9000 = (RelativeLayout) findViewById(R.id.card_coin_9000);
        card_coin_16000 = (RelativeLayout) findViewById(R.id.card_coin_16000);
        card_coin_8 = (RelativeLayout) findViewById(R.id.card_coin_8);
        CoinSingle = (TextView) findViewById(R.id.CoinSingle);
        text_2 = (TextView) findViewById(R.id.text_2);
        text_1 = (TextView) findViewById(R.id.text_1);
        text_22 = (TextView) findViewById(R.id.text_22);
        text_11 = (TextView) findViewById(R.id.text_11);
        text_222 = (TextView) findViewById(R.id.text_222);
        text_111 = (TextView) findViewById(R.id.text_111);
        text_coin_number_1 = (TextView) findViewById(R.id.text_coin_number_1);
        text_coin_number_2 = (TextView) findViewById(R.id.text_coin_number_2);
        text_money_1 = (TextView) findViewById(R.id.text_money_1);
        text_money_2 = (TextView) findViewById(R.id.text_money_2);
        off_6 = (TextView) findViewById(R.id.off_6);
        off_5 = (TextView) findViewById(R.id.off_5);
        off_4 = (TextView) findViewById(R.id.off_4);
        off_3 = (TextView) findViewById(R.id.off_3);
        off_2 = (TextView) findViewById(R.id.off_2);
        off_1 = (TextView) findViewById(R.id.off_1);
        text_coin_number_3 = (TextView) findViewById(R.id.text_coin_number_3);
        text_money_3 = (TextView) findViewById(R.id.text_money_3);
        text_coin_number_4 = (TextView) findViewById(R.id.text_coin_number_4);
        text_money_4 = (TextView) findViewById(R.id.text_money_4);
        text_coin_number_5 = (TextView) findViewById(R.id.text_coin_number_5);
        text_money_5 = (TextView) findViewById(R.id.text_money_5);
        text_coin_number_6 = (TextView) findViewById(R.id.text_coin_number_6);
        text_money_6 = (TextView) findViewById(R.id.text_money_6);
        back_page_video = (ImageView) findViewById(R.id.back_page_video);
        scrollView = (ScrollView) findViewById(R.id.scroll);

        card_coin_1000.setOnClickListener(this);
        card_coin_2000.setOnClickListener(this);
        card_coin_5000.setOnClickListener(this);
        card_coin_9000.setOnClickListener(this);
        card_coin_16000.setOnClickListener(this);
        card_coin_8.setOnClickListener(this);
        card_coin_telegram.setOnClickListener(this);
        card_free_coin_insta.setOnClickListener(this);
        ads_video.setOnClickListener(this);
        back_page_video.setOnClickListener(this);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/A-Chamran.ttf");
        text_2.setTypeface(face);
        text_1.setTypeface(face);
        text_22.setTypeface(face);
        text_11.setTypeface(face);
        text_222.setTypeface(face);
        text_111.setTypeface(face);
        text_coin_number_1.setTypeface(face);
        text_money_2.setTypeface(face);
        text_coin_number_2.setTypeface(face);
        text_money_1.setTypeface(face);
        text_coin_number_3.setTypeface(face);
        text_money_3.setTypeface(face);
        text_coin_number_4.setTypeface(face);
        text_money_4.setTypeface(face);
        text_coin_number_5.setTypeface(face);
        text_money_5.setTypeface(face);
        text_coin_number_6.setTypeface(face);
        text_money_6.setTypeface(face);

        coinint = one_play_preferences.getInt("COIN", 0);

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

                            coinint = one_play_preferences.getInt("COIN", 0);
                            tedad_coin = String.valueOf(coinint);
                            CoinSingle.setText(tedad_coin);

                        }
                    });
                }
            }, 0L, 2000L, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("14"));
        }
        check_key(dadeha.toString());
        String output2 = "";
        for (int i = 0; i <= SCheck.length() - 8; i += 8) {
            int k = Integer.parseInt(SCheck.substring(i, i + 8), 2);
            output2 += (char) k;
        }

        bp = new BillingProcessor(this, output, this);

        check_64(output2, output);
        tedad_coin = String.valueOf(coinint);
        telegram_save = one_play_preferences.getBoolean("telegram_save", false);
        instagram_save = one_play_preferences.getBoolean("instagram_save", false);
        coin_alfa = one_play_preferences.getBoolean("COIN_Alfa", false);


        if (coin_alfa) {
            CoinSingle.setText("Unlimited");
        } else {
            CoinSingle.setText(tedad_coin);
        }

        if (instagram_save) {
            card_free_coin_insta.setVisibility(View.GONE);
        }

        if (telegram_save) {
            card_coin_telegram.setVisibility(View.GONE);
        }

        SkuDetails sku1 = bp.getPurchaseListingDetails(SKU_PREMIUM);
        try {
            text_money_1.setText( sku1.priceText );
        } catch (Exception e) {
        }


        SkuDetails sku2 = bp.getPurchaseListingDetails(SKU_PREMIUM2);
        try {
            text_money_2.setText( sku2.priceText );
        } catch (Exception e) {

        }

        SkuDetails sku3 = bp.getPurchaseListingDetails(SKU_PREMIUM3);
        try {
            text_money_3.setText( sku3.priceText );
        } catch (Exception e) {

        }

        SkuDetails sku4 = bp.getPurchaseListingDetails(SKU_PREMIUM4);
        try {
            text_money_4.setText( sku4.priceText );
        } catch (Exception e) {

        }

        SkuDetails sku5 = bp.getPurchaseListingDetails(SKU_PREMIUM5);
        try {
            text_money_5.setText( sku5.priceText );
        } catch (Exception e) {

        }

        SkuDetails sku6 = bp.getPurchaseListingDetails(SKU_PREMIUM6);
        try {
            text_money_6.setText( sku6.priceText );
        } catch (Exception e) {

        }



        FirebaseCrash.log("log 1");
        System.gc();

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_page_video:
                finish();
                break;
            case R.id.ads_video:

                if (app_net.getInstance(Store.this).isOnline()) {

                    Intent adv = new Intent(this, AdVideo.class);
                    startActivity(adv);

                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.card_free_coin_insta:

                if (app_net.getInstance(Store.this).isOnline()) {
                    Uri uri = Uri.parse("http://instagram.com/_u/fury_studio_ir");
                    Intent inestagram = new Intent(Intent.ACTION_VIEW, uri);
                    inestagram.setPackage("com.instagram.android");
                    try {
                        startActivity(inestagram);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://instagram.com/fury_studio_ir")));
                    }

                    if (!instagram_save) {
                        card_free_coin_insta.setVisibility(View.GONE);
                        coin_plus = 1000 + coinint;
                        anim_coin(coin_plus);
                        one_play_editor.putInt("COIN", coin_plus);
                        one_play_editor.putBoolean("instagram_save", true);
                        one_play_editor.apply();
                        FirebaseCrash.report(new Exception("instagram_save anjamshod"));
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
                }


                break;
            case R.id.card_coin_telegram:

                if (app_net.getInstance(Store.this).isOnline()) {
                    Uri uri2 = Uri.parse("http://t.me/Fury_studio");
                    Intent inestagram2 = new Intent(Intent.ACTION_VIEW, uri2);
                    inestagram2.setPackage("org.telegram.messenger");
                    try {
                        startActivity(inestagram2);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://t.me/Fury_studio")));
                    }

                    if (!telegram_save) {
                        card_coin_telegram.setVisibility(View.GONE);
                        coin_plus = 1000 + coinint;
                        anim_coin(coin_plus);
                        one_play_editor.putInt("COIN", coin_plus);
                        one_play_editor.putBoolean("telegram_save", true);
                        one_play_editor.apply();
                        FirebaseCrash.report(new Exception("telegram_save anjamshod"));
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.card_coin_1000:

                if (app_net.getInstance(Store.this).isOnline()) {

                    SKU = "ttcgp";
                    nov = 1;

                    try {
                        bp.purchase(this, SKU);
                    } catch (Exception e) {
                        Toast.makeText(Store.this, "Please wait and click again", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.card_coin_2000:
                if (app_net.getInstance(Store.this).isOnline()) {

                    SKU = "thtcgp";
                    nov = 2;

                    try {
                        bp.purchase(this, SKU);
                    } catch (Exception e) {
                        Toast.makeText(Store.this, "Please wait and click again", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.card_coin_5000:
                if (app_net.getInstance(Store.this).isOnline()) {

                    SKU = "fhtcgp";
                    nov = 3;

                    try {
                        bp.purchase(this, SKU);
                    } catch (Exception e) {
                        Toast.makeText(Store.this, "Please wait and click again", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.card_coin_9000:
                if (app_net.getInstance(Store.this).isOnline()) {

                    SKU = "tmcgp";
                    nov = 4;

                    try {
                        bp.purchase(this, SKU);
                    } catch (Exception e) {
                        Toast.makeText(Store.this, "Please wait and click again", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.card_coin_16000:
                if (app_net.getInstance(Store.this).isOnline()) {

                    SKU = "fmcgp";
                    nov = 5;

                    try {
                        bp.purchase(this, SKU);
                    } catch (Exception e) {
                        Toast.makeText(Store.this, "Please wait and click again", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.card_coin_8:
                if (app_net.getInstance(Store.this).isOnline()) {

                    SKU = "icgp";
                    nov = 6;

                    try {
                        bp.purchase(this, SKU);
                    } catch (Exception e) {
                        Toast.makeText(Store.this, "Please wait and click again", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
                }

                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
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
        }
    }

    public void anim_coin(final int a) {

        int b;

        if (a >= 20000 && a <= 200000) {
            b = 10;
        } else if (a >= 200000 && a <= 500000) {
            b = 80;
        } else if (a >= 500000 && a <= 2000000) {
            b = 180;
        } else if (a >= 2000000 && a <= 5000000) {
            b = 1860;
        } else if (a >= 5000000) {
            b = 2860;
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

    public void get_coin(int a, int u) {
        try {
            if (u == 6) {
                CoinSingle.setText("Unlimited");
                one_play_editor.putBoolean("COIN_Alfa", true);
                one_play_editor.apply();
                Toast.makeText(Store.this, "Buy Successful", Toast.LENGTH_SHORT).show();
            } else {
                coin_plus = a + coinint;
                one_play_editor.putInt("COIN", coin_plus);
                one_play_editor.apply();
                anim_coin(coin_plus);
                Toast.makeText(Store.this, "Buy Successful", Toast.LENGTH_SHORT).show();
            }

            if (u == 1) {
                (new DialogCoinGift(Store.this, "You WIN 5000 Free Coins!", "That buy you 20000 coins and get 5000 coins gift")).showDialog();
                if (!root.exists()) {
                    generateNoteOnSD(getApplicationContext(), "a000", "junhn s;i 20000");
                }
                FirebaseCrash.report(new Exception("20000 T anjamshod Google Play"));
            } else if (u == 2) {
                (new DialogCoinGift(Store.this, "You WIN 50000 Free Coins!", "That buy you 200000 coins and get 50000 coins gift")).showDialog();
                if (!root1.exists()) {
                    generateNoteOnSD(getApplicationContext(), "b000", "junhn s;i 200000");
                }
                FirebaseCrash.report(new Exception("200000 T anjamshod Google Play"));
            } else if (u == 3) {
                (new DialogCoinGift(Store.this, "You WIN 200000 Free Coins!", "That buy you 500000 coins and get 200000 coins gift")).showDialog();
                if (!root2.exists()) {
                    generateNoteOnSD(getApplicationContext(), "c000", "junhn s;i 500000");
                }
                FirebaseCrash.report(new Exception("500000 T anjamshod Google Play"));
            } else if (u == 4) {
                (new DialogCoinGift(Store.this, "You WIN 500000 Free Coins!", "That buy you 2000000 coins and get 500000 coins gift")).showDialog();
                if (!root3.exists()) {
                    generateNoteOnSD(getApplicationContext(), "d000", "junhn s;i 2000000");
                }
                FirebaseCrash.report(new Exception("2000000 T anjamshod Google Play"));
            } else if (u == 5) {
                (new DialogCoinGift(Store.this, "You WIN 2000000 Free Coins!", "That buy you 5000000 coins and get 2000000 coins gift")).showDialog();
                if (!root4.exists()) {
                    generateNoteOnSD(getApplicationContext(), "ab000", "junhn s;i 5000000");
                }
                FirebaseCrash.report(new Exception("5000000 T anjamshod Google Play"));
            } else if (u == 6) {
                if (!root5.exists()) {
                    generateNoteOnSD(getApplicationContext(), "c0000", "junhn s;i 8");
                }
                FirebaseCrash.report(new Exception("8 T anjamshod Google Play"));
            }

        } catch (Exception e) {
            if (u == 6) {
                one_play_editor.putBoolean("COIN_Alfa", true);
                one_play_editor.apply();
            } else {
                one_play_editor.putInt("COIN", a + coinint);
                one_play_editor.apply();
                Toast.makeText(Store.this, "Buy Successful", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void check_key(String s) {
        if (!Objects.equals(s, SCheck)) {
            FirebaseCrash.report(new Exception("H_shod_" + getPackageName()));
            System.exit(0);
        }
    }

    public void check_64(String s, String i) {
        if (!Objects.equals(s, i)) {
            FirebaseCrash.report(new Exception("H_shod_" + getPackageName()));
            System.exit(0);
        }
    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {
        if (Objects.equals(productId, SKU_PREMIUM)) {
            if (key_1 == 1) {
                get_coin(25000, 1);
                one_play_editor.putInt("key1", 1);
                one_play_editor.apply();
            } else {
                Toast.makeText(this,"You have bought!",Toast.LENGTH_SHORT).show();
            }
        } else if (Objects.equals(productId, SKU_PREMIUM2)) {
            if (key_2 == 1) {
            get_coin(250000, 2);
                one_play_editor.putInt("key2", 1);
                one_play_editor.apply();
            } else {
                Toast.makeText(this,"You have bought!",Toast.LENGTH_SHORT).show();
            }
        } else if (Objects.equals(productId, SKU_PREMIUM3)) {
            if (key_3 == 1) {
            get_coin(700000, 3);
                one_play_editor.putInt("key3", 1);
                one_play_editor.apply();
            } else {
                Toast.makeText(this,"You have bought!",Toast.LENGTH_SHORT).show();
            }
        } else if (Objects.equals(productId, SKU_PREMIUM4)) {
            if (key_4 == 1) {
            get_coin(2500000, 4);
                one_play_editor.putInt("key4", 1);
                one_play_editor.apply();
            } else {
                Toast.makeText(this,"You have bought!",Toast.LENGTH_SHORT).show();
            }
        } else if (Objects.equals(productId, SKU_PREMIUM5)) {
            if (key_5 == 1) {
            get_coin(7000000, 5);
                one_play_editor.putInt("key5", 1);
                one_play_editor.apply();
            } else {
                Toast.makeText(this,"You have bought!",Toast.LENGTH_SHORT).show();
            }
        } else if (Objects.equals(productId, SKU_PREMIUM6)) {
            if (key_6 == 1) {
            get_coin(8, 6);
                one_play_editor.putInt("key6", 1);
                one_play_editor.apply();
            } else {
                Toast.makeText(this,"You have bought!",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(Store.this, productId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {
        Toast.makeText(Store.this, "Buy unsuccessful!", Toast.LENGTH_SHORT).show();
        FirebaseCrash.report(new Exception("errorCode Billing GooglePlay : " + errorCode));
    }

    @Override
    public void onBillingInitialized() {

    }
}
