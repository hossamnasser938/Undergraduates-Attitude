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
        setMaxDuration(KnowledgeBase.getCategoryOptimalMaxDuration(category.toString()));
        setMinDuration(KnowledgeBase.getCategoryOptimalMinDuration(category.toString()));
        setCommittedActivities(new ArrayList<CommittedActivity>());

        committedActivities = new ArrayList<CommittedActivity>();
        for(OptimalActivity mandatoryActivity : KnowledgeBase.optimalActivities){
            if(mandatoryActivity.getCategory() == category && mandatoryActivity.getPriority() == OptimalActivity.Priority.MANDATORY){
                getCommittedActivities().add(new CommittedActivity(mandatoryActivity.getCategory(), mandatoryActivity.getName(), new ActivityDuration(0, 0)));
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
        return percentage;
    }

    public void calculatePercentage() {
        double optimalMaxHours = this.getMaxDuration().getHours() + (double) this.getMaxDuration().getMinutes() / 60;
        double optimalMinHours = this.getMinDuration().getHours() + (double) this.getMinDuration().getMinutes() / 60;
        double committedHours = this.committedDuration.getHours() + (double) this.committedDuration.getMinutes() / 60;
        double optimalAverageHours = (optimalMaxHours + optimalMinHours) / 2;
        this.percentage = (int) (committedHours / optimalAverageHours);
    }

}
