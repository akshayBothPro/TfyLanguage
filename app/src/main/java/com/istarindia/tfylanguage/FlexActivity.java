package com.istarindia.tfylanguage;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

public class FlexActivity extends AppCompatActivity {
    FlexboxLayout topflexlayout,bottomflex;
    Button shuttle;
    final ViewGroup.LayoutParams vv = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
    RelativeLayout main;
    int position = 0;
    int lastposition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex);
        topflexlayout = (FlexboxLayout) findViewById(R.id.topflexlayout);
        bottomflex = (FlexboxLayout) findViewById(R.id.bottomflex);
        shuttle = (Button) findViewById(R.id.shuttle);
        main = (RelativeLayout) findViewById(R.id.main);
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<10;i++){
            arrayList.add(i+"");
        }
        position =0;
        for(String key:arrayList){
            Button button = new Button(this);
            button.setText(key);
            button.setTag(Integer.parseInt(key));
            button.setLayoutParams(vv);
            SetBottomClick(button);
            bottomflex.addView(button);
        }

    }

    public void SetBottomClick(final Button button){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
               if(button.getText() != null && !button.getText().toString().equalsIgnoreCase("")) {
                   final int tag_position = (int) v.getTag();
                   Point p = getLocationOnScreen(v);
                   Rect myViewRect = new Rect();
                   v.getGlobalVisibleRect(myViewRect);


                   final Button topbutton = (Button)  LayoutInflater.from(FlexActivity.this).inflate(R.layout.buttons, null, false);

                   topbutton.setText(((Button)v).getText());
                   topbutton.setLayoutParams(vv);
                   topbutton.setTag(v.getTag());
                   setTopClick(topbutton);
                   topflexlayout.addView(topbutton);

                    topbutton.post(new Runnable() {
                        @Override
                        public void run() {
                            int[] viewLocation = new int[2];
                            v.getLocationInWindow(viewLocation);
                            int[] rootLocation = new int[2];
                            main.getLocationInWindow(rootLocation);
                            float fx = viewLocation[0] - rootLocation[0];
                            float fy  = viewLocation[1] - rootLocation[1];

                            if(topflexlayout.getChildAt(lastposition) != null){
                                Button b = (Button) topflexlayout.getChildAt(lastposition);
                                int[] bLocation = new int[2];
                                b.getLocationInWindow(bLocation);
                                float x = bLocation[0] - rootLocation[0];
                                float y  = bLocation[1] - rootLocation[1];


                                //float x = b.getX()+b.getWidth();
                                //float y = b.getY() + b.getHeight();
                                StartYourAnimation(fx,x,fy,y,((Button)v).getText().toString(),tag_position,topbutton);

                            }else{
                                StartYourAnimation(fx,0,fy,0,((Button)v).getText().toString(),tag_position,topbutton);
                            }
                            ((Button)v).setText("");

                        }
                    });



               }
            }
        });


    }
    public void setTopClick(final Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag_position = (int) v.getTag();
                System.out.println("top click tag position---> "+tag_position);
                Button b = (Button) bottomflex.getChildAt(tag_position);

                int [] topButton = new int[2];
                v.getLocationInWindow(topButton);
                int[] viewLocation = new int[2];
                b.getLocationInWindow(viewLocation);
                int[] rootLocation = new int[2];
                main.getLocationInWindow(rootLocation);
                float fx = viewLocation[0] - rootLocation[0];
                float fy  = viewLocation[1] - rootLocation[1];
                float x =  topButton[0] - rootLocation[0];
                float y = topButton[1] - rootLocation[1];
                topAnimation(x,fx,y,fy,b,v,((Button)v).getText().toString());


            }
        });


    }

    public void StartYourAnimation(float fromX, float toX, float fromY, float toY, final String text,final int tag,final Button topButton){
        final Animation animation = new TranslateAnimation(fromX,toX,fromY,toY);
        animation.setDuration(500);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                shuttle.setText(text);

                shuttle.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                shuttle.setVisibility(View.GONE);
                topButton.setVisibility(View.VISIBLE);
                position++;
                lastposition = position;

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        shuttle.startAnimation(animation);

    }

    public void topAnimation(float fromX, float toX, float fromY, float toY,  final Button button,final View v,final String text){
        final Animation animation = new TranslateAnimation(fromX,toX,fromY,toY);
        animation.setDuration(500);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                topflexlayout.removeView(v);
                shuttle.setText(text);

                shuttle.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setText(text);
                shuttle.setVisibility(View.GONE);
                lastposition = position-1;
                position--;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        shuttle.startAnimation(animation);
    }

    public static Point getLocationOnScreen(View view){
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Point(location[0], location[1]);
    }
}
