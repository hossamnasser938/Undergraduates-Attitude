package com.example.android.undergraduatesattitude;

/**
 *
 * @author abdelkhalik
 */
public class OptimalActivity extends Activity {

    private  ActivityDuration maxDuration;
    private  ActivityDuration minDuration;
    private  Priority priority;

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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    enum Priority {
        OPTIONAL ,
        RECOMMENDED ,
        HIGHLY_RECOMMENDED,
        MANDATORY ,
    };

    public OptimalActivity(Category category, String name, ActivityDuration maxDuration, ActivityDuration minDuration, Priority priority)
    {
        super(category,name);
        this.setMaxDuration(maxDuration);
        this.setMinDuration(minDuration);
        this.setPriority(priority);
    }
    
}
