package com.istarindia.tfylanguage;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.istarindia.tfylanguage.pojo.GridItem;
import com.istarindia.tfylanguage.util.ShadowTransformer;

public class ViewPagerCardActivity extends AppCompatActivity {

    public GridItem gridItem;

    private ViewPager mViewPager;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    public ImageView courseImg;
    public CoordinatorLayout rootContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_card);

        if (getIntent().getExtras().containsKey("grid_item")) {
            gridItem = (GridItem) getIntent().getExtras().getSerializable("grid_item");
        }

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        courseImg = (ImageView) findViewById(R.id.iv_course);
        rootContainer = (CoordinatorLayout) findViewById(R.id.cl_root_container);
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),dpToPixels(2,this), gridItem.lessons);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mFragmentCardAdapter);
        mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

    }


    public  static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ViewPagerCardActivity.this, GridViewActivity.class));
    }
}


