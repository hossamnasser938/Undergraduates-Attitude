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

        Report report = User.user.getWeek().getReport();

        ArrayList<ArrayList<CommittedActivity>> committedActivitiesArrayLists = new ArrayList<>();
        for(int i = 0; i < report.getCommittedCategories().size() ; i++){
            committedActivitiesArrayLists.add(report.getCommittedCategories().get(i).getCommittedActivities());
        }

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), report.getCommittedCategories(), committedActivitiesArrayLists);
        ListView categoriesList = findViewById(R.id.categories_list);
        categoriesList.setAdapter(adapter);
    }
}
