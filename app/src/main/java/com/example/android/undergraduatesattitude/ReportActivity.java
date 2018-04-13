package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    HashMap<CommittedCategory, List<CommittedActivity>> listDataChild;
    ArrayList<CommittedCategory> listDataGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        int weekIndex = getIntent().getIntExtra("EXTRA_WEEK_INDEX", 0);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.categories_list);

        // preparing list data
        prepareListData(weekIndex);

        listAdapter = new ExpandableListAdapter(getApplicationContext(), listDataGroup, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

    }

    /*
     * Preparing the list data
     */
    private void prepareListData(int weekIndex) {

        listDataGroup = User.user.getWeeks().get(weekIndex).getReport().getCommittedCategories();

        listDataChild = new HashMap<>();

        for(CommittedCategory cc : listDataGroup){
            listDataChild.put(cc , cc.getCommittedActivities());
        }
    }

}
