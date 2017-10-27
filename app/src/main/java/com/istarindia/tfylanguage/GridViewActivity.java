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

    /*
    String letterList[] = {
            "A", "D", "L", "M", "R",
            "A", "D", "L", "M", "R",
            "A", "D", "L", "M", "R"
    };

    int lettersIcon[] = {
            R.drawable.a, R.drawable.d, R.drawable.l, R.drawable.m, R.drawable.r,
            R.drawable.a, R.drawable.d, R.drawable.l, R.drawable.m, R.drawable.r,
            R.drawable.a, R.drawable.d, R.drawable.l, R.drawable.m, R.drawable.r
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = (GridView) findViewById(R.id.gridview);
        setDummyData();

        GridAdapter adapter = new GridAdapter(GridViewActivity.this, gridItems);
        gridView.setAdapter(adapter);
        /*
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("item grid" , gridItems.get(i).name);
                Toast.makeText(GridViewActivity.this, "Clicked course: " + gridItems.get(i).name, Toast.LENGTH_SHORT).show();
                //start view pager card activity and send griditem at index 'i' in the intent

                Intent intent = new Intent(GridViewActivity.this, ViewPagerCardActivity.class);
                intent.putExtra("grid_item", gridItems.get(i));

                startActivity(intent);
            }
        });
        */

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

        /* public int id;
    public String imageUrl;
    public String color;
    public String name;
    public ArrayList<Lesson> lessons;
    public int inCompleteLessons;
    public Boolean isCompleted;*/

        GridItem item;
        Lesson lesson;
        ArrayList<Lesson> lessonList;
        for(int i = 1; i <= 12; i++){
            item = new GridItem();
            item.setId(i);
            item.setImageUrl("http://cdn.talentify.in:9999//course_images/7.png");
            item.setColor("#ee6723");
            item.setName("Course " + i);
            lessonList = new ArrayList<>();
            for(int j = 1; j < 4; j++) {
                lesson = new Lesson(j,"this is the lesson ,serialized as " + j);
                lessonList.add(lesson);
            }
            item.setLessons(lessonList);
            item.setInCompleteLessons(i);
            gridItems.add(item);
        }

    }
}
