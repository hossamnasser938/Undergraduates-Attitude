package com.example.android.undergraduatesattitude;

import java.util.ArrayList;

/**
 * Created by Hosam on 4/7/2018.
 */

public class CommittedCategory extends OptimalCategory {

    private ActivityDuration committedDuration;
    private int percentage;
    public ArrayList<CommittedActivity> committedActivities;

    public CommittedCategory(Category category, ActivityDuration committedHours) {
        super(category);
        this.committedDuration = committedDuration;
        this.setMaxDuration(KnowledgeBase.getCategoryOptimalMaxDuration(category.toString()));
        this.setMinDuration(KnowledgeBase.getCategoryOptimalMinDuration(category.toString()));

        committedActivities = new ArrayList<>();
        for(OptimalActivity mandatoryActivity : KnowledgeBase.optimalActivities){
            if(mandatoryActivity.getPriority() == OptimalActivity.Priority.MANDATORY){
                committedActivities.add(new CommittedActivity(mandatoryActivity.getCategory(), mandatoryActivity.getName(), new ActivityDuration(0, 0), OptimalActivity.Priority.MANDATORY));
            }
        }
    }

    public ActivityDuration getCommittedDuration() {
        return committedDuration;
    }

    public void setCommittedHours(ActivityDuration committedDuration) {
        this.committedDuration = committedDuration;
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
