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
    
    static public ActivityDuration addTwoDurations(ActivityDuration duration1, ActivityDuration duration2){
        ActivityDuration addedDuration = new ActivityDuration(0 , 0);
        addedDuration.hours = duration1.hours() + duration2.hours();
        addedDuration.minutes = duration1.minutes() + duration2.minutes();
        if(addedDuration.minutes >= 60){
            addedDuration.hours += 1;
            addedDuration.minutes -= 60;
        }
        return addedDuration;
}
