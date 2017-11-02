package com.istarindia.tfylanguage;

/**
 * Created by akshay on 10/26/17.
 */


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.istarindia.tfylanguage.pojo.Lesson;

import org.w3c.dom.Text;


public class CardFragment extends Fragment implements View.OnClickListener {

    private CardView mCardView;
    public ImageView completedIcon;
    public TextView cardTitle, cardDescription;
    public Button start;
    private Lesson lesson;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adapter, container, false);
        mCardView = (CardView) view.findViewById(R.id.cardView);
        completedIcon = (ImageView) view.findViewById(R.id.iv_completed_icon);
        cardTitle = (TextView) view.findViewById(R.id.tv_card_title);
        cardDescription = (TextView) view.findViewById(R.id.tv_card_description);
        start = (Button) view.findViewById(R.id.btn_start);

        lesson = (Lesson) getArguments().getSerializable("lesson");
        cardTitle.setText( "" + lesson.getId());
        cardDescription.setText("" + lesson.getDescription());
        if (lesson.getCompleted()) {
            completedIcon.setVisibility(View.VISIBLE);
        } else {
            completedIcon.setVisibility(View.INVISIBLE);
        }

        mCardView.setMaxCardElevation(mCardView.getCardElevation()
                * CardAdapter.MAX_ELEVATION_FACTOR);
        start.setOnClickListener(this);

        return view;
    }

    public CardView getCardView() {
        return mCardView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                //do something // goto view pager activity
                startActivity(new Intent(getContext(),ViewPagerActivity.class));
                System.out.println(view.getId());
                break;
        }
    }
}
