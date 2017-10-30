package com.istarindia.tfylanguage.fragments;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.istarindia.tfylanguage.R;
import com.istarindia.tfylanguage.ViewPagerActivity;
import com.istarindia.tfylanguage.pojo.AssessmentPojo;
import com.istarindia.tfylanguage.util.FontUtil;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by istarferoz on 27/10/17.
 */

public class ListenAndWrite extends Fragment implements View.OnClickListener,TextToSpeech.OnInitListener {
    public static final String GET_OBJECT = "GET_OBJECT";
    private AssessmentPojo assessmentPojo;
    private Button next,cantlisten;
    private TextView listentext;
    private ImageButton large_sound,small_sound;
    private AppCompatEditText input_text;
    private FontUtil fontUtil;
    private TextToSpeech tts;
    private ArrayList<String> selectedOptions = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listen_write_fragment, container, false);
        assessmentPojo = (AssessmentPojo) getArguments().getSerializable(GET_OBJECT);
        next = (Button) view.findViewById(R.id.next);
        cantlisten = (Button) view.findViewById(R.id.cantlisten);
        listentext = (TextView) view.findViewById(R.id.listentext);
        large_sound = (ImageButton) view.findViewById(R.id.large_sound);
        small_sound = (ImageButton) view.findViewById(R.id.small_sound);
        input_text = (AppCompatEditText) view.findViewById(R.id.input_text);
        fontUtil = new FontUtil(getContext());
        next.setTypeface(fontUtil.getTypeface("LatoRegular"));
        cantlisten.setTypeface(fontUtil.getTypeface("LatoRegular"));
        listentext.setTypeface(fontUtil.getTypeface("LatoRegular"));
        input_text.setTypeface(fontUtil.getTypeface("LatoRegular"));

        large_sound.setOnClickListener(this);
        small_sound.setOnClickListener(this);
        next.setOnClickListener(this);
        cantlisten.setOnClickListener(this);
        tts = new TextToSpeech(getContext(), this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.large_sound:
                speakOut(0.6f,1);
                break;
            case R.id.small_sound:
                speakOut(0.6f,0.3f);
                break;
            case R.id.next:
                ((ViewPagerActivity)getActivity()).next(assessmentPojo,selectedOptions);

                break;

        }
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                large_sound.setEnabled(true);
                small_sound.setEnabled(true);
                speakOut(0.6f,1);
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    private void speakOut(float pitch,float speechrate) {

        String text = assessmentPojo.getQuestionPojo().getText();
        tts.setPitch(pitch);
        tts.setSpeechRate(speechrate);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
