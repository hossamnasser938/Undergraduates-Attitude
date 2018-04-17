package com.example.android.undergraduatesattitude;


import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author abdelkhalik
 */
public class KnowledgeBase {


    /*
    Advices Forms
     */
    static final String overflowWeekHours = "The total number of hours in a week is " + Report.WEEK_HOURS + " , How could you commit ";
    static final String underflowWeekHours = "The total number of hours in a week is " + Report.WEEK_HOURS + " , and you just committed ";
    static final String goodActivity = "You have committed a sufficient number of hours in this activity. Keep Up";
    static final String optionalDecreaseAdvice = "You have committed too many hours in this optional activity and you have to decrease it by ";
    static final String recommendedDecreaseAdvice = "It is recommended to decrease the number of hours you committed to this activity by ";
    static final String recommendedIncreaseAdvice = "It is recommended to increase the number of hours you committed to this activity by ";
    static final String highlyRecommendedDecreaseAdvice = "It is highly recommended to decrease the number of hours you committed to this activity by ";
    static final String highlyRecommendedIncreaseAdvice = "It is highly recommended to increase the number of hours you committed to this activity by ";
    static final String mandatoryDecreaseAdvice = "It is mandatory to decrease the number of hours you committed to this activity by ";
    static final String mandatoryIncreaseAdvice = "It is mandatory to increase the number of hours you committed to this activity by ";
    static final String forgetHighlyRecommendAdvice = "You either forgot to do or to add the number of hours you committed to this highly recommended activity";
    static final String forgetMandatoryAdvice = "Certainly You have forgotten to add the number of hours you committed to this mandatory activity";


    /*
    Categories Activities Lists
     */
    static public final String[] healthyList = {"Sleeping", "Sports"};
    static public final ArrayList<String> Healthy = new ArrayList<>(Arrays.asList(healthyList));
    static public final String[] lifeList = {"HouseHold", "Eating and Drinking", "Purchasing goods and services", "Transportation", "Religious and Spiritual Activities"};
    static public final ArrayList<String> Life = new ArrayList<>(Arrays.asList(lifeList));
    static public ArrayList<String> Educational = new ArrayList<>();
    static public final String[] responsList = {"Planning", "Volunteerism", "Socializing and communicating", "Telephone call and e-mails"};
    static public final ArrayList<String> Responsibility = new ArrayList<>(Arrays.asList(responsList));
    static public final String[] entertainmentList = {"Hobby", "Social Media", "Leisure"};
    static public final ArrayList<String> Entertainment = new ArrayList<>(Arrays.asList(entertainmentList));
    static public final String[] skillsList = {"Language Acquisition", "Teaching", "Writing", "Reading"};
    static public final ArrayList<String> Skills = new ArrayList<>(Arrays.asList(skillsList));

    /*
    Optimal Activities
     */
    static public final OptimalActivity sleeping = new OptimalActivity(Category.HEALTH, "Sleeping", new ActivityDuration(56, 0), new ActivityDuration(42, 0), OptimalActivity.Priority.MANDATORY);
    static public final OptimalActivity sports = new OptimalActivity(Category.HEALTH, "Sports", new ActivityDuration(7, 0), new ActivityDuration(3, 30), OptimalActivity.Priority.HIGHLY_RECOMMENDED);
    static public final OptimalActivity houseHold = new OptimalActivity(Category.LIFE, "HouseHold", new ActivityDuration(14, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    static public final OptimalActivity eatingAndDrinking = new OptimalActivity(Category.LIFE, "Eating and Drinking", new ActivityDuration(10, 30), new ActivityDuration(7, 0), OptimalActivity.Priority.MANDATORY);
    static public final OptimalActivity purchasingGoodsAndServices = new OptimalActivity(Category.LIFE, "Purchasing goods and services", new ActivityDuration(3, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    static public final OptimalActivity transportation = new OptimalActivity(Category.LIFE, "Transportation", new ActivityDuration(21, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    static public final OptimalActivity religiousAndSpiritualActivities = new OptimalActivity(Category.LIFE, "Religious and Spiritual Activities", new ActivityDuration(28, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    static public final OptimalActivity planning = new OptimalActivity(Category.RESPONSIBILITY, "Planning", new ActivityDuration(2, 0), new ActivityDuration(1, 0), OptimalActivity.Priority.HIGHLY_RECOMMENDED);
    static public final OptimalActivity volunteerism = new OptimalActivity(Category.RESPONSIBILITY, "Volunteerism", new ActivityDuration(6, 0), new ActivityDuration(3, 0), OptimalActivity.Priority.RECOMMENDED);
    static public final OptimalActivity socializingAndCommunicating = new OptimalActivity(Category.RESPONSIBILITY, "Socializing and communicating", new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.MANDATORY);
    static public final OptimalActivity telephoneCallsAndEMails = new OptimalActivity(Category.RESPONSIBILITY, "Telephone call and e-mails", new ActivityDuration(3, 0), new ActivityDuration(2, 0), OptimalActivity.Priority.RECOMMENDED);
    static public final OptimalActivity hobby = new OptimalActivity(Category.ENTERTAINMENT, "Hobby", new ActivityDuration(5, 0), new ActivityDuration(3, 0), OptimalActivity.Priority.RECOMMENDED);
    static public final OptimalActivity socialMedia = new OptimalActivity(Category.ENTERTAINMENT, "Social Media", new ActivityDuration(4, 0), new ActivityDuration(2, 0), OptimalActivity.Priority.RECOMMENDED);
    static public final OptimalActivity leisure = new OptimalActivity(Category.ENTERTAINMENT, "Leisure", new ActivityDuration(4, 0), new ActivityDuration(2, 0), OptimalActivity.Priority.RECOMMENDED);
    static public final OptimalActivity languageAcquisition = new OptimalActivity(Category.SKILLS, "Language Acquisition", new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.HIGHLY_RECOMMENDED);
    static public final OptimalActivity teaching = new OptimalActivity(Category.SKILLS, "Teaching", new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.OPTIONAL);
    static public final OptimalActivity writing = new OptimalActivity(Category.SKILLS, "Writing", new ActivityDuration(7, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    static public final OptimalActivity reading = new OptimalActivity(Category.SKILLS, "Reading", new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.HIGHLY_RECOMMENDED);


    /*
    Optimal Categories
     */
    static public final OptimalCategory HealthtCat = new OptimalCategory(Category.HEALTH,new ActivityDuration(63, 0), new ActivityDuration(42, 0));
    static public final OptimalCategory LifeCat = new OptimalCategory(Category.LIFE, new ActivityDuration(73, 0),new ActivityDuration(0, 0));
    private static OptimalCategory EducationalCat = new OptimalCategory(Category.EDUCATIONAL, new ActivityDuration(0, 0),new ActivityDuration(0, 0));
    static public final OptimalCategory ResponsibilityCat = new OptimalCategory(Category.RESPONSIBILITY,new ActivityDuration(25, 0), new ActivityDuration(13, 0));
    static public final OptimalCategory EntertainmentCat = new OptimalCategory(Category.ENTERTAINMENT, new ActivityDuration(14, 0), new ActivityDuration(7, 0));
    static public final OptimalCategory SkillsCat = new OptimalCategory(Category.SKILLS, new ActivityDuration(42, 0), new ActivityDuration(14, 0));


    /*
    ArrayList of all categories
     */
    static public final ArrayList<String> optimalCategoryList = new ArrayList<>(Arrays.asList("EDUCATIONAL","HEALTH","LIFE","RESPONSIBILITY","ENTERTAINMENT","SKILLS"));
    static public final ArrayList<OptimalCategory> optimalCategories = new ArrayList<>(Arrays.asList(EducationalCat,HealthtCat,LifeCat,ResponsibilityCat,EntertainmentCat,SkillsCat));


    /*
    ArrayList of all activities
     */
    private static ArrayList<String> optimalActivityList = new ArrayList<>(Arrays.asList("Sleeping", "Sports","HouseHold", "Eating and Drinking", "Purchasing goods and services", "Transportation", "Religious and Spiritual Activities", "Planning", "Volunteerism", "Socializing and communicating", "Telephone call and e-mails", "Hobby","Social Media","Leisure","Language Acquisition", "Teaching", "Writing", "Reading"));
    private static ArrayList<OptimalActivity> optimalActivities = new ArrayList<>(Arrays.asList(sleeping, sports, houseHold, eatingAndDrinking, purchasingGoodsAndServices, transportation, religiousAndSpiritualActivities, planning, volunteerism, socializingAndCommunicating, telephoneCallsAndEMails, hobby, socialMedia, leisure, languageAcquisition, teaching, writing, reading));


    /*
    ArrayList of all Courses activities
     */
    static public ArrayList<String> courseActivities = new ArrayList<>(Arrays.asList("Attendance", "Homework", "Assignments", "Final Project"));


    /*
    Methods
     */

    static public ActivityDuration getActivityOptimalMaxDuration(String name){
        return getOptimalActivities().get(getOptimalActivityList().indexOf(name)).getMaxDuration();

    }


    static public ActivityDuration getActivityOptimalMinDuration(String name){
        return getOptimalActivities().get(getOptimalActivityList().indexOf(name)).getMinDuration();
    }


    static public ActivityDuration getCategoryOptimalMaxDuration(String name){
        return optimalCategories.get(optimalCategoryList.indexOf(name)).getMaxDuration();
    }


    static public ActivityDuration getCategoryOptimalMinDuration(String name){
        return optimalCategories.get(optimalCategoryList.indexOf(name)).getMinDuration();
    }


    public static OptimalActivity.Priority getActivityPriority(String activityName){
        for(OptimalActivity activity : getOptimalActivities()){
            if(activity.getName().equals(activityName)){
                return activity.getPriority();
            }
        }
        return OptimalActivity.Priority.OPTIONAL;
    }


    static public void createCourseActivity(Course course){
        Educational.add(course.getName());
        OptimalActivity courseActivity = new OptimalActivity(Category.EDUCATIONAL, course.getName(), Course.calculateAllCourseHours(course), Course.calculateAllCourseHours(course), OptimalActivity.Priority.MANDATORY);
        getEducationalCat().setMaxDuration(ActivityDuration.addTwoDurations(getEducationalCat().getMaxDuration(), courseActivity.getMaxDuration()));
        getEducationalCat().setMinDuration(ActivityDuration.addTwoDurations(getEducationalCat().getMinDuration(), courseActivity.getMinDuration()));
        UserPrefs.user.getCurrentWeek().getReport().getCommittedCategories().get(0).setMaxDuration(getEducationalCat().getMaxDuration());
        UserPrefs.user.getCurrentWeek().getReport().getCommittedCategories().get(0).setMinDuration(getEducationalCat().getMinDuration());
        getOptimalActivityList().add(course.getName());
        getOptimalActivities().add(courseActivity);
        UserPrefs.user.getCurrentWeek().getReport().getCommittedCategories().get(0).getCommittedActivities().add(new CommittedActivity(Category.EDUCATIONAL, course.getName(), new ActivityDuration(0, 0)));
    }


    static public String generateAdviceForm(String form, double committedHours){
        if(committedHours == 0){
            return form;
        }
        else{
            int hours = (int) committedHours;
            int minutes = (int) ((committedHours - hours) * 60);
            return form + hours + " hours" + " and " + minutes + " minutes";
        }
    }

    public static ArrayList<String> getEducational() {
        return Educational;
    }

    public static void setEducational(ArrayList<String> educational) {
        Educational = educational;
    }

    public static OptimalCategory getEducationalCat() {
        return EducationalCat;
    }

    public static void setEducationalCat(OptimalCategory educationalCat) {
        EducationalCat = educationalCat;
    }

    public static ArrayList<String> getOptimalActivityList() {
        return optimalActivityList;
    }

    public static void setOptimalActivityList(ArrayList<String> optimalActivityList) {
        KnowledgeBase.optimalActivityList = optimalActivityList;
    }

    public static ArrayList<OptimalActivity> getOptimalActivities() {
        return optimalActivities;
    }

    public static void setOptimalActivities(ArrayList<OptimalActivity> optimalActivities) {
        KnowledgeBase.optimalActivities = optimalActivities;
    }
}
