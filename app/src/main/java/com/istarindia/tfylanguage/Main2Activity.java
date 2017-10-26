package com.istarindia.tfylanguage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    RelativeLayout main_layout;
    RelativeLayout rl;
    ArrayList<String> buttonText;
    ArrayList<Button> buttons;
    FlexboxLayout bottomflex,topflex;
    LinearLayout top,bottom;
    Button shuttle;
    int k =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        shuttle = (Button) findViewById(R.id.shuttle);


        shuttle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,FlexActivity.class));
            }
        });
        //main_layout = (RelativeLayout)  findViewById(R.id.main);
        //main_layout.setClipChildren(false);
        //main_layout.setClipToPadding(false);
        //bottomflex = (FlexboxLayout) findViewById(R.id.bottomflex);
        //topflex = (FlexboxLayout) findViewById(R.id.topflex);
        top = (LinearLayout) findViewById(R.id.toplinear);
        bottom = (LinearLayout) findViewById(R.id.bottom);
        bottom.setClipChildren(false);
        bottom.setClipToPadding(false);
        buttonText = new ArrayList<>();
        buttons = new ArrayList<>();

        for(int i=0; i<5; i++) {
            buttonText.add(i + "");
        }
        final ViewGroup.LayoutParams vv = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        for(String key : buttonText){
            Button button  = new Button(this);
            button.setText(key);
            button.setTag(Integer.parseInt(key));
            button.setLayoutParams(vv);
            setBottomButtonClick(button);
            bottom.addView(button);

        }




    }


    public void setBottomButtonClick(final Button button){

        final ViewGroup.LayoutParams vv = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                System.out.println(button.getX() +" clickedd button "+button.getY());

                final Button b = new Button(Main2Activity.this);
                b.setText(((Button)v).getText());
                b.setLayoutParams(vv);
                top.addView(b);
                b.post(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
                    @Override
                    public void run() {
                        float x = b.getX();
                        float y = b.getY();
                        b.setVisibility(View.GONE);

                        System.out.println(x +" xxx "+y);
                        Point p = getLocationOnScreen(v);
                        final Animation animation = new TranslateAnimation(p.x,x,p.y,y);
                        animation.setDuration(500);
                        animation.setFillAfter(true);
                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                shuttle.setText(((Button)v).getText());
                                shuttle.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                b.setVisibility(View.VISIBLE);

                                shuttle.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });

                        shuttle.startAnimation(animation);


                    }
                });

            }
        });



    }


    public static Point getLocationOnScreen(View view){
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Point(location[0], location[1]);
    }
}
