package com.example.android.undergraduatesattitude;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Hosam on 4/9/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<CommittedCategory> listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<CommittedCategory, List<CommittedActivity>> listDataChild;

    public ExpandableListAdapter(Context context, List<CommittedCategory> listDataHeader,
                                 HashMap<CommittedCategory, List<CommittedActivity>> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    @Override
    public CommittedActivity getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final CommittedActivity childTexts = getChild(groupPosition, childPosition);

        View view = convertView;

        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.activity_template, null);
        }

        TextView nameListChild = (TextView) view.findViewById(R.id.activity_name);
        nameListChild.setText(childTexts.getName());

        TextView adviceListChild = (TextView) view.findViewById(R.id.activity_advice);
        adviceListChild.setText(childTexts.getAdvice());

        return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public CommittedCategory getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        CommittedCategory headerTitle = getGroup(groupPosition);

        View view = convertView;
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.category_template, null);
        }

        TextView lblListHeader = (TextView) view.findViewById(R.id.category_name);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle.getCategory().toString());

        TextView percentage = view.findViewById(R.id.category_percentage);
        percentage.setText(headerTitle.getPercentage() + "%");

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
