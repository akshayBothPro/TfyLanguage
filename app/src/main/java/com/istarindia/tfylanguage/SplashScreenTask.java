package com.istarindia.tfylanguage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.istarindia.tfylanguage.complexobject.ComplexObject;
import com.istarindia.tfylanguage.util.HttpUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by akshay on 10/30/17.
 */


public class SplashScreenTask extends AsyncTask<Void, Void, String> {
    private SplashScreenTaskCallback listener = null;
    private Context context;
    private SharedPreferences.Editor editor;
    private int user_id;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SharedPreferences sharedpreferences;

    public SplashScreenTask(Context context, SharedPreferences.Editor editor, int user_id, SharedPreferences sharedpreferences) {
        this.context = context;
        this.editor = editor;
        this.user_id = user_id;
        this.sharedpreferences = sharedpreferences;
    }

    @Override
    protected String doInBackground(Void... params) {
        String response = "";
        long start = System.currentTimeMillis();
        System.out.println("COMPLEX OBJECT STARTED");

        try {

            HttpUtil httpUtil = new HttpUtil();

            httpUtil.setUrl(context.getResources().getString(R.string.serverip) + (context.getResources().getString(R.string.complexobject).replaceAll("user_id", user_id + "")));
            httpUtil.setType("GET");

            response = httpUtil.getStringResponse();


            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            System.out.println("COMPLEX OBJECT Parse STARTED");
            ComplexObject complexObject = gson.fromJson(response, ComplexObject.class);
            System.out.println("COMPLEX OBJECT PARSE  STOPPED");
            //List<Callable<String>> tasks = new ArrayList<>();

            editor.putString("COMPLEX_OBJECT_RESPONSE", response);
            //editor.putString("DOWNLOAD_RESOURCES", "true");
            editor.commit();
            editor.apply();


            /*
            if (complexObject != null && complexObject.getTasks() != null && complexObject.getTasks().size() != 0) {
                System.out.println("taskSummaryPOJOs   " + complexObject.getTasks().size());
                TaskSummaryThread taskSummaryThread = new TaskSummaryThread(context, complexObject.getStudentProfile().getId(), complexObject.getTasks(), editor, false);
                tasks.add(taskSummaryThread);
            }
            */

            /*
            if (complexObject != null && complexObject.getStudentProfile() != null) {
                UserProfileThread userProfileThread = new UserProfileThread(complexObject.getStudentProfile(), editor);
                tasks.add(userProfileThread);

                editor.putString("complex_object", sdf.format(new Date()));
                editor.commit();
                editor.apply();
                ExecutorService executor = Executors.newFixedThreadPool(tasks.size());
                try {
                    List<Future<String>> aaa = executor.invokeAll(tasks);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                executor.shutdown();
                if (executor.isShutdown()) {
                }
                System.out.println("COMPLEX OBJECT END-------------------------------------------------------------------------" + (System.currentTimeMillis() - start) / 1000 + " secs");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public void onPreExecute() {
    }

    @Override
    public void onPostExecute(String v) {
        /*
        if (v != null && !v.equalsIgnoreCase("") && listener != null) {
            listener.OnSplashScreenTaskCompleted();
        } else {*/
            //sharedpreferences.edit().clear().apply();
            Intent i = new Intent(new Intent(context, GridViewActivity.class));
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        //}
    }

    public void setListener(SplashScreenTaskCallback listener) {
        this.listener = listener;
    }

    public interface SplashScreenTaskCallback {
        void OnSplashScreenTaskCompleted();
    }
}
