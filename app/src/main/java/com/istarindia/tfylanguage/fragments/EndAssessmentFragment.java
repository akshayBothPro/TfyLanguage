package com.istarindia.tfylanguage.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.istarindia.tfylanguage.R;
import com.istarindia.tfylanguage.util.FontUtil;

/**
 * Created by istarferoz on 28/10/17.
 */

public class EndAssessmentFragment  extends Fragment {

    private TextView description,time,unanswered,time_remaining,unanswered_info,info;
    private Button submit;
    private FontUtil fontUtil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_end_assessment, container, false);
        fontUtil = new FontUtil(getContext());
        description = (TextView) view.findViewById(R.id.description);
        time = (TextView) view.findViewById(R.id.time);
        unanswered = (TextView) view.findViewById(R.id.unanswered);
        time_remaining = (TextView) view.findViewById(R.id.time_remaining);
        unanswered_info = (TextView) view.findViewById(R.id.unanswered_info);
        info = (TextView) view.findViewById(R.id.info);
        submit = (Button) view.findViewById(R.id.submit);

        description.setTypeface(fontUtil.getTypeface("LatoRegular"));
        time.setTypeface(fontUtil.getTypeface("LatoBold"));
        unanswered.setTypeface(fontUtil.getTypeface("LatoBold"));
        time_remaining.setTypeface(fontUtil.getTypeface("LatoRegular"));
        unanswered_info.setTypeface(fontUtil.getTypeface("LatoRegular"));
        info.setTypeface(fontUtil.getTypeface("LatoRegular"));
        submit.setTypeface(fontUtil.getTypeface("LatoBold"));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        return view;

    }
}
