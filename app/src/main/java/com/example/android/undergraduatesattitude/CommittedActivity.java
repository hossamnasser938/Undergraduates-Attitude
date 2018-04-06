package com.example.android.undergraduatesattitude;


/**
 *
 * @author abdelkhalik
 */
public class CommittedActivity extends OptimalActivity {

    ActivityDuration committedDuration;
    private String advice;

    public CommittedActivity(String name, Category category, ActivityDuration max, ActivityDuration min, Priority priority, String advice, ActivityDuration committedDuration) {
        super(name, category, max, min, priority);
        this.committedDuration = committedDuration;

    }

    ;
    
    /**
     * @return the advice
     */
    public String getAdvice() {
        return advice;
    }

    /**
     * @param advice the advice to set
     */
    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public ActivityDuration setCommittedDuration() {
        return committedDuration;
    }

    public void setCommittedDuration(ActivityDuration duration) {
        this.committedDuration = duration;
    }

    public String generateAdice(ActivityDuration committedDuration, Priority priority, ActivityDuration max, ActivityDuration min) {
        String Advice = null;
        double CommittedDuration = committedDuration.getHours() + ((committedDuration.getMinutes()) / 60);
        double maxDuration = max.getHours() + ((max.getMinutes()) / 60);
        double minDuration = min.getHours() + ((min.getMinutes()) / 60);
        switch (priority) {
            case OPTIONAL:
                if (CommittedDuration > maxDuration) {
                    Advice = "You Have more committed Duration in this Activity which the number of hours is : "+(CommittedDuration-maxDuration)+" Hrs";

                }

                break;
            case RECOMMENDED:
                if (CommittedDuration > maxDuration) {
                    Advice = "You must decrease the committed duration with  "+(maxDuration-CommittedDuration)+"Hrs";
                } else if (CommittedDuration < minDuration) {
                    Advice = "You must increase the committed duration with "+(CommittedDuration-minDuration)+"Hrs";
                }
                break;
            case MANDATORY:
                if (CommittedDuration > maxDuration) {
                    Advice = "To much time , you must decrease the committed duration with "+(maxDuration-CommittedDuration)+"Hrs to be come better !";
                } else if (CommittedDuration < minDuration) {
                    Advice = "Committed duration must be increase with "+(CommittedDuration-minDuration)+"Hrs to reach better life";
                }
                break;
            default:
                break;

        }
        return Advice;
    }
}
