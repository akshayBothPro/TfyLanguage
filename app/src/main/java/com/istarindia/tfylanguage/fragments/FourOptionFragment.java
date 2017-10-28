package com.istarindia.tfylanguage.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.istarindia.tfylanguage.R;

/**
 * Created by istarferoz on 28/10/17.
 */

public class FourOptionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_end_assessment, container, false);
        return view;
    }
}
