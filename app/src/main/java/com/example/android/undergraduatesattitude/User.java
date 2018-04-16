package com.example.android.undergraduatesattitude;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Hosam on 3/28/2018.
 */

public class User {

    private static final int id=1;
    private String name;
    private String college;
    private int academicYear;
    private String department;
    private ArrayList<Course> courses;
    private ArrayList<Week> weeks;


    public User(){

        setCourses(new ArrayList<Course>());
        setWeeks(new ArrayList<Week>());
        Log.e("WNum",(String.valueOf(Week.getNum())));
        getWeeks().add(new Week());
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Week getCurrentWeek() {
        Log.e("WNum",(String.valueOf(Week.getNum())));
        return getWeeks().get(Week.getNum());
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static int getId() {
        return id;
    }

    public ArrayList<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(ArrayList<Week> weeks) {
        this.weeks = weeks;
    }
}