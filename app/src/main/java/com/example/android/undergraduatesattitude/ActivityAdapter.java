package com.example.android.undergraduatesattitude;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hosam on 4/8/2018.
 */

public class ActivityAdapter extends ArrayAdapter {

    public ActivityAdapter(Context context, ArrayList<CommittedActivity> committedActivities){
        super(context, 0, committedActivities);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        CommittedActivity committedActivity = (CommittedActivity) getItem(position);

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_template, parent, false);
        }

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_template, null);

        TextView activityName = (TextView) view.findViewById(R.id.activity_name);
        TextView activityAdvice = (TextView) view.findViewById(R.id.activity_advice);

        committedActivity.generateAdice();

        activityName.setText(committedActivity.getName());
        activityAdvice.setText(committedActivity.getAdvice());

        return view;
    }
}
