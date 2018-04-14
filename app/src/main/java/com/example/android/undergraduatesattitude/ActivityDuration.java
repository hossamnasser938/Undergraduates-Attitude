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
        ActivityDuration addedDuration = new ActivityDuration(0, 0);
        addedDuration.hours = duration1.hours + duration2.hours;
        addedDuration.minutes = duration1.minutes + duration2.minutes;
        if(addedDuration.minutes >= 60){
            addedDuration.hours += 1;
            addedDuration.minutes -= 60;
        }
        return addedDuration;
    }
    
    public ActivityDuration mulDuration(double multiplier){
        double dHours;
        double dMinutes;
        ActivityDuration multipliedDuration = new ActivityDuration(0, 0);
        dHours = hours * multiplier;
        dMinutes = minutes * multiplier;
        multipliedDuration.hours = (int) dHours;
        multipliedDuration.minutes = (int)((dHours - multipliedDuration.hours) * 60);
        multipliedDuration.minutes +=  (int) dMinutes;
        if(multipliedDuration.minutes >= 60){
            multipliedDuration.hours += multipliedDuration.minutes / 60;
            multipliedDuration.minutes %= 60;
        }
        return multipliedDuration;
    }
    
}
