package com.example.android.undergraduatesattitude;


/**
 *
 * @author abdelkhalik
 */
public class CommittedActivity extends OptimalActivity {

    private String advice;

    public CommittedActivity(Category category, String name, ActivityDuration committedDuration) {
        super(category, name, KnowledgeBase.getActivityOptimalMaxDuration(name), KnowledgeBase.getActivityOptimalMinDuration(name), KnowledgeBase.getActivityPriority(name));
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

    public void generateAdice() {
        String Advice = null;
        double CommittedDuration = this.getCommittedDuration().getHours() + ((this.getCommittedDuration().getMinutes()) / 60);
        double maxDuration = this.getMaxDuration().getHours() + ((this.getMaxDuration().getMinutes()) / 60);
        double minDuration = this.getMinDuration().getHours() + ((this.getMinDuration().getMinutes()) / 60);
        switch (this.getPriority()) {
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
