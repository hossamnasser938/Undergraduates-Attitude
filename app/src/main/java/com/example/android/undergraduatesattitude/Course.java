package com.example.android.undergraduatesattitude;

/**
 * Created by Hosam on 3/28/2018.
 */

public class Course {
    private Category category;
    private String attendanceHours;
    private Difficulty difficulty;
    private boolean assignments;
    private boolean finalProject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public Course(Category category, String attendanceHours, Difficulty difficulty, boolean assignments, boolean finalProject) {
        this.category = category;
        this.attendanceHours = attendanceHours;
        this.difficulty = difficulty;
        this.assignments = assignments;
        this.finalProject = finalProject;
    }

    public Course() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAttendanceHours() {
        return attendanceHours;
    }

    public void setAttendanceHours(String attendanceHours) {
        this.attendanceHours = attendanceHours;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isAssignments() {
        return assignments;
    }

    public void setAssignments(boolean assignments) {
        this.assignments = assignments;
    }

    public boolean isFinalProject() {
        return finalProject;
    }

    public void setFinalProject(boolean finalProject) {
        this.finalProject = finalProject;
    }
}
