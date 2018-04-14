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
     * Inference Engine
     * @return the advice
     */
    public String getAdvice() {
        generateAdice();
        return advice;
    }

    private void generateAdice() {

        double CommittedDuration = getCommittedDuration().getHours() + ((double)(getCommittedDuration().getMinutes()) / 60);
        double maxDuration = getMaxDuration().getHours() + ((double)(getMaxDuration().getMinutes()) / 60);
        double minDuration = getMinDuration().getHours() + ((double)(getMinDuration().getMinutes()) / 60);
        switch (this.getPriority()) {
            case OPTIONAL:
                if (CommittedDuration > maxDuration) {
                    advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.optionalDecreaseAdvice, CommittedDuration - maxDuration);
                }
                else
                {
                    advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.goodActivity, 0);
                }
                break;
            case RECOMMENDED:
                if (CommittedDuration > maxDuration) {
                    advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.recommendedDecreaseAdvice, CommittedDuration - maxDuration);
                } else if (CommittedDuration < minDuration) {
                    advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.recommendedIncreaseAdvice, minDuration - CommittedDuration);
                }
                else{
                    advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.goodActivity, 0);
                }
                break;

            case HIGHLY_RECOMMENDED:
                if (CommittedDuration == 0) {
                    advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.forgetHighlyRecommendAdvice, 0);
                } else {
                    if (CommittedDuration > maxDuration) {
                        advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.highlyRecommendedDecreaseAdvice, CommittedDuration - maxDuration);
                    } else if (CommittedDuration < minDuration) {
                        advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.highlyRecommendedIncreaseAdvice, minDuration - CommittedDuration);
                    }
                    else {
                        advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.goodActivity, 0);
                    }
                }
                break;

            case MANDATORY:
                if (CommittedDuration == 0) {
                    advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.forgetMandatoryAdvice, 0);
                } else {
                    if (CommittedDuration > maxDuration) {
                        advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.mandatoryDecreaseAdvice, CommittedDuration - maxDuration);
                    } else if (CommittedDuration < minDuration) {
                        advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.mandatoryIncreaseAdvice, minDuration - CommittedDuration);
                    }else{
                        advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.goodActivity, 0);
                    }
                }
                break;

            default:
                break;

        }

    }

}
