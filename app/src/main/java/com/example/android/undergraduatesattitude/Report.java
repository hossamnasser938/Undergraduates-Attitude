package com.example.android.undergraduatesattitude;



import java.util.ArrayList;

public class Report{

    public static final int WEEK_HOURS=168;
    private int allCommitedHours;
    private int allRemainingHours;
    private boolean overflowed;
    private int allOverflowedHours;
    private ArrayList<CommittedCategory> committedCategories;
    private int overallPercentage;

    public Report(){
        committedCategories = new ArrayList<>();
        for(OptimalCategory oc : KnowledgeBase.optimalCategories){
            committedCategories.add(new CommittedCategory(oc.getCategory(), new ActivityDuration(0, 0)));
        }
    }

    public static int getWeekHours() {
        return WEEK_HOURS;
    }

    public int getAllCommitedHours() {
        return allCommitedHours;
    }

    public void setAllCommitedHours(int allCommitedHours) {
        this.allCommitedHours = allCommitedHours;
    }

    public int getAllRemainingHours() {
        return allRemainingHours;
    }

    public void setAllRemainingHours(int allRemainingHours) {
        this.allRemainingHours = allRemainingHours;
    }

    public boolean isOverflowed() {
        return overflowed;
    }

    public void setOverflowed(boolean overflowed) {
        this.overflowed = overflowed;
    }

    public int getAllOverflowedHours() {
        return allOverflowedHours;
    }

    public void setAllOverflowedHours(int allOverflowedHours) {
        this.allOverflowedHours = allOverflowedHours;
    }

    public ArrayList<CommittedCategory> getCommittedCategories() {
        return committedCategories;
    }

    public void setCommittedCategories(ArrayList<CommittedCategory> committedCategories) {
        this.committedCategories = committedCategories;
    }

    public int getOverallPercentage(){
        calculateOverallPercentage();
        return overallPercentage;
    }

    private void calculateOverallPercentage(){
        int percentage = 0;
        int i = 0;
        for(CommittedCategory cc : getCommittedCategories()){
            percentage += cc.getPercentage();
            i++;
        }
        overallPercentage = percentage / i;
    }
}