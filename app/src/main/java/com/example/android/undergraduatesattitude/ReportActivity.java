package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    Report report;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    HashMap<CommittedCategory, List<CommittedActivity>> listDataChild;
    ArrayList<CommittedCategory> listDataGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        int weekIndex = getIntent().getIntExtra("EXTRA_WEEK_INDEX", 0);

        report = User.user.getWeeks().get(weekIndex).getReport();

        TextView weekPercentage = (TextView) findViewById(R.id.week_percentage);
        weekPercentage.setText(report.getOverallPercentage() + "%");

        TextView weekAdvice = (TextView) findViewById(R.id.week_advice);
        weekAdvice.setText(report.getWeekAdvice());

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.categories_list);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getApplicationContext(), listDataGroup, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {

        listDataGroup = report.getCommittedCategories();

        listDataChild = new HashMap<>();

        for(CommittedCategory cc : listDataGroup){
            listDataChild.put(cc , cc.getCommittedActivities());
        }
    }

    public void showTotalWeekAdvice(View view){

        TextView weekAdvice = findViewById(R.id.week_advice);
        if(weekAdvice.getVisibility() == View.GONE){
            weekAdvice.setVisibility(View.VISIBLE);
        }
        else if(weekAdvice.getVisibility() == View.VISIBLE){
            weekAdvice.setVisibility(View.GONE);
        }

    }

}
