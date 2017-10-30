package com.istarindia.tfylanguage;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.istarindia.tfylanguage.complexobject.StudentProfile;

import java.util.concurrent.Callable;

/**
 * Created by akshay on 10/30/17.
 */


public class UserProfileThread implements Callable<String> {
    private StudentProfile studentProfile;
    private SharedPreferences.Editor editor;
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public UserProfileThread(StudentProfile studentProfile, SharedPreferences.Editor editor) {
        this.studentProfile = studentProfile;
        this.editor = editor;
    }

    @Override
    public String call() throws Exception {
        editor.putString("USERPROFILE", gson.toJson(studentProfile));
        editor.commit();
        editor.apply();
        return null;
    }
}
