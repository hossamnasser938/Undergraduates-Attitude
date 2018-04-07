package com.example.android.undergraduatesattitude;

/**
 *
 * @author abdelkhalik
 */
public class OptimalActivity extends Activity {

    private  ActivityDuration maxDuration;
    private  ActivityDuration minDuration;
    private  Priority priority;
    
    enum Priority {
        OPTIONAL ,
        RECOMMENDED ,
        MANDATORY ,
    };

    public OptimalActivity(Category category, String name, ActivityDuration maxDuration, ActivityDuration minDuration, Priority priority)
    {
        super(category,name);
        this.maxDuration=maxDuration;
        this.minDuration=minDuration;
        this.priority=priority;
    }
    
}
