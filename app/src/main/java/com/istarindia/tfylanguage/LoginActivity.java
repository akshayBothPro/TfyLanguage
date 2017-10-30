package com.istarindia.tfylanguage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, EditText.OnEditorActionListener{

    public AppCompatEditText email, password;
    public Button forgot_password, login_submit, btn_register_instead;
    public ImageButton iv_show_password;
    public TextView tv_error_password;

    private SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (AppCompatEditText) findViewById(R.id.apet_login_email);
        password = (AppCompatEditText) findViewById(R.id.apet_password);
        login_submit = (Button) findViewById(R.id.btn_login);
        forgot_password = (Button) findViewById(R.id.btn_forgot_password);
        iv_show_password = (ImageButton) findViewById(R.id.iv_show_password);
        tv_error_password = (TextView) findViewById(R.id.tv_error_password);
        btn_register_instead = (Button) findViewById(R.id.btn_register_instead);

        sharedpreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_key), Context.MODE_PRIVATE);

        login_submit.setOnClickListener(this);
        iv_show_password.setOnClickListener(this);
        forgot_password.setOnClickListener(this);
        btn_register_instead.setOnClickListener(this);

    }

    private boolean validate() {
        boolean valid = true;
        String emailid = email.getText().toString();
        String pasword = password.getText().toString();

        if (pasword.isEmpty() || pasword.length() < 4 || emailid.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            String error_message = "";
            if (emailid.isEmpty()) {
                error_message = "Email id is required";

                tv_error_password.setText(error_message);
                tv_error_password.setVisibility(View.VISIBLE);
                return false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
                error_message = "Please enter a valid email Id ";
                tv_error_password.setText(error_message);
                tv_error_password.setVisibility(View.VISIBLE);
                return false;
            }
            if (pasword.isEmpty()) {
                error_message = "Password is required";
                tv_error_password.setText(error_message);
                tv_error_password.setVisibility(View.VISIBLE);
                return false;
            } else if (password.length() < 4) {
                error_message = error_message + "Password is too short";
                tv_error_password.setText(error_message);
                tv_error_password.setVisibility(View.VISIBLE);
                return false;
            }
            tv_error_password.setText(error_message);
            tv_error_password.setVisibility(View.VISIBLE);
            valid = false;
        } else {
            tv_error_password.setVisibility(View.GONE);
        }
        return valid;
    }

    @Override
    public void onClick(View view) {
        System.out.println(view.getId());

        switch (view.getId()) {
            /*
            case R.id.fb:
                fbBtn.setReadPermissions("user_friends", "public_profile", "email", "user_birthday", "user_location");
                fbBtn.registerCallback(callbackManager, new FacebookUtil().getFaceBookCallBack(LoginActivity.this, dialog, sharedpreferences));
                fbBtn.performClick();
                break;
            case R.id.btn_signup_linkedIn:
                new LinkedInUtil().fetchData(this, this, dialog, sharedpreferences);
                break;
            case R.id.btn_signup_google:
                googleUtil.signIn(mGoogleApiClient, RC_SIGN_IN, this);
                break;
                */
            case R.id.btn_login:
                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {

                }
                if (!validate()) {
                    return;
                }

                onLoginSuccess();
                break;
            case R.id.iv_show_password:
                if (password.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                    iv_show_password.setColorFilter(ContextCompat.getColor(this, R.color.theme_color));
                    password.setSelection(password.getText().length());
                    //password.setTypeface(fontUtil.getTypeface("LatoRegular"));

                } else {
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    iv_show_password.setColorFilter(ContextCompat.getColor(this, R.color.input_border));
                    password.setSelection(password.getText().length());
                    //password.setTypeface(fontUtil.getTypeface("LatoRegular"));

                }
                break;
            /*
            case R.id.ok:
                dialog.dismiss();
                break;*/
            case R.id.btn_forgot_password:
                //startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
                break;
            case R.id.btn_register_instead:
                //startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                break;
        }


    }

    private void onLoginSuccess() {

        login_submit.setEnabled(false);
        String emailid = email.getText().toString();
        String pasword = password.getText().toString();
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(getResources().getString(R.string.email), emailid);
        params.put(getResources().getString(R.string.password), pasword);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("email", emailid);
        editor.putString("password", pasword);
        editor.commit();
        editor.apply();


        new LoginAsync(params, this, sharedpreferences).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, getResources().getString(R.string.loginurl));

    }


    @Override
    public void onBackPressed() {
        //startActivity(new Intent(LoginActivity.this, HomeActvity.class));

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.remove(ComplexObjectXMl);
                            editor.commit();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        dialog.dismiss();
                        startActivity(intent);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();*/
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {

            if (v.getId() == email.getId()) {
                password.requestFocus();
            } else {
                InputMethodManager imm = (InputMethodManager) getBaseContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                login_submit.performClick();
            }
            return true;
        }
        return false;
    }
}
