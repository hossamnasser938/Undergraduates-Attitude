package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        ArrayList<ArrayList<CommittedActivity>> committedActivitiesArrayLists = new ArrayList<ArrayList<CommittedActivity>>();
        for(int i = 0; i < report.committedCategories.size() ; i++){
            committedActivitiesArrayLists.add(report.committedCategories.get(i).committedActivities);
        }

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), report.committedCategories, committedActivitiesArrayLists);

        ListView categoriesList = findViewById(R.id.categories_list);
        categoriesList.setAdapter(adapter);
    }
}
