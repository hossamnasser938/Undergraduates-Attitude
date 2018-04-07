package com.example.android.undergraduatesattitude;


/**
 *
 * @author abdelkhalik
 */
public class CommittedActivity extends OptimalActivity {

    private String advice;

    public CommittedActivity(Category category, String name, ActivityDuration committedDuration, Priority priority) {
        super(category, name, KnowledgeBase.getActivityOptimalMaxDuration(name), KnowledgeBase.getActivityOptimalMinDuration(name), priority);
        this.setDuration(committedDuration);

    }


    public ActivityDuration getCommittedDuration() {
        return getDuration();
    }

    public void setCommittedDuration(ActivityDuration duration) {
        this.setDuration(duration);
    }

    /**
     * @return the advice
     */
    public String getAdvice() {
        return advice;
    }

    public void generateAdice(ActivityDuration committedDuration, Priority priority, ActivityDuration max, ActivityDuration min) {
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

        this.advice = Advice;
    }
}
