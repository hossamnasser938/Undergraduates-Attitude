package com.example.android.undergraduatesattitude;

/**
 * Created by Hosam on 3/28/2018.
 */

public class Course {
  private ActivityDuration attendanceHours = new ActivityDuration();
    private String name;
    private boolean assigments;
    private boolean finalProject;
    private final Category category;
    public enum difficulty
    {
        EASY ,
        MEDIUM ,
        DIFFICULT ,
    };
    public enum Category 
    {
        HEALTH,
        LIFE,
        EDUCATIONAL,
        RESPONSIBILITY,
        ENTERTAINMENT,
        SKILLS,
    };
    
    public Course(Category category){
        this.category=category;
    }
    /**
     * @return the attendanceHours
     */
    public ActivityDuration getAttendanceHours() {
        return attendanceHours;
    }

    /**
     * @param attendanceHours the attendanceHours to set
     */
    public void setAttendanceHours(ActivityDuration attendanceHours) {
        this.attendanceHours = attendanceHours;
    }
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
   
    /**
     * @return the assigments
     */
    public boolean hasAssigments() {
        return assigments;
    }

    /**
     * @param assigments the assigments to set
     */
    public void setAssigments(boolean assigments) {
        this.assigments = assigments;
    }

    /**
     * @return the finalProject
     */
    public boolean hasFinalProject() {
        return finalProject;
    }

    /**
     * @param finalProject the finalProject to set
     */
    public void setFinalProject(boolean finalProject) {
        this.finalProject = finalProject;
    }
}
