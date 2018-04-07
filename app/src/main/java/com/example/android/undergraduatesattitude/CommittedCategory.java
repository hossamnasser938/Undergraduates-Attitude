package com.example.android.undergraduatesattitude;

/**
 * Created by Hosam on 4/7/2018.
 */

public class CommittedCategory {

    private Category category;
    private ActivityDuration optimalHours;
    private ActivityDuration committedHours;
    private int percentage;

    public CommittedCategory(Category category, ActivityDuration optimalHours, ActivityDuration committedHours) {
        this.setCategory(category);
        this.setOptimalHours(optimalHours);
        this.setCommittedHours(committedHours);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ActivityDuration getOptimalHours() {
        return optimalHours;
    }

    public void setOptimalHours(ActivityDuration optimalHours) {
        this.optimalHours = optimalHours;
    }

    public ActivityDuration getCommittedHours() {
        return committedHours;
    }

    public void setCommittedHours(ActivityDuration committedHours) {
        this.committedHours = committedHours;
    }

    public int getPercentage() {
        return percentage;
    }

    public void calculatePercentage() {
        double optimalHours = this.optimalHours.getHours() + (double) this.optimalHours.getMinutes() / 60;
        double committedHours = this.committedHours.getHours() + (double) this.committedHours.getMinutes() / 60;
        this.percentage = (int) (committedHours / optimalHours * 100);
    }
}
