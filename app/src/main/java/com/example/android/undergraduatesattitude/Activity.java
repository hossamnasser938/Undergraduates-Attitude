package com.example.android.undergraduatesattitude;

/**
 * Created by Hosam on 3/28/2018.
 */

public class Activity {

    private String name;
    private String category;
    private ActivityDuration duration;

    Activity(String name, String category, ActivityDuration duration){
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ActivityDuration getDuration() {
        return duration;
    }

    public void setDuration(ActivityDuration duration) {
        this.duration = duration;
    }
}
