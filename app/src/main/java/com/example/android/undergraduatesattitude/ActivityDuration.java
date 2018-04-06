package com.example.android.undergraduatesattitude;

/**
 *
 * @author abdelkhalik
 */
public class ActivityDuration {

    private int hours;
    private int minutes;

    ActivityDuration(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
