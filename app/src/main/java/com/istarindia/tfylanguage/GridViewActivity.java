package com.istarindia.tfylanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.istarindia.tfylanguage.pojo.GridItem;
import com.istarindia.tfylanguage.pojo.Lesson;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    ArrayList<GridItem> gridItems = new ArrayList<>();
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = (GridView) findViewById(R.id.gridview);
        setDummyData();

        GridAdapter adapter = new GridAdapter(GridViewActivity.this, gridItems);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(GridViewActivity.this, ViewPagerCardActivity.class);
                intent.putExtra("grid_item", gridItems.get(position));

                startActivity(intent);
            }
        });

    }

    public void setDummyData() {

        GridItem item;
        Lesson lesson;
        int n = 0;
        ArrayList<Lesson> lessonList;
        for(int i = 1; i <= 12; i++){
            item = new GridItem();
            item.setId(i);

            if (i % 2 == 0) {
                item.setColor("#ee6723");
                item.setImageUrl("http://cdn.talentify.in:9999//course_images/7.png");
                n = 5;
            } else {
                item.setColor("#ff4444");
                item.setImageUrl("http://cdn.talentify.in:9999//course_images/m_83.png");
                n = 8;
            }

            item.setName("Course " + i);
            lessonList = new ArrayList<>();
            for(int j = 1; j < n; j++) {
                lesson = new Lesson(j,"this is the lesson ,serialized as " + j, true);
                lessonList.add(lesson);
            }
            item.setLessons(lessonList);
            item.setInCompleteLessons(i);
            gridItems.add(item);
        }

    }
}
