package com.istarindia.tfylanguage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.istarindia.tfylanguage.fragments.DragAndDrop;
import com.istarindia.tfylanguage.fragments.EndAssessmentFragment;
import com.istarindia.tfylanguage.fragments.ListenAndWrite;
import com.istarindia.tfylanguage.pojo.AssessmentPojo;
import com.istarindia.tfylanguage.pojo.AssessmentType;

import java.util.ArrayList;

/**
 * Created by istarferoz on 27/10/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private ArrayList<AssessmentPojo> assessmentPojos;
    public ViewPagerAdapter(Context context,android.support.v4.app.FragmentManager fm,ArrayList<AssessmentPojo> assessmentPojos) {
        super(fm);
        this.mContext = context;
        this.assessmentPojos = assessmentPojos;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position != assessmentPojos.size()) {

            switch (assessmentPojos.get(position).getType()) {
                case AssessmentType.DRAGNDROP:
                    fragment = new DragAndDrop();
                    break;
                case AssessmentType.LISTENNWRITE:
                    fragment = new ListenAndWrite();
                    break;
            }
            final Bundle bundle = new Bundle();
            bundle.putSerializable(DragAndDrop.GET_OBJECT, assessmentPojos.get(position));
            fragment.setArguments(bundle);
        }else{
            fragment = new EndAssessmentFragment();
        }



        return fragment;
    }



    @Override
    public int getCount() {
        return assessmentPojos.size();
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


    @Override
    public void destroyItem(View collection, int position, Object o) {
        View view = (View) o;
        ((ViewPager) collection).removeView(view);
        view = null;
    }



}