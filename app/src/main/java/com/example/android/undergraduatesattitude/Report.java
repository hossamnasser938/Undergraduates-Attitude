package com.example.android.undergraduatesattitude;



import java.util.ArrayList;

public class Report{

    public static final int WEEK_HOURS = 168;
    private double allCommittedHours;
    private int allRemainingHours;
    private boolean overflowed;
    private int allOverflowedHours;
    private ArrayList<CommittedCategory> committedCategories;
    private int overallPercentage;
    private String weekAdvice;

    public Report(){
        committedCategories = new ArrayList<>();
        for(OptimalCategory oc : KnowledgeBase.optimalCategories){
            committedCategories.add(new CommittedCategory(oc.getCategory(), new ActivityDuration(0, 0)));
        }
    }

   

    public double getAllCommittedHours() {
        return allCommittedHours;
    }

    public void addToAllCommittedHours(double allCommittedHours) {
        this.allCommittedHours += allCommittedHours;
    }

    public int getAllRemainingHours() {
        return allRemainingHours;
    }

    public void setAllRemainingHours(int allRemainingHours) {
        this.allRemainingHours = allRemainingHours;
    }

    public boolean isOverflowed() {
        return overflowed;
    }

    public void setOverflowed(boolean overflowed) {
        this.overflowed = overflowed;
    }

    public int getAllOverflowedHours() {
        return allOverflowedHours;
    }

    public void setAllOverflowedHours(int allOverflowedHours) {
        this.allOverflowedHours = allOverflowedHours;
    }

    public ArrayList<CommittedCategory> getCommittedCategories() {
        return committedCategories;
    }

    public void setCommittedCategories(ArrayList<CommittedCategory> committedCategories) {
        this.committedCategories = committedCategories;
    }

    public int getOverallPercentage(){
        calculateOverallPercentage();
        return overallPercentage;
    }

    private void calculateOverallPercentage(){
        int percentage = 0;
        int i = 0;
        for(CommittedCategory cc : getCommittedCategories()){
            percentage += cc.getPercentage();
            i++;
        }
        overallPercentage = percentage / i;
    }

    /**
     * @return the weekAdvice
     */
    public String getWeekAdvice() {
        generateWeekAdvice();
        return weekAdvice;
    }

    /**
     * @param weekAdvice the weekAdvice to set
     */
    public void setWeekAdvice(String weekAdvice) {
        this.weekAdvice = weekAdvice;
    }

    public void generateWeekAdvice(){
        if (allCommittedHours > WEEK_HOURS) {
            weekAdvice = KnowledgeBase.generateAdviceForm(KnowledgeBase.overflowWeekHours, allCommittedHours);
        } else{
            weekAdvice = KnowledgeBase.generateAdviceForm(KnowledgeBase.underflowWeekHours, allCommittedHours);
            if(allCommittedHours == 0){
                weekAdvice += "0 hours";
            }
        }
    }
}
