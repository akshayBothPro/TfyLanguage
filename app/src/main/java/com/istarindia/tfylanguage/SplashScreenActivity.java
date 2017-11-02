package com.istarindia.tfylanguage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.istarindia.tfylanguage.complexobject.StudentProfile;

import static android.Manifest.permission.RECEIVE_BOOT_COMPLETED;

public class SplashScreenActivity extends AppCompatActivity /* implements SplashScreenTask.SplashScreenTaskCallback*/{

    private int user_id;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private StudentProfile studentProfile;

    private TextView appname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        appname = (TextView) findViewById(R.id.appname);
        sharedpreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_key), Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        String profile_date = sharedpreferences.getString(getResources().getString(R.string.user_profile), "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        studentProfile = gson.fromJson(profile_date, StudentProfile.class);
        if (studentProfile != null && studentProfile.getId() != null)
            user_id = studentProfile.getId();


        SplashScreenTask splashScreenTask = new SplashScreenTask(this, editor, user_id, sharedpreferences);
        splashScreenTask.execute();
        /*
        registerReceiver(new ServiceRestarterBroadcastReceiver(),
                new IntentFilter(RECEIVE_BOOT_COMPLETED));
        registerReceiver(new ServiceRestarterBroadcastReceiver(),
                new IntentFilter("VIKSIT_RESTART_SERVICE"));
        registerReceiver(new ServiceRestarterBroadcastReceiver(),
                new IntentFilter("QUICKBOOT_POWERON"));
                */

        }

    @Override
    public void onBackPressed() {
    }

    /*
    @Override
    public void OnSplashScreenTaskCompleted() {
        startActivity(new Intent(SplashScreenActivity.this, GridViewActivity.class));
        finish();
    }
    */
}
