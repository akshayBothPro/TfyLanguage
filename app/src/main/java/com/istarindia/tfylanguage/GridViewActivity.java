package com.istarindia.tfylanguage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.istarindia.tfylanguage.complexobject.ComplexObject;
import com.istarindia.tfylanguage.complexobject.CoursePOJO;
import com.istarindia.tfylanguage.complexobject.ModulePOJO;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    ArrayList<ModulePOJO> moduleList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerGridViewAdapter recyclerGridViewAdapter;
    private SharedPreferences sharedpreferences;
    int trackingPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        sharedpreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_key), Context.MODE_PRIVATE);
        String complexObjectResponse = sharedpreferences.getString("COMPLEX_OBJECT_RESPONSE", "");
        System.out.println(complexObjectResponse);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        ComplexObject complexObject = gson.fromJson(complexObjectResponse, ComplexObject.class);
        for (CoursePOJO course : complexObject.getCourses()) {
            trackingPosition = 0;
            for(ModulePOJO module : course.getModules()) {

                if (trackingPosition == 0) {
                    module.setFirst(true);
                    trackingPosition++;
                }
                moduleList.add(module);
            }

        }

        recyclerGridViewAdapter = new RecyclerGridViewAdapter(this,moduleList);
        recyclerView.setAdapter(recyclerGridViewAdapter);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                if (moduleList.get(position).getFirst()) {
                    return 2; // the item in position now takes up 4 spans
                }

                return 1;
            }
        });
        recyclerView.setLayoutManager(manager);

    }

    @Override
    protected void onResume() {
        super.onResume();

        recyclerGridViewAdapter.notifyDataSetChanged();
    }

}
