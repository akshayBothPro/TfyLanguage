package com.istarindia.tfylanguage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.felipecsl.asymmetricgridview.library.Utils;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.istarindia.tfylanguage.complexobject.ModulePOJO;
import com.istarindia.tfylanguage.pojo.GridItem;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by istarferoz on 30/10/17.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textView;
    //public ImageView imageView;
    public CircularImageView imageView;
    public RelativeLayout relativeLayout;
    public Button incompleteLessons;
    Context context;
    ModulePOJO item;

    public ViewHolder(View v, Context context) {

        super(v);
        this.context  =context;
        v.setOnClickListener(this);

        textView = (TextView) v.findViewById(R.id.text);
        //imageView = (ImageView) v.findViewById(R.id.image);
        imageView = (CircularImageView) v.findViewById(R.id.image);
        relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);
        incompleteLessons = (Button) v.findViewById(R.id.btn_incomplete_lessons);

    }

    public void setData(final ModulePOJO item) {
        this.item = item;
        textView.setText(item.getName());

        //imageView.setBorderColor(Color.parseColor(item.color));
        new DownloadImagesTask(imageView,item.getImageURL()).execute();


        /*
        if (item.inCompleteLessons != 0) {
            incompleteLessons.setText("" + item.inCompleteLessons);
            incompleteLessons.setVisibility(View.VISIBLE);
        } else {
            incompleteLessons.setVisibility(View.INVISIBLE);
        }*/

    }

    public void bind(final ModulePOJO item) {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moduleIntent = new Intent(context, ViewPagerCardActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("grid_item", item);
                moduleIntent.putExtras(bundle);
                context.startActivity(moduleIntent);
                ((Activity) context).finish();
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.relativeLayout:
                break;
        }

    }

    public class DownloadImagesTask extends AsyncTask<ImageView, Void, Bitmap> {

        ImageView imageView = null;
        String url;
        public DownloadImagesTask(ImageView imageView,String url){
            this.imageView = imageView;
            this.url = url;
        }

        @Override
        protected Bitmap doInBackground(ImageView... imageViews) {
            return download_Image(url);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null)
                imageView.setImageBitmap(result);
            //} else {
                //imageView.setImageResource(R.drawable.a);
            //}

        }

        private Bitmap download_Image(String url) {

            Bitmap bmp =null;
            try{
                URL ulrn = new URL(url);
                HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
                InputStream is = con.getInputStream();
                bmp = BitmapFactory.decodeStream(is);
                if (bmp != null)
                    return bmp;

            } catch (Exception e){}

            return bmp;
        }
    }
}
