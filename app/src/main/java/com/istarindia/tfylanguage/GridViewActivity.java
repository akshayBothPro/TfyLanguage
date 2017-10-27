package com.istarindia.tfylanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends AppCompatActivity {

    GridView gridView;

    String letterList[] = {
            "A", "D", "L", "M", "R",
            "A", "D", "L", "M", "R",
            "A", "D", "L", "M", "R"
    };

    int lettersIcon[] = {
            R.drawable.a, R.drawable.d, R.drawable.l, R.drawable.m, R.drawable.r,
            R.drawable.a, R.drawable.d, R.drawable.l, R.drawable.m, R.drawable.r,
            R.drawable.a, R.drawable.d, R.drawable.l, R.drawable.m, R.drawable.r
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = (GridView) findViewById(R.id.gridview);
        GridAdapter adapter = new GridAdapter(lettersIcon, letterList, GridViewActivity.this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "Clicked Letter: " + letterList[i], Toast.LENGTH_SHORT).show();
            }
        });



    }
}
