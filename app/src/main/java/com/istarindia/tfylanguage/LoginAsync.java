package com.istarindia.tfylanguage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.istarindia.tfylanguage.complexobject.StudentProfile;
import com.istarindia.tfylanguage.util.HttpUtil;

import java.util.HashMap;

/**
 * Created by akshay on 10/30/17.
 */


public class LoginAsync extends AsyncTask<String, Integer, String> {
    private HashMap<String, String> param;
    private Context context;
    private SharedPreferences sharedpreferences;

    //private final Gson gson = new Gson();

    public LoginAsync(HashMap<String, String> param, Context context, SharedPreferences sharedpreferences

    ) {
        this.param = param;
        this.context = context;
        this.sharedpreferences = sharedpreferences;

    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        return postData(param, params[0]);
    }


    @Override
    protected void onPostExecute(String jsonresponse) {

        if (!jsonresponse.equalsIgnoreCase("null") && !jsonresponse.equalsIgnoreCase("[]") && !jsonresponse.equalsIgnoreCase("") && !jsonresponse.contains("istarViksitProComplexKey")) {
            //dialog.show();
            Intent i = null;

            try {
                ((LoginActivity) context).tv_error_password.setVisibility(View.GONE);
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

                StudentProfile studentProfile = gson.fromJson(jsonresponse, StudentProfile.class);
                /*
                if (studentProfile.getIsVerified() != null && studentProfile.getIsVerified()) {
                    i = new Intent(context, SplashScreenActivity.class);

                } else {
                    i = new Intent(context, VerifyPhoneActivity.class);
                    if (studentProfile != null && studentProfile.getMobile() != null) {
                        i.putExtra("mobileNumber", studentProfile.getMobile() + "");
                    }

                }
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                if (context instanceof LoginActivity)
                    ((LoginActivity) context).gifImageView.stopAnimation();
                else
                    ((SignupActivity) context).gifImageView.stopAnimation();

                context.startActivity(i);
                ((Activity)context).finish();
                */

                if (context instanceof LoginActivity)
                    ((LoginActivity) context).gifImageView.stopAnimation();

                i = new Intent(context, SplashScreenActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
                ((Activity)context).finish();

            } catch (Exception e) {
                setErrorMessage("Oops! something went wrong.");
            }
        } else if (!jsonresponse.equalsIgnoreCase("null") && jsonresponse.contains("istarViksitProComplexKey")) {
            setErrorMessage(jsonresponse.replaceAll("istarViksitProComplexKey", "").replaceAll("\"", ""));
        } else {
            setErrorMessage("Please check your internet connection.");
        }

    }


    private void setErrorMessage(String message) {
        if (context instanceof LoginActivity) {
            ((LoginActivity) context).ll_input_con.setVisibility(View.VISIBLE);
            if (!message.equalsIgnoreCase("")) {
                ((LoginActivity) context).tv_error_password.setText(message);
                ((LoginActivity) context).tv_error_password.setVisibility(View.VISIBLE);
            }
            ((LoginActivity) context).gifImageView.stopAnimation();
            ((LoginActivity) context).progresslayout.setVisibility(View.GONE);
            ((LoginActivity) context).login_submit.setEnabled(true);
        }
/*
        else {
            ((SignupActivity) context).ll_input_con.setVisibility(View.VISIBLE);
            if (!message.equalsIgnoreCase("")) {
                ((SignupActivity) context).tv_error_password.setText(message);
                ((SignupActivity) context).tv_error_password.setVisibility(View.VISIBLE);
            }
            ((SignupActivity) context).gifImageView.stopAnimation();
            ((SignupActivity) context).progresslayout.setVisibility(View.GONE);

        }*/
    }


    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);

        if (context instanceof LoginActivity) {

            ((LoginActivity) context).ll_input_con.setVisibility(View.GONE);
            ((LoginActivity) context).progresslayout.setVisibility(View.VISIBLE);
            ((LoginActivity) context).gifImageView.startAnimation();

            ((LoginActivity) context).tv_error_password.setVisibility(View.GONE);
        }
/*
        else {
            ((SignupActivity) context).ll_input_con.setVisibility(View.GONE);
            ((SignupActivity) context).progresslayout.setVisibility(View.VISIBLE);
            ((SignupActivity) context).gifImageView.startAnimation();

            ((SignupActivity) context).tv_error_password.setVisibility(View.GONE);
        }*/

    }


    private String postData(HashMap<String, String> param, String url) {
        publishProgress(5);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        HttpUtil httpUtil = new HttpUtil(context.getResources().getString(R.string.serverip) + url, "POST", param, null);
        String jsonresponse = httpUtil.getStringResponse();
        System.out.println("jjj " + jsonresponse);
        if (!jsonresponse.equalsIgnoreCase("null") && !jsonresponse.equalsIgnoreCase("[]") && !jsonresponse.equalsIgnoreCase("") && !jsonresponse.contains("istarViksitProComplexKey")) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(context.getResources().getString(R.string.user_profile), jsonresponse);
            editor.apply();
            editor.commit();
        }

        return jsonresponse;
    }
}