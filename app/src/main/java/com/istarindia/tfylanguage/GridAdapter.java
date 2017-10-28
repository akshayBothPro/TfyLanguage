package com.istarindia.tfylanguage;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.istarindia.tfylanguage.pojo.GridItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by akshay on 10/25/17.
 */

public class GridAdapter extends BaseAdapter {

    //int icons[];
    //String letters[];
    Context context;
    LayoutInflater inflater;
    ArrayList<GridItem> gridItems;


    public GridAdapter(int[] icons, String[] letters, Context context) {
        //this.icons = icons;
        //this.letters = letters;
        this.context = context;
    }

    public GridAdapter(Context context, ArrayList<GridItem> gridItems) {
        //this.icons = icons;
        //this.letters = letters;
        this.context = context;
        this.gridItems = gridItems;
    }

    @Override
    public int getCount() {
        return gridItems.size();
    }

    @Override
    public Object getItem(int i) {
        return gridItems.get(i);
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

        CircularImageView icon = (CircularImageView) gridView.findViewById(R.id.icons);
        TextView title = (TextView) gridView.findViewById(R.id.letters);
        Button incompleteLessons = (Button) gridView.findViewById(R.id.btn_incomplete_lessons);

        icon.setBorderColor(Color.parseColor(gridItems.get(i).color));
        Picasso.with(this.context)
                .load(gridItems.get(i).imageUrl)
                .into(icon);
        title.setText(gridItems.get(i).getName());

        if (gridItems.get(i).inCompleteLessons != 0) {
            incompleteLessons.setText("" + gridItems.get(i).inCompleteLessons);
            incompleteLessons.setVisibility(View.VISIBLE);
        } else {
            incompleteLessons.setVisibility(View.INVISIBLE);
        }

        return gridView;
    }

}
