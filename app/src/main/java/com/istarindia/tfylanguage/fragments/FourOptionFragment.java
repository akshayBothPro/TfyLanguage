package com.istarindia.tfylanguage.fragments;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.istarindia.tfylanguage.R;
import com.istarindia.tfylanguage.pojo.AssessmentPojo;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by istarferoz on 28/10/17.
 */

public class FourOptionFragment extends Fragment {
    private TextView questionText;
    private LinearLayout optionlayout;
    private Button next;
    public static final String GET_OBJECT = "GET_OBJECT";
    private AssessmentPojo assessmentPojo;
    LinearLayout.LayoutParams llparams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 0, 50f);
    LinearLayout.LayoutParams llparams1 = new LinearLayout.LayoutParams(
            0, LinearLayout.LayoutParams.MATCH_PARENT, 50f);
    LinearLayout.LayoutParams optionParams;
    ColorStateList colorStateList;
    private LinearLayout linearLayout;
    private HashMap<RadioButton, LinearLayout> mymap = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.four_option_dymanic, container, false);
        questionText = (TextView) view.findViewById(R.id.questionText);
        optionlayout = (LinearLayout) view.findViewById(R.id.optionlayout);
        next = (Button) view.findViewById(R.id.next);
        assessmentPojo = (AssessmentPojo) getArguments().getSerializable(GET_OBJECT);
        int i = 0;
        llparams1.setMargins(10, 10, 10, 10);
        colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_enabled} //enabled
                },
                new int[]{getResources().getColor(R.color.bluecolor)}
        );

        questionText.setText(assessmentPojo.getQuestionPojo().getText());


        int row = (int )Math.ceil((double)assessmentPojo.getOptionPojo().getOptions().size()/2);
        System.out.println("roww >>>>>>>>>>>>>>>>>>>>>>>>>>>>"+row+" jj "+((double)assessmentPojo.getOptionPojo().getOptions().size()/2));

        llparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 100/row);
        for (String option : assessmentPojo.getOptionPojo().getOptions()) {
                if (i % 2 == 0) {
                    linearLayout = new LinearLayout(getContext());
                    linearLayout.setLayoutParams(llparams);
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    linearLayout.setWeightSum(100);
                }
                LayoutInflater option_inflate =  LayoutInflater.from(getContext());


                final View option_view = option_inflate .inflate(R.layout.option_inflate, linearLayout, false);
                Button b = option_view.findViewById(R.id.button);
                b.setText(option);
                setListener(option_view);
                linearLayout.addView(option_view);
                if (i % 2 == 0) {
                    optionlayout.addView(linearLayout);

                }



            i++;
        }
        return view;
    }


    private void setListener(View option_view){
        LinearLayout ll = (LinearLayout) option_view.findViewById(R.id.ll);
        final RadioButton radioButton = (RadioButton) option_view.findViewById(R.id.radio0);
        mymap.put(radioButton,ll);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (RadioButton rr : mymap.keySet()) {
                    GradientDrawable bgShape = (GradientDrawable) mymap.get(rr).getBackground();
                    bgShape.setStroke(10, getResources().getColor(R.color.input_border));
                    bgShape.setColor(getResources().getColor(R.color.white));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        rr.setButtonTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.input_border)));
                    }
                    rr.setHighlightColor(getResources().getColor(R.color.input_border));
                    rr.setChecked(false);
                }
                GradientDrawable bgShape = (GradientDrawable) v.getBackground();
                bgShape.setStroke(10, getResources().getColor(R.color.bluecolor));
                bgShape.setColor(getResources().getColor(R.color.lightbluecolor));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    radioButton.setButtonTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.bluecolor)));
                }
                radioButton.setHighlightColor(getResources().getColor(R.color.bluecolor));
                radioButton.setChecked(true);
            }
        });

    }




    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
