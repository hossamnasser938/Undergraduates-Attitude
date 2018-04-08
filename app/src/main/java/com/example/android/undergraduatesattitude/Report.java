package com.example.android.undergraduatesattitude;



import java.util.ArrayList;

public class Report{

    public static final int WEEK_HOURS=168;
    private int allCommitedHours;
    private int allRemainingHours;
    private boolean overflowed;
    private int allOverflowedHours;
    private ArrayList<CommittedActivity> committedActivities;
    private ArrayList<CommittedCategory> committedCategory;
private double overallPercentage;
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

    public ArrayList<CommittedActivity> getCommittedActivities() {
        return committedActivities;
    }

    public void setCommittedActivities(ArrayList<CommittedActivity> committedActivities) {
        this.committedActivities = committedActivities;
    }

    public ArrayList<CommittedCategory> getCommittedCategory() {
        return committedCategory;
    }

    public void setCommittedCategory(ArrayList<CommittedCategory> committedCategory) {
        this.committedCategory = committedCategory;
    }
    public double calculateOverallPercentage(){
        int h=0;
        int m=0;
        double overall=0;
        for(CommittedActivity c:committedActivities) {
            h += c.getCommittedDuration().getHours();
            m += c.getCommittedDuration().getMinutes();
        }
        h+=m/60;
        m=m%60;
        overall=h+(double)m/60;
        return (overall/168)*100;
    }
}