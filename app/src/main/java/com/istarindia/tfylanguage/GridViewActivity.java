package com.istarindia.tfylanguage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.istarindia.tfylanguage.pojo.GridItem;
import com.istarindia.tfylanguage.pojo.Lesson;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    ArrayList<GridItem> gridItems = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerGridViewAdapter recyclerGridViewAdapter;
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

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        setDummyData();
        recyclerGridViewAdapter = new RecyclerGridViewAdapter(this,gridItems);
        recyclerView.setAdapter(recyclerGridViewAdapter);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 1) {
                    return 2; // the item in position now takes up 4 spans
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(manager);
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
                lesson = new Lesson(j,"this is the lesson ,serialized as " + j,false);
                lessonList.add(lesson);
            }
            item.setLessons(lessonList);
            item.setInCompleteLessons(i);
            gridItems.add(item);
        }

    }
}
