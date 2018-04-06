package com.example.android.undergraduatesattitude;

/**
 *
 * @author abdelkhalik
 */
public class OptimalActivity extends Activity {

    private  ActivityDuration max;
    
    private  Priority priority;
    
    enum Priority {
        OPTIONAL ,
        RECOMMENDED ,
        MANDATORY ,
    };

    public OptimalActivity(String name , Category category ,ActivityDuration max,ActivityDuration min  ,Priority priority) 
    {
        super(name,category,min);
       this.max=max;
        this.priority=priority;
    }
    
}
