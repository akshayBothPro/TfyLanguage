package com.istarindia.tfylanguage.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.istarindia.tfylanguage.R;
import com.istarindia.tfylanguage.ViewPagerActivity;
import com.istarindia.tfylanguage.pojo.AssessmentPojo;
import com.istarindia.tfylanguage.util.FontUtil;

/**
 * Created by istarferoz on 27/10/17.
 */

public class DragAndDrop extends Fragment {
    public static final String GET_OBJECT = "GET_OBJECT";
    private AssessmentPojo assessmentPojo;
    private Button checkButton,shuttle;
    FlexboxLayout topflexlayout,bottomflex;
    final ViewGroup.LayoutParams vv = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
    RelativeLayout main;
    private TextView questionText;
    private FontUtil fontUtil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.item_object, container, false);
        assessmentPojo = (AssessmentPojo) getArguments().getSerializable(GET_OBJECT);
        checkButton = (Button) view.findViewById(R.id.next);
        topflexlayout = (FlexboxLayout) view.findViewById(R.id.topflexlayout);
        bottomflex = (FlexboxLayout) view.findViewById(R.id.bottomflex);
        shuttle = (Button) view.findViewById(R.id.shuttle);
        main = (RelativeLayout) view.findViewById(R.id.main);
        questionText = (TextView) view.findViewById(R.id.questionText);
        fontUtil = new FontUtil(getContext());
        checkButton.setTypeface(fontUtil.getTypeface("LatoRegular"));
        shuttle.setTypeface(fontUtil.getTypeface("LatoRegular"));
        shuttle.setTextSize(18);
        int i =0;
        questionText.setText(assessmentPojo.getQuestionPojo().getText());
        for(String options: assessmentPojo.getOptionPojo().getOptions()){
            Button button = new Button(getContext());
            button.setText(options);
            button.setTag(i);
            button.setLayoutParams(vv);
            button.setTypeface(fontUtil.getTypeface("LatoRegular"));
            button.setTextSize(18);
            setBottomClick(button);
            bottomflex.addView(button);
            i++;
        }


        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewPagerActivity)getActivity()).next();
            }
        });
        return view;
    }

    private void setBottomClick(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if(button.getText() != null && !button.getText().toString().equalsIgnoreCase("")) {
                    final int tag_position = (int) v.getTag();
                    final String optionText = ((Button)v).getText().toString();
                    ((Button) v).setText("");
                    final Button addButton = (Button)  LayoutInflater.from(getContext()).inflate(R.layout.buttons, null, false);
                    addButton.setText(optionText);
                    addButton.setLayoutParams(vv);
                    addButton.setTag(v.getTag());
                    addButton.setTypeface(fontUtil.getTypeface("LatoRegular"));
                    addButton.setTextSize(18);

                    setTopClick(addButton);
                    topflexlayout.addView(addButton);


                    addButton.post(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("c-------------c-------");
                            int[] viewLocation = new int[2];
                            v.getLocationInWindow(viewLocation);
                            int[] rootLocation = new int[2];
                            main.getLocationInWindow(rootLocation);
                            float fx = viewLocation[0] - rootLocation[0];
                            float fy  = viewLocation[1] - rootLocation[1];
                            int[] bLocation = new int[2];
                            addButton.getLocationInWindow(bLocation);
                            float x = bLocation[0] - rootLocation[0];
                            float y  = bLocation[1] - rootLocation[1];
                            shuttle.setText("");

                            BottomToTopAnimation(fx,x,fy,y,optionText,addButton);

                        }
                    });






                }
            }
        });

    }

    private void setTopClick(final Button addButton) {
        addButton.setOnClickListener(new View.OnClickListener() {
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
                shuttle.setText("");

                topToBottomAnimation(x,fx,y,fy,b,v,((Button)v).getText().toString());


            }
        });
    }

    private void topToBottomAnimation(float fx, float x, float fy, float y,final Button b, final View v,final String buttonText) {
        final Animation animation = new TranslateAnimation(fx,x,fy,y);
        animation.setDuration(500);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                topflexlayout.removeView(v);
                shuttle.setText(buttonText);

                shuttle.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                b.setText(buttonText);
                shuttle.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        shuttle.startAnimation(animation);
    }


    private void BottomToTopAnimation(float fromX, float toX, float fromY, float toY, final String text,final Button topButton){
        final Animation animation = new TranslateAnimation(fromX,toX,fromY,toY);
        animation.setDuration(300);
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


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        shuttle.startAnimation(animation);
    }
}
