# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\Fury\AppData\Local\Android\android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:

#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keep class com.github.bumptech.glide.** { *; }


-dontwarn okio.**

-keep class com.android.vending.billing.**

-keep public class com.adapters.ImageModel
-keep public class com.android.fury.instafull.ForegroundService
-keep public class com.android.fury.instafull.Constants
-keep public class com.instagram.data.DownloadFileFromService
-keep public class com.android.fury.instafull.MyDatabaseHelper_url
-keep public class com.android.fury.instafull.StoryDownloader
-keep public class com.android.fury.instafull.Ulits.Utils

-keep class com.downloadme.**

-keep class android.support.v7.** { *; }


-keep class android.support.design.** { *; }
