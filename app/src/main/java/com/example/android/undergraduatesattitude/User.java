package com.example.android.undergraduatesattitude;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Hosam on 3/28/2018.
 */

public class User implements Serializable {

    private String name;
    private String college;
    private int academicYear;
    private String department;
    public ArrayList<Course> courses;
    public ArrayList<Week> weeks;
    static public User user = new User();

    public User(){
        courses = new ArrayList<Course>();
        weeks = new ArrayList<Week>();
        weeks.add(new Week());
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Week getWeek() {
        return weeks.get(Week.getNum());
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

    public void save(Context context) throws IOException {
        FileOutputStream fos = context.openFileOutput("user_file", Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(this);
        os.close();
        fos.close();
    }

    public static void load(Context context) throws IOException, ClassNotFoundException {
        FileInputStream fis = context.openFileInput("user_file");
        ObjectInputStream is = new ObjectInputStream(fis);
        User user = (User) is.readObject();
        is.close();
        fis.close();
        User.user = user;
    }
}