package com.fury.instafull;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.crash.FirebaseCrash;

import java.io.File;

public class DialogUniversalInfoUtils {

    private Dialog mDialog;
    private TextView mDialogHeader;
    private ImageView mDialogImage;
    private TextView mDialogOKButton;
    private TextView mDialogText;
    private TextView mDialogCancelButton;
    private TextView dialog_universal_info_text;
    private TextView format_name;
    private Setting mDialogUniversalInfoActivity;
    private EditText edit_text_image;
    private String namefolder,image,video,profile,story_image,story_video,image_edit,video_edit,profile_edit,story_image_edit,story_video_edit;
    private int novsave;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    public DialogUniversalInfoUtils(Setting var1,String name,int nov) {
        this.mDialogUniversalInfoActivity = var1;
        namefolder = name;
        novsave = nov;

        one_play_preferences = mDialogUniversalInfoActivity.getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        one_play_editor = one_play_preferences.edit();

        image = one_play_preferences.getString("IMAGE_POST", "InstaFull/Pictures");
        video = one_play_preferences.getString("VIDEO_POST", "InstaFull/Video");
        profile = one_play_preferences.getString("PROFILE", "InstaFull/Profile");
        story_image = one_play_preferences.getString("STORY_IMAGE", "InstaFull/Story/Image");
        story_video = one_play_preferences.getString("STORY_VIDEO", "InstaFull/Story/Video");

        FirebaseCrash.log("log 3");
    }

    private void initDialogButtons() {
        this.mDialogOKButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {

                if (novsave == 1){
                    image_edit = edit_text_image.getText().toString();
                    if (image_edit.equals(video)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not photos with video you a file saved", Toast.LENGTH_LONG).show();
                    } else if (image_edit.equals(profile)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not photos with profile you a file saved", Toast.LENGTH_LONG).show();
                    } else if (image_edit.equals(story_image)) {
                        Toast.makeText(mDialogUniversalInfoActivity,"Not photos with pictures Stories you a file saved", Toast.LENGTH_LONG).show();
                    } else if (image_edit.equals(story_video)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not photos with videos Stories you a file saved", Toast.LENGTH_LONG).show();
                    } else {
                        mDialogUniversalInfoActivity.name_folder_image_name.setText(image_edit);
                        one_play_editor.putString("IMAGE_POST",image_edit);
                        one_play_editor.commit();
                        String root = Environment.getExternalStorageDirectory().toString();
                        File myDir = new File(root + "/" + image_edit);
                        if (!myDir.exists()) {
                            myDir.mkdirs();
                        }
                        DialogUniversalInfoUtils.this.mDialog.dismiss();
                    }
                }else if (novsave == 2){
                    video_edit = edit_text_image.getText().toString();
                    if (video_edit.equals(image)) {
                        Toast.makeText(mDialogUniversalInfoActivity,"Not video with photos you a file saved", Toast.LENGTH_LONG).show();
                    } else if (video_edit.equals(profile)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not video with profile you a file saved", Toast.LENGTH_LONG).show();
                    } else if (video_edit.equals(story_image)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not video with photos Stories you a file saved", Toast.LENGTH_LONG).show();
                    } else if (video_edit.equals(story_video)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not video with video Stories you a file saved", Toast.LENGTH_LONG).show();
                    } else {
                        mDialogUniversalInfoActivity.name_folder_video_name.setText(video_edit);
                        one_play_editor.putString("VIDEO_POST",video_edit);
                        one_play_editor.commit();
                        String root = Environment.getExternalStorageDirectory().toString();
                        File myDir = new File(root + "/" + video_edit);
                        if (!myDir.exists()) {
                            myDir.mkdirs();
                        }
                        DialogUniversalInfoUtils.this.mDialog.dismiss();
                    }
                }else if (novsave == 3){
                    profile_edit = edit_text_image.getText().toString();
                    if (profile_edit.equals(video)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not profile with video you a file saved", Toast.LENGTH_LONG).show();
                    } else if (profile_edit.equals(image)) {
                        Toast.makeText(mDialogUniversalInfoActivity,"Not profile with photos you a file saved", Toast.LENGTH_LONG).show();
                    } else if (profile_edit.equals(story_image)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not profile with photos Stories you a file saved", Toast.LENGTH_LONG).show();
                    } else if (profile_edit.equals(story_video)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not profile with video Stories you a file saved", Toast.LENGTH_LONG).show();
                    } else {
                        mDialogUniversalInfoActivity.name_folder_profile_name.setText(profile_edit);
                        one_play_editor.putString("PROFILE",profile_edit);
                        one_play_editor.commit();
                        String root = Environment.getExternalStorageDirectory().toString();
                        File myDir = new File(root + "/" + profile_edit);
                        if (!myDir.exists()) {
                            myDir.mkdirs();
                        }
                        DialogUniversalInfoUtils.this.mDialog.dismiss();
                    }
                }else if (novsave == 4){
                    story_image_edit = edit_text_image.getText().toString();
                    if (story_image_edit.equals(video)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not photos Stories with video you a file saved", Toast.LENGTH_LONG).show();
                    } else if (story_image_edit.equals(profile)) {
                        Toast.makeText(mDialogUniversalInfoActivity,"Not photos Stories with profile you a file saved", Toast.LENGTH_LONG).show();
                    } else if (story_image_edit.equals(image)) {
                        Toast.makeText(mDialogUniversalInfoActivity, "Not photos Stories with photos you a file saved", Toast.LENGTH_LONG).show();
                    } else if (story_image_edit.equals(story_video)) {
                        Toast.makeText(mDialogUniversalInfoActivity,"Not photos Stories with videos Stories you a file saved", Toast.LENGTH_LONG).show();
                    } else {
                        mDialogUniversalInfoActivity.name_folder_story_image_name.setText(story_image_edit);
                        one_play_editor.putString("STORY_IMAGE",story_image_edit);
                        one_play_editor.commit();
                        String root = Environment.getExternalStorageDirectory().toString();
                        File myDir = new File(root + "/" + story_image_edit);
                        if (!myDir.exists()) {
                            myDir.mkdirs();
                        }
                        DialogUniversalInfoUtils.this.mDialog.dismiss();
                    }
                }else if (novsave == 5){
                    story_video_edit = edit_text_image.getText().toString();
                    if (story_video_edit.equals(video)) {
                        Toast.makeText(mDialogUniversalInfoActivity,"Not video Stories with video you a file saved", Toast.LENGTH_LONG).show();
                    } else if (story_video_edit.equals(profile)) {
                        Toast.makeText(mDialogUniversalInfoActivity,"Not video Stories with profile you a file saved", Toast.LENGTH_LONG).show();
                    } else if (story_video_edit.equals(story_image)) {
                        Toast.makeText(mDialogUniversalInfoActivity,"Not video Stories with photos Stories you a file saved", Toast.LENGTH_LONG).show();
                    } else if (story_video_edit.equals(image)) {
                        Toast.makeText(mDialogUniversalInfoActivity,"Not video Stories with photos you a file saved", Toast.LENGTH_LONG).show();
                    } else {
                        mDialogUniversalInfoActivity.name_folder_story_video_name.setText(story_video_edit);
                        one_play_editor.putString("STORY_VIDEO",story_video_edit);
                        one_play_editor.commit();
                        String root = Environment.getExternalStorageDirectory().toString();
                        File myDir = new File(root + "/" + story_video_edit);
                        if (!myDir.exists()) {
                            myDir.mkdirs();
                        }
                        DialogUniversalInfoUtils.this.mDialog.dismiss();
                    }
                }


                FirebaseCrash.log("log 2");
            }
        });
        mDialogCancelButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUniversalInfoUtils.this.mDialog.dismiss();
            }
        });
    }


    public void dismissDialog() {
        this.mDialog.dismiss();
    }

    public void showDialog() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mDialogUniversalInfoActivity, R.style.CustomDialogTheme);
        }
        this.mDialog.setContentView(R.layout.dialog_universal_info);
        this.mDialog.setCancelable(true);
        this.mDialog.show();
        this.mDialogOKButton = (TextView) this.mDialog.findViewById(R.id.dialog_universal_info_ok);
        this.mDialogCancelButton = (TextView) this.mDialog.findViewById(R.id.dialog_universal_info_cancel);
        this.dialog_universal_info_text = (TextView) this.mDialog.findViewById(R.id.dialog_universal_info_text);
        this.format_name = (TextView) this.mDialog.findViewById(R.id.format_name);
        this.edit_text_image = (EditText) this.mDialog.findViewById(R.id.edit_text_image);
        edit_text_image.setText(namefolder);
        format_name.setText( "Attention of " + " *<>|\" " +  " As the name do not use download difficult to be");

        if (novsave == 1){
            dialog_universal_info_text.setText("Change storage pictures");
        }else if (novsave == 2){
            dialog_universal_info_text.setText("Change storage videos");
        }else if (novsave == 3){
            dialog_universal_info_text.setText("Change storage profile");
        }else if (novsave == 4){
            dialog_universal_info_text.setText("Change storage pictures Stories");
        }else if (novsave == 5){
            dialog_universal_info_text.setText("Change storage videos Stories");
        }

        initDialogButtons();


        FirebaseCrash.log("log 1");
    }
}
