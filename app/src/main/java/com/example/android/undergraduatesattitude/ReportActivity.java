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

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.categories_list);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getApplicationContext(), listDataGroup, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        /*
        Report report = User.user.getWeek().getReport();

        ArrayList<ArrayList<CommittedActivity>> committedActivitiesArrayLists = new ArrayList<>();
        for(int i = 0; i < report.getCommittedCategories().size() ; i++){
            committedActivitiesArrayLists.add(report.getCommittedCategories().get(i).getCommittedActivities());
        }

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), report.getCommittedCategories(), committedActivitiesArrayLists);
        ListView categoriesList = findViewById(R.id.categories_list);
        categoriesList.setAdapter(adapter);
        */
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {

        listDataGroup = User.user.getWeek().getReport().getCommittedCategories();

        listDataChild = new HashMap<>();

        for(CommittedCategory cc : listDataGroup){
            listDataChild.put(cc , cc.getCommittedActivities());
        }
    }

}
