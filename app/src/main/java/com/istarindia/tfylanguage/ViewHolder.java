package com.istarindia.tfylanguage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.istarindia.tfylanguage.pojo.GridItem;

/**
 * Created by istarferoz on 30/10/17.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textView;
    public ImageView imageView;
    GridItem item;

    public ViewHolder(View v) {

        super(v);

        v.setOnClickListener(this);
        textView = (TextView) v.findViewById(R.id.text);
        imageView = (ImageView) v.findViewById(R.id.image);

    }

    public void setData(GridItem item) {
        this.item = item;

        textView.setText(item.getName());

    }


    @Override
    public void onClick(View view) {

    }
}
