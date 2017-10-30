package com.istarindia.tfylanguage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.felipecsl.gifimageview.library.GifImageView;
import com.istarindia.tfylanguage.util.FontUtil;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class ForgotActivity extends AppCompatActivity implements View.OnClickListener {
    private FontUtil fontUtil;
    private TextView forgot_title, forgot_info, error_text;
    private AppCompatEditText phone_nos;
    private Button btn_forgot_submit, btn_sign_in_different;
    public RelativeLayout progresslayout;
    public LinearLayout main_layout;
    public GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        fontUtil = new FontUtil(this);
        forgot_title = (TextView) findViewById(R.id.forgot_title);
        forgot_info = (TextView) findViewById(R.id.forgot_info);
        error_text = (TextView) findViewById(R.id.error_text);
        phone_nos = (AppCompatEditText) findViewById(R.id.phonenos);
        btn_forgot_submit = (Button) findViewById(R.id.btn_forgot_submit);
        btn_sign_in_different = (Button) findViewById(R.id.btn_sign_in_different);
        progresslayout = (RelativeLayout) findViewById(R.id.progresslayout);
        main_layout = (LinearLayout) findViewById(R.id.main_layout);

        /*
        //setting fonts
        forgot_title.setTypeface(fontUtil.getTypeface("LatoBold"));
        forgot_info.setTypeface(fontUtil.getTypeface("LatoRegular"));
        error_text.setTypeface(fontUtil.getTypeface("LatoRegular"));
        phone_nos.setTypeface(fontUtil.getTypeface("LatoRegular"));
        btn_forgot_submit.setTypeface(fontUtil.getTypeface("LatoBold"));
        btn_sign_in_different.setTypeface(fontUtil.getTypeface("LatoRegular"));
        */

        gifImageView = (GifImageView) findViewById(R.id.gifImageView);
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open(getResources().getString(R.string.progressgif));
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //setting listner
        phone_nos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                error_text.setVisibility(View.GONE);
            }
        });


        phone_nos.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                error_text.setVisibility(View.GONE);
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // TODO Auto-generated method stub
            }
        });
        phone_nos.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getBaseContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(phone_nos.getWindowToken(), 0);
                    btn_forgot_submit.performClick();
                    return true;
                }
                return false;
            }
        });
        btn_sign_in_different.setOnClickListener(this);
        btn_forgot_submit.setOnClickListener(this);


        //coming from login

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_forgot_submit:
                validate();
                break;
            case R.id.btn_sign_in_different:
                startActivity(new Intent(ForgotActivity.this, LoginActivity.class));
                break;
        }

    }

    private void validate() {

        if (phone_nos.getText() != null && !phone_nos.getText().toString().equalsIgnoreCase("") && phone_nos.getText().toString().length() == 10) {
            //new ForgotAsync(this, phone_nos.getText().toString()).execute();
        } else {
            if (phone_nos.getText() != null && !phone_nos.getText().toString().equalsIgnoreCase("")) {
                error_text.setText("Phone nos is too short");
                error_text.setVisibility(View.VISIBLE);
            } else {
                error_text.setText("Phone nos is required");
                error_text.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //new GoogleAnalyticsUtil(this).sendAnalyticMessage("SIGN_UP");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ForgotActivity.this, LoginActivity.class));
    }

}

