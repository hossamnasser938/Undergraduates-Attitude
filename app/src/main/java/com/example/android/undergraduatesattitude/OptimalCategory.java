package com.example.android.undergraduatesattitude;

/**
 * Created by Hosam on 4/7/2018.
 */

public class OptimalCategory {


    private Category category;
    private ActivityDuration maxDuration;
    private ActivityDuration minDuration;

    public OptimalCategory(Category category) {
        this.category = category;
    }

    public OptimalCategory(Category category, ActivityDuration maxDuration, ActivityDuration minDuration) {
        this.setCategory(category);
        this.setMaxDuration(maxDuration);
        this.setMinDuration(minDuration);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ActivityDuration getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(ActivityDuration maxDuration) {
        this.maxDuration = maxDuration;
    }

    public ActivityDuration getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(ActivityDuration minDuration) {
        this.minDuration = minDuration;
    }

}
