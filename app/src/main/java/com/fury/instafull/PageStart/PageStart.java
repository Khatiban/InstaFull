package com.fury.instafull.PageStart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import com.fury.instafull.MainActivity;
import com.fury.instafull.MyDatabaseHelper;
import com.fury.instafull.MyDatabaseHelper_url;
import com.fury.instafull.R;
import com.google.firebase.crash.FirebaseCrash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fury on 1/28/2017.
 */
public class PageStart extends AhoyOnboarderActivity {

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    String SCheck;

    MyDatabaseHelper S64_data;
    MyDatabaseHelper_url url_data;


    String b64 = "01";
    String b64_1 = "001101010010010100100101000010010010010110101001000";///
    String b64_2 = "00101001110010000100110011101101011011100010110100001101011011010010100011100111001011101110011000001000010010000010101000101000101010001100100000";//
    String b64_3 = "1010000010100111101000011010000010101000100111000010000010100110101001001010010010100001001000011";//
    String b64_4 = "0110011101001011010000110100000101010001010001010100000101101010010";//
    String b64_5 = "01101001100110110001101110001011001100110001101011001011011";//
    String b64_6 = "00010001100100000101001001011010000110111001000100011001110011000101001000011101100110001101010111011010110011100001110110001";//
    String b64_7 = "01101101111010011100101000001100100010101110100011001010111010010";///
    String b64_8 = "0101110100011001100110110101110100001100000110101000110010001101000101000001010010010000110110101101100111010101010011000001110111011011000111011100";///
    String b64_9 = "110011011110000011100001001110011100110010101101111001001101010101011000110101001100110011001001011000011";//
    String b64_10 = "011000110011001001000010101110010111101100110010001000110111101001011011100010100001101000111";//
    String b64_11 = "010000011101010100000101010111010011010110111001111000011";///
    String b64_12 = "01011011001110110100000111001011010000011100100";//
    String b64_13 = "111001011100110111000101101001010100100110010101110100001101010101001001010101010010100011000";//
    String b64_14 = "00110011001110001010010100111011101001001010001010010111101101110001100010111001101100010010";//
    String b64_15 = "1001101110001010010010010101101101010010100100";//
    String b64_16 = "1100100110110010010100";///
    String b64_17 = "11001010101101001100100010100000011011001000111";//
    String b64_18 = "0111001101001110010001100111";//
    String b64_19 = "110100101001011010010011010101001101101000001101100111011";///
    String b64_20 = "001111010011100000101000100110111011110000011001100110111001100010110001100110011011010100011000001";//
    String b64_21 = "111000010011000100001101101101010101010111011001100111010110100111100001001010010011000101011001000100011110000010101101101011010000010100";//
    String b64_22 = "11100101000001010011010000010110011001101110010100000100100001000110011001110011100100110010011001110";//
    String b64_23 = "1101010010001010110011101000010011011010010101101110011001110010100011101100011011100";//
    String b64_24 = "01010110100101101001000001011001000110111101101101011000100111100001110010011100100011001101001100011001110110111001010010011110010";//
    String b64_25 = "11011100100010101000011010010100010101100110011010000100011";//
    String b64_26 = "00010100100110101001110000011000100010111101111001010110010";///
    String b64_27 = "110111100101111010110010111100001100111010101100100101001000111010000010110011101100010011001010111010001110";//
    String b64_28 = "101010010000010111100110011011010010111001001011010010110010110010101110011011000";//
    String b64_29 = "010111001100101111010001110111101000110001011010";//
    String b64_30 = "01010100010100000110110101101111010000100101100001100001011";///
    String b64_31 = "01001010010000101100001001";//
    String b64_32 = "1010100000101101100";//
    String b64_33 = "0111011001001000011010110111101";//
    String b64_34 = "00100101001000101011010110111100100110111011010110100011100110000011000110100001001110011011100010111100000110";//
    String b64_35 = "00110100100101011010010110010101101111000011101110110000101010010010011000011010001100101011001110101001101000010011001110111001";///
    String b64_36 = "0010001010110110001101010010001100101101001000010011100000111010101001010011110000110111001010010011101000011001101001100011011010111010101110111001110010";
    String b64_37 = "11010110100101001000100011000100100100101001011011110000101001101110110010110000100100101000010001100100100101001000010001101000111000001101111010101000110011001100110010001000101010101010001010010010100010001000001010100010100000101000010";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b64_1 = b64 + b64_1;
        b64_7 = b64 + b64_7;
        b64_11 = b64 + b64_11;
        b64_16 = b64 + b64_16;
        b64_19 = b64 + b64_19;
        b64_26 = b64 + b64_26;
        b64_30 = b64 + b64_30;
        b64_35 = b64 + b64_35;

        S64_data = new MyDatabaseHelper(this);
        url_data = new MyDatabaseHelper_url(this);

        String input = b64_1 + b64_2 + b64_3 + b64_4 + b64_5 + b64_6 + b64_7 + b64_8 + b64_9 + b64_10 + b64_11 + b64_12 + b64_13 + b64_14 +
                b64_15 + b64_16 + b64_17 + b64_18 + b64_19 + b64_20 + b64_21 + b64_22 + b64_23 + b64_24 + b64_25 + b64_26 + b64_27 + b64_28 +
                b64_29 + b64_30 + b64_31 + b64_32 + b64_33 + b64_34 + b64_35 + b64_36 + b64_37 ;

        one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        one_play_editor = one_play_preferences.edit();
        try {
            S64_data.insertData(input, "1");
            url_data.insertData("0110100001110100011101000111000001110011001110100010111100101111011100110110111101101000011001010110100101101100001011100110100101101111001011110110100101110011011000010111011001100101001011110111011000110010001011110111001101110100011011110111001001111001001011010011000100101110011100000110100001110000001111110111010100111101", "1");
        } catch (Exception e) {
            e.printStackTrace();
        }



        one_play_editor.putBoolean("coin_play", true);
        one_play_editor.apply();


        String page_1_1 = "Welcome";
        String page_1_2 = "welcome to InstaFull world";
        String page_2_1 = "Why InstaFull?";
        String page_2_2 = "Free , High speed , Easy";
        String page_3_1 = "Download Posts";
        String page_3_2 = "After enabling InstaFull by copying address post on Instagram automatic download starts";
        String page_4_1 = "Watch Pictures and Video";
        String page_4_2 = "Watch photos and videos download with advanced settings. Easy, Fast,Professional and everything free";
        String page_5_1 = "Download Profile";
        String page_5_2 = "After enabling InstaFull by copying profile URL on instagram automatic download starts";
        String page_7_1 = "Download Stories";
        String page_7_2 = "After enabling InstaFull by copying profile URL on instagram automatic download starts Stories";
        String page_10_1 = "Coin";
        String page_10_2 = "You have 2000 coins free";
        String page_11_1 = "Shop";
        String page_11_2 = "Store coins free or coins buy for that coins needs";

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard(page_1_1, page_1_2, R.drawable.welcome);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard(page_2_1, page_2_2, R.drawable.instafull);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard(page_3_1, page_3_2, R.drawable.download_post);
        AhoyOnboarderCard ahoyOnboarderCard4 = new AhoyOnboarderCard(page_4_1, page_4_2, R.drawable.help_post);
        AhoyOnboarderCard ahoyOnboarderCard5 = new AhoyOnboarderCard(page_5_1, page_5_2, R.drawable.download_profile_and_story);
        AhoyOnboarderCard ahoyOnboarderCard7 = new AhoyOnboarderCard(page_7_1, page_7_2, R.drawable.download_profile_and_story);
        AhoyOnboarderCard ahoyOnboarderCard10 = new AhoyOnboarderCard(page_10_1, page_10_2, R.drawable.hedeye);
        AhoyOnboarderCard ahoyOnboarderCard11 = new AhoyOnboarderCard(page_11_1, page_11_2, R.drawable.story);

        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard3.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard4.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard5.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard7.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard10.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard11.setBackgroundColor(R.color.black_transparent);

        List<AhoyOnboarderCard> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);
        pages.add(ahoyOnboarderCard5);
        pages.add(ahoyOnboarderCard7);
        pages.add(ahoyOnboarderCard4);
        pages.add(ahoyOnboarderCard10);
        pages.add(ahoyOnboarderCard11);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.colorPrimary);
            page.setDescriptionColor(R.color.colorPrimary);
        }

        setFinishButtonTitle("Let's go");

        showNavigationControls(true);
        setGradientBackground();

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/A-Chamran.ttf");
        setFont(face);

        setInactiveIndicatorColor(R.color.grey_app);
        setActiveIndicatorColor(R.color.colorPrimary);

        setOnboardPages(pages);

        FirebaseCrash.log("log 1");
        System.gc();
    }


    @Override
    public void onFinishButtonPressed() {

        Intent uou = new Intent(PageStart.this, MainActivity.class);
        startActivity(uou);
        PageStart.this.finish();

    }


}
