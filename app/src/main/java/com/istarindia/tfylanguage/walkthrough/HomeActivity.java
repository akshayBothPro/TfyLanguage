package com.istarindia.tfylanguage.walkthrough;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.github.paolorotolo.appintro.AppIntro;
import com.istarindia.tfylanguage.LoginActivity;
import com.istarindia.tfylanguage.R;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;
import me.toptas.fancyshowcase.FocusShape;
import me.toptas.fancyshowcase.OnViewInflateListener;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_talentify;
    private Button btn_get_started, btn_member;

    FancyShowCaseView fancyShowCaseView1;
    FancyShowCaseView fancyShowCaseView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv_talentify = (TextView) findViewById(R.id.tv_talentify);
        btn_get_started = (Button) findViewById(R.id.btn_get_started);
        btn_member = (Button) findViewById(R.id.btn_member);

        btn_get_started.setOnClickListener(this);
        btn_member.setOnClickListener(this);

        setShowCase();





    }

    //
    private void setShowCase() {
        //falseAnim is used to disable animation here
        Animation falseAnim = AnimationUtils.loadAnimation(this, R.anim.false_anim);

        fancyShowCaseView1 = new FancyShowCaseView.Builder(this)
                .focusOn(btn_get_started)
                .focusShape(FocusShape.ROUNDED_RECTANGLE)
                .roundRectRadius(btn_get_started.getHeight()/2)
                .enterAnimation(falseAnim)
                .exitAnimation(falseAnim)
                .customView(R.layout.custom_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(@NonNull View view) {
                        TextView xtv = view.findViewById(R.id.descriptionTop);
                        xtv.setText("If you are a newbie then Get started from here");
                        xtv.setVisibility(View.VISIBLE);
                        Button next = view.findViewById(R.id.closeButton);
                        next.setText("NEXT");
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fancyShowCaseView1.removeView();
                            }
                        });
                    }
                })
                .closeOnTouch(false)
                .backgroundColor(Color.parseColor("#CC333639"))
                .build();

        fancyShowCaseView2 = new FancyShowCaseView.Builder(this)
                .title("Already playing then start from here")
                .focusOn(btn_member)
                .enterAnimation(falseAnim)
                .exitAnimation(falseAnim)
                .focusShape(FocusShape.ROUNDED_RECTANGLE)
                .roundRectRadius(btn_member.getHeight()/2)
                .customView(R.layout.custom_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(@NonNull View view) {
                        TextView xtv = view.findViewById(R.id.descriptionTop);
                        xtv.setVisibility(View.VISIBLE);
                        xtv.setText("Already playing then start from here");
                        Button close = view.findViewById(R.id.closeButton);
                        close.setText("CLOSE");
                        close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fancyShowCaseView2.removeView();
                            }
                        });
                    }
                })
                .closeOnTouch(false)
                .backgroundColor(Color.parseColor("#CC333639"))
                .build();

        new FancyShowCaseQueue()
                .add(fancyShowCaseView1)
                .add(fancyShowCaseView2)
                .show();

    }


    private void showWithAnim(View v) {
        Animation enter = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation exit = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);

        final FancyShowCaseView fancy = new FancyShowCaseView.Builder(this)
                                    .focusOn(v)
                                    .title("Already member start from here")
                                    .enterAnimation(enter)
                                    .exitAnimation(exit)
                                    .build();
        fancy.show();
        exit.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fancy.removeView();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_get_started:
                //startActivity(new Intent(HomeActivity.this, SignupActivity.class));
                //finish();
                break;
            case R.id.btn_member:
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
