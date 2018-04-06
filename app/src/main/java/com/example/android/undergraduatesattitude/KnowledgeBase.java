package com.example.android.undergraduatesattitude;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author abdelkhalik
 */
public class KnowledgeBase {

    OptimalActivity optimalActivity;
    /*static String[] OptimalActivityList ={"Sleeping","Sports","HouseHold","Eating and Drinking",
        "Purchasing goods and services","Transportation","Religious and Spiritual Activities",
        "Course Attendance","Course Homework","Project ","Assignment","Research",
        "Planning","Volunteerism","Socializing and communicating","Telephone calls, mail, and e-mail",
        "Hobby","Social Media","Leisure","Language Acquisition","Teaching","Writing","Reading"};
     */
    static public final String[] healthyList = {"Sleeping", "Sports"};
    static public final ArrayList<String> Healthy = new ArrayList<>(Arrays.asList(healthyList));
    static public final String[] lifeList = {"HouseHold", "Eating and Drinking",
        "Purchasing goods and services", "Transportation", "Religious and Spiritual Activities"};
    static public final ArrayList<String> Life = new ArrayList<>(Arrays.asList(lifeList));
    static public final String[] eduList = {"Course Attendance", "Course Homework", "Project ", "Assignment", "Research"};
    static public final ArrayList<String> Educational = new ArrayList<>(Arrays.asList(eduList));
    static public final String[] responsList = {"Planning", "Volunteerism", "Socializing and communicating", "Telephone calls, mail, and e-mail"};
    static public final ArrayList<String> Responsibility = new ArrayList<>(Arrays.asList(responsList));
    static public final String[] entertainmentList = {"Hobby", "Social Media", "Leisure"};
    static public final ArrayList<String> Entertainment = new ArrayList<>(Arrays.asList(entertainmentList));
    static public final String[] skillsList = {"Language Acquisition", "Teaching", "Writing", "Reading"};
    static public final ArrayList<String> Skills = new ArrayList<>(Arrays.asList(skillsList));

    //===============================================================================================
    OptimalActivity sleeping = new OptimalActivity("Sleeping", Category.HEALTH, new ActivityDuration(56, 0), new ActivityDuration(42, 0), OptimalActivity.Priority.MANDATORY);
    OptimalActivity sports = new OptimalActivity("sports", Category.HEALTH, new ActivityDuration(7, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.RECOMMENDED);
    OptimalActivity houseHold = new OptimalActivity("HouseHould", Category.LIFE, new ActivityDuration(14, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    OptimalActivity eatingAndDrinking = new OptimalActivity("Eating and Drinking", Category.LIFE, new ActivityDuration(7, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.MANDATORY);
    OptimalActivity purchasingGoodsAndServices = new OptimalActivity("Purchasing goods and services", Category.LIFE, new ActivityDuration(3, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    OptimalActivity transportation = new OptimalActivity("Transportation", Category.LIFE, new ActivityDuration(21, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    OptimalActivity religiousAndSpiritualActivities = new OptimalActivity("Religious and Spiritual Activities", Category.LIFE, new ActivityDuration(28, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    //OptimalActivity courseAttendance = new OptimalActivity("Course Attendance", Category.EDUCATIONAL,5,5, OptimalActivity.Priority.MANDATORY);
    //OptimalActivity courseHomework = new OptimalActivity("Course Homework", Category.EDUCATIONAL,5,5, OptimalActivity.Priority.MANDATORY);
    //OptimalActivity project = new OptimalActivity("Project", Category.EDUCATIONAL, 77, OptimalActivity.Priority.OPTIONAL);
    //OptimalActivity assignment = new OptimalActivity("Assignment", Category.EDUCATIONAL,77, OptimalActivity.Priority.OPTIONAL);
    //OptimalActivity research = new OptimalActivity("Research", Category.EDUCATIONAL,77, OptimalActivity.Priority.OPTIONAL);
    OptimalActivity planning = new OptimalActivity("Planning", Category.RESPONSIBILITY, new ActivityDuration(2, 0), new ActivityDuration(1, 0), OptimalActivity.Priority.RECOMMENDED);
    OptimalActivity volunteerism = new OptimalActivity("Volunteerism", Category.RESPONSIBILITY, new ActivityDuration(6, 0), new ActivityDuration(3, 0), OptimalActivity.Priority.RECOMMENDED);
    OptimalActivity socializingAndCommunicating = new OptimalActivity("Socializing and communicating", Category.EDUCATIONAL, new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.MANDATORY);
    OptimalActivity telephoneAndallsAndMail = new OptimalActivity("Telephone calls, mail and e-mail ", Category.RESPONSIBILITY, new ActivityDuration(3, 0), new ActivityDuration(2, 0), OptimalActivity.Priority.RECOMMENDED);
    OptimalActivity hobby = new OptimalActivity("Hobby", Category.ENTERTAINMENT, new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.RECOMMENDED);
    OptimalActivity socialMedia = new OptimalActivity("Social Media", Category.ENTERTAINMENT, new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.RECOMMENDED);
    OptimalActivity leisure = new OptimalActivity("Leisure", Category.ENTERTAINMENT, new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.RECOMMENDED);
    OptimalActivity languageAcquisition = new OptimalActivity("Language Acquisition", Category.SKILLS, new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.OPTIONAL);
    OptimalActivity teaching = new OptimalActivity("Teaching", Category.SKILLS, new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.OPTIONAL);
    OptimalActivity writing = new OptimalActivity("Writing", Category.SKILLS, new ActivityDuration(7, 0), new ActivityDuration(0, 0), OptimalActivity.Priority.OPTIONAL);
    OptimalActivity reading = new OptimalActivity("Reading", Category.SKILLS, new ActivityDuration(14, 0), new ActivityDuration(7, 0), OptimalActivity.Priority.RECOMMENDED);

    //=====================================================================================
    ArrayList<OptimalActivity> optimalActivities = new ArrayList<>(Arrays.asList(sleeping, sports, houseHold, eatingAndDrinking, purchasingGoodsAndServices, transportation,
            religiousAndSpiritualActivities, planning, volunteerism, socializingAndCommunicating, telephoneAndallsAndMail, hobby, socialMedia,
             leisure, languageAcquisition, teaching, writing, reading));

}
