package com.example.android.undergraduatesattitude;

/**
 * Created by Hosam on 3/28/2018.
 */

public class Activity {

    private String name;
    private Category category;
    private ActivityDuration duration;

    Activity(Category category, String name) {
        this.name = name;
        this.category = category;
    }

    Activity(String name, Category category, ActivityDuration duration){
        this.name = name;
        this.category = category;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ActivityDuration getDuration() {
        return duration;
    }

    public void setDuration(ActivityDuration duration) {
        this.duration = duration;
    }
}
