package com.xoksync.x_filemanager.utils;

import static android.os.Build.VERSION.SDK_INT;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;

import com.xoksync.x_filemanager.Preferences;
import com.xoksync.x_filemanager.activity.MainActivity;

public class PermissionRequest {
    public static void full(Activity activity) {
        SharedPreferences preferences = activity.getSharedPreferences("permission_granted", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        if(SDK_INT > 33) {
            ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.READ_MEDIA_AUDIO, Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO}, 100);
        }
        if (SDK_INT >= Build.VERSION_CODES.R && preferences.getBoolean("CAN_ACCESS_FILE", false)) {
            if (Environment.isExternalStorageManager()) {
                activity.startActivity(new Intent(activity, MainActivity.class));
            } else {
                editor.putBoolean(Preferences.CAN_ACCESS_FILES, true);
                editor.apply();

                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                intent.setData(uri);
                activity.startActivity(intent);
            }
        }
    }
}
