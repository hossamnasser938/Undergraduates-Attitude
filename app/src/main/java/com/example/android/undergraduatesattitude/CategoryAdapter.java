package com.example.android.undergraduatesattitude;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hosam on 4/8/2018.
 */

public class CategoryAdapter extends ArrayAdapter {

    Context context;
    ArrayList<ArrayList<CommittedActivity>> committedActivitiesArrayLists = new ArrayList<>();

    public CategoryAdapter(Context context, ArrayList<CommittedCategory> committedCategories, ArrayList<ArrayList<CommittedActivity>> committedActivitiesArrayLists){
        super(context, 0, committedCategories);
        this.context = context;
        this.committedActivitiesArrayLists = committedActivitiesArrayLists;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        CommittedCategory committedCategory = (CommittedCategory) getItem(position);

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.category_template, parent, false);
        }

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.category_template, null);

        TextView categoryName = (TextView) view.findViewById(R.id.category_name);
        ListView activitiesList = (ListView) view.findViewById(R.id.activities_list);
        ProgressBar categoryPercentage = (ProgressBar) view.findViewById(R.id.category_percentage);

        committedCategory.calculatePercentage();

        ActivityAdapter adapter = new ActivityAdapter(context, committedActivitiesArrayLists.get(position));
        activitiesList.setAdapter(adapter);

        categoryName.setText(committedCategory.toString());
        categoryPercentage.setMin(0);
        categoryPercentage.setMax(100);
        categoryPercentage.setProgress(committedCategory.getPercentage());

        return view;
    }

}
