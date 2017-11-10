package com.istarindia.tfylanguage;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.eftimoff.viewpagertransformers.DepthPageTransformer;
import com.istarindia.tfylanguage.pojo.AnswerPojo;
import com.istarindia.tfylanguage.pojo.AssessmentPojo;
import com.istarindia.tfylanguage.pojo.AssessmentType;
import com.istarindia.tfylanguage.pojo.OptionPojo;
import com.istarindia.tfylanguage.pojo.QuestionPojo;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {
    private LockableViewPager lockableViewPager;
    private ArrayList<AssessmentPojo> assessmentPojos;
    private ViewPagerAdapter viewPagerAdapter;
    private MaterialDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        lockableViewPager = (LockableViewPager) findViewById(R.id.viewpager);

        assessmentPojos = new ArrayList<>();
        setUpData(assessmentPojos);
        viewPagerAdapter = new ViewPagerAdapter(this,getSupportFragmentManager(),assessmentPojos);
        lockableViewPager.setAdapter(viewPagerAdapter);
        lockableViewPager.setSwipeLocked(true);
        lockableViewPager.setPageTransformer(true, new DepthPageTransformer());

    }

    public void next(AssessmentPojo assessmentPojo, ArrayList<String> selectedOptions){

        if(dialog != null){
            dialog = null;
            if(lockableViewPager.getCurrentItem() != assessmentPojos.size()+1){
                lockableViewPager.setCurrentItem(lockableViewPager.getCurrentItem()+1);
            }
        }else{
            boolean flag = false;
            ArrayList<String> answers =  assessmentPojo.getAnswerPojo().getAnswers();
           if (selectedOptions.size() ==answers.size()){

               for(String selectedoption: selectedOptions){
                   if(answers.contains(selectedoption)){
                       flag = true;
                   }else{
                       flag = false;
                   }
               }
           }

           if(flag){
               dialog = new MaterialDialog.Builder(this)
                       .customView(R.layout.right_answer_layout, false)
                       .build();
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

               dialog.show();
           }else{
               dialog = new MaterialDialog.Builder(this)
                       .customView(R.layout.wrong_answer_layout, false)
                       .build();
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

               TextView right_answer = (TextView) dialog.getCustomView().findViewById(R.id.right_answer);
               StringBuilder builder = new StringBuilder();
               for(String s : answers) {
                   builder.append(s+" ");
               }
               right_answer.setText(builder.toString());

               dialog.show();
           }

        }

    }

    private void setUpData(ArrayList<AssessmentPojo> assessmentPojos) {
        QuestionPojo questionPojo = new QuestionPojo();
        AnswerPojo answerPojo = new AnswerPojo();
        OptionPojo optionPojo = new OptionPojo();

        ArrayList<String> answers = new ArrayList<>();
        answers.add("shah");
        answers.add("rukh");
        answers.add("khan");
        answerPojo.setAnswers(answers);

        questionPojo.setText("Which bollywood celebrity is known as SRK");

        ArrayList<String> options = new ArrayList<>();
        options.add("shah");
        options.add("rukh");
        options.add("khan");
        options.add("aamir");

        optionPojo.setOptions(options);

        AssessmentPojo assessmentPojo = new AssessmentPojo(answerPojo,optionPojo,questionPojo, AssessmentType.DRAGNDROP);
        AssessmentPojo assessmentPojo1 = new AssessmentPojo(answerPojo,optionPojo,questionPojo,AssessmentType.LISTENNWRITE);
        AssessmentPojo assessmentPojo2 = new AssessmentPojo(answerPojo,optionPojo,questionPojo,AssessmentType.FOUROPTION);
        assessmentPojos.add(assessmentPojo2);

        assessmentPojos.add(assessmentPojo);
        assessmentPojos.add(assessmentPojo1);

    }
}
