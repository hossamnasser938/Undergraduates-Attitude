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

        Report report = User.user.getCurrentWeek().getReport();
        double CommittedDuration = this.getCommittedDuration().getHours() + ((this.getCommittedDuration().getMinutes()) / 60);
        double maxDuration = this.getMaxDuration().getHours() + ((this.getMaxDuration().getMinutes()) / 60);
        double minDuration = this.getMinDuration().getHours() + ((this.getMinDuration().getMinutes()) / 60);
        int allCommittedHours = report.getAllCommitedHours();
        switch (this.getPriority()) {
            case OPTIONAL:
                if (CommittedDuration > maxDuration) {
                    advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.optionalDecreaseAdvice, CommittedDuration - maxDuration);

                }

                break;
            case RECOMMENDED:
                if (CommittedDuration == 0) {
                    advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.forgetHighlyRecommendAdvice, 0);
                } else {
                    if (CommittedDuration > maxDuration) {
                        advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.recommendedDecreaseAdvice, CommittedDuration - maxDuration);
                    } else if (CommittedDuration < minDuration) {
                        advice = KnowledgeBase.generateAdviceForm(KnowledgeBase.recommendedIncreaseAdvice, minDuration - CommittedDuration);
                    }
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
                    }
                }
                break;

            default:
                break;

        }

        if (allCommittedHours > Report.WEEK_HOURS) {
            report.setTotalNumberHoursAdvice(KnowledgeBase.generateAdviceForm(KnowledgeBase.overflowWeekHours, allCommittedHours));
        } else{
            report.setTotalNumberHoursAdvice(KnowledgeBase.generateAdviceForm(KnowledgeBase.underflowWeekHours, allCommittedHours));
        }

    }

}
