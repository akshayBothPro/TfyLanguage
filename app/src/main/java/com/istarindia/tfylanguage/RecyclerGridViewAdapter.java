package com.istarindia.tfylanguage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.istarindia.tfylanguage.pojo.GridItem;

import java.util.ArrayList;

/**
 * Created by istarferoz on 30/10/17.
 */

public class RecyclerGridViewAdapter extends RecyclerView.Adapter {

    ArrayList<GridItem> gridItems;
    Context context;
    public RecyclerGridViewAdapter(Context context, ArrayList<GridItem> gridItems){
        this.context = context;
        this.gridItems = gridItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).setData(gridItems.get(position));

    }



    @Override
    public int getItemCount() {
        return gridItems.size();
    }
}
