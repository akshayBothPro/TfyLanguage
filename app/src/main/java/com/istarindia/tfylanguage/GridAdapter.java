package com.istarindia.tfylanguage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;

/**
 * Created by akshay on 10/25/17.
 */

public class GridAdapter extends BaseAdapter {

    int icons[];
    String letters[];
    Context context;
    LayoutInflater inflater;


    public GridAdapter(int[] icons, String[] letters, Context context) {
        this.icons = icons;
        this.letters = letters;
        this.context = context;
    }


    @Override
    public int getCount() {
        return letters.length;
    }

    @Override
    public Object getItem(int i) {
        return letters[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View gridView = view;

        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.custom_layout, null);

        }

        ImageView icon = (CircularImageView) gridView.findViewById(R.id.icons);
        TextView letter = (TextView) gridView.findViewById(R.id.letters);

        icon.setImageResource(icons[i]);
        letter.setText(letters[i]);

        return gridView;
    }
}
