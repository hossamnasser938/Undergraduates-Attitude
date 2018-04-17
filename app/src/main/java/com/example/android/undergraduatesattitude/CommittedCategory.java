package com.example.android.undergraduatesattitude;

import java.util.ArrayList;

/**
 * Created by Hosam on 4/7/2018.
 */

public class CommittedCategory extends OptimalCategory {

    private ActivityDuration committedDuration;
    private int percentage;
    private ArrayList<CommittedActivity> committedActivities;

    public CommittedCategory(Category category, ActivityDuration committedDuration) {
        super(category);
        this.committedDuration = committedDuration;
        setMaxDuration(KnowledgeBase.getCategoryOptimalMaxDuration(category.name()));
        setMinDuration(KnowledgeBase.getCategoryOptimalMinDuration(category.name()));
        setCommittedActivities(new ArrayList<CommittedActivity>());

        committedActivities = new ArrayList<CommittedActivity>();
        for(OptimalActivity mandatoryActivity : KnowledgeBase.getOptimalActivities()){
            if(mandatoryActivity.getCategory() == category && (mandatoryActivity.getPriority() == OptimalActivity.Priority.MANDATORY || mandatoryActivity.getPriority() == OptimalActivity.Priority.HIGHLY_RECOMMENDED)){
                committedActivities.add(new CommittedActivity(mandatoryActivity.getCategory(), mandatoryActivity.getName(), new ActivityDuration(0, 0)));
            }
        }
    }

    public ActivityDuration getCommittedDuration() {
        return committedDuration;
    }

    public void setCommittedDuration(ActivityDuration committedDuration) {
        this.committedDuration = committedDuration;
    }

    public ArrayList<CommittedActivity> getCommittedActivities() {
        return committedActivities;
    }

    public void setCommittedActivities(ArrayList<CommittedActivity> committedActivities) {
        this.committedActivities = committedActivities;
    }

    public int getPercentage() {
        calculatePercentage();
        return percentage;
    }

    private void calculatePercentage() {
        double optimalMaxHours = getMaxDuration().getHours() + (double) getMaxDuration().getMinutes() / 60;
        double optimalMinHours = getMinDuration().getHours() + (double) getMinDuration().getMinutes() / 60;
        double committedHours = committedDuration.getHours() + (double) committedDuration.getMinutes() / 60;
        double optimalAverageHours = (optimalMaxHours + optimalMinHours) / 2;
        percentage = (int) ((committedHours / optimalAverageHours) * 100);
    }

}
