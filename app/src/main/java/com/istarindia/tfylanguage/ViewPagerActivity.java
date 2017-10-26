package com.istarindia.tfylanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.istarindia.tfylanguage.pojo.AnswerPojo;
import com.istarindia.tfylanguage.pojo.AssessmentPojo;
import com.istarindia.tfylanguage.pojo.OptionPojo;
import com.istarindia.tfylanguage.pojo.QuestionPojo;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {
    private LockableViewPager lockableViewPager;
    private ArrayList<AssessmentPojo> assessmentPojos;
    private ViewPagerAdapter viewPagerAdapter;
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

    }




    public void next(){
        if(lockableViewPager.getCurrentItem() != assessmentPojos.size()+1){
            lockableViewPager.setCurrentItem(lockableViewPager.getCurrentItem()+1);
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
        options.add("salman");
        optionPojo.setOptions(options);

        AssessmentPojo assessmentPojo = new AssessmentPojo(answerPojo,optionPojo,questionPojo);

        assessmentPojos.add(assessmentPojo);



    }
}
