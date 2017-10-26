package com.istarindia.tfylanguage;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

public class FlexActivity extends AppCompatActivity {
    FlexboxLayout topflexlayout,bottomflex;
    Button shuttle;
    final ViewGroup.LayoutParams vv = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);

    int position =0;
    int lastposition =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex);
        topflexlayout = (FlexboxLayout) findViewById(R.id.topflexlayout);
        bottomflex = (FlexboxLayout) findViewById(R.id.bottomflex);
        shuttle = (Button) findViewById(R.id.shuttle);
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
            public void onClick(View v) {
               if(button.getText() != null && !button.getText().toString().equalsIgnoreCase("")) {
               int tag_position = (int) v.getTag();
                Point p = getLocationOnScreen(v);
                if(topflexlayout.getChildAt(lastposition) != null){
                    Button b = (Button) topflexlayout.getChildAt(lastposition);
                    float x = b.getX()+b.getWidth();
                    float y = b.getY() + b.getHeight();
                    StartYourAnimation(p.x,x,p.y,y,((Button)v).getText().toString(),tag_position);

                }else{
                    StartYourAnimation(p.x,0,p.y,0,((Button)v).getText().toString(),tag_position);
                }
                   ((Button)v).setText("");

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
                Point p = getLocationOnScreen(v);
                Button b = (Button) bottomflex.getChildAt(tag_position);
                Point pp = getLocationOnScreen(b);
                pp.y = pp.y -b.getHeight();
                topAnimation(p.x,pp.x,p.y,pp.y,b,v,((Button)v).getText().toString());


            }
        });


    }

    public void StartYourAnimation(int fromX, float toX, int fromY, float toY, final String text,final int tag){
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
                Button button = new Button(FlexActivity.this);
                button.setText(text);
                button.setLayoutParams(vv);
                button.setTag(tag);
                setTopClick(button);
                topflexlayout.addView(button);
                shuttle.setVisibility(View.GONE);
                lastposition = position;
                position++;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        shuttle.startAnimation(animation);

    }



    public void topAnimation(int fromX, float toX, int fromY, float toY,  final Button button,final View v,final String text){
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
