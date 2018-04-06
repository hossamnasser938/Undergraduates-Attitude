
package com.example.android.undergraduatesattitude;


/**
 *
 * @author abdelkhalik
 */
public class Course {

    private final Category category;
    private String name;
    private ActivityDuration attendanceHours;
    private boolean assigments;
    private boolean finalProject;

    public enum Difficulty {
        EASY,
        MEDIUM,
        DIFFICULT,
    };
    Difficulty difficulty;

    public Course(Category category, String name, ActivityDuration atendanceHours, Difficulty difficulty, boolean assigments, boolean finalProject) {
        this.category = category;
        this.name = name;
        this.attendanceHours = atendanceHours;
        this.difficulty = difficulty; //error 
        this.assigments = assigments;
        this.finalProject = finalProject;

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

    static private ActivityDuration courseHomework(Difficulty difficulty, ActivityDuration attendanceHours) {
        ActivityDuration totalHomeworkHours = null;
        int courseHourse = attendanceHours.getHours() + ((attendanceHours.getMinutes()) / 60);
        int courseHomeworkHours = 0;
        switch (difficulty) {
            case EASY:
                courseHomeworkHours = courseHourse * 1;
                break;
            case MEDIUM:
                courseHomeworkHours = courseHourse * 2;
                break;
            case DIFFICULT:
                courseHomeworkHours = courseHourse * 3;
                break;
            default:
                break;
        }
        totalHomeworkHours.setHours(courseHomeworkHours);
        totalHomeworkHours.setMinutes(0);
        return totalHomeworkHours;
    }

    static private ActivityDuration courseInf(Difficulty difficulty, ActivityDuration attendanceHours, boolean assigments, boolean finalProject) {
        ActivityDuration totalCourseInfo = null;
        int courseHourse = attendanceHours.getHours() + ((attendanceHours.getMinutes()) / 60);
        int courseHomeworkHours = 0;
        if (finalProject == true) {
            switch (difficulty) {
                case EASY:
                    courseHomeworkHours = courseHourse * 1;
                    break;
                case MEDIUM:
                    courseHomeworkHours = courseHourse * 2;
                    break;
                case DIFFICULT:
                    courseHomeworkHours = courseHourse * 3;
                    break;
                default:
                    break;

            }
            totalCourseInfo.setHours(courseHomeworkHours);
            totalCourseInfo.setMinutes(0);

        }
        if (assigments == true) {
            switch (difficulty) {
                case EASY:
                    courseHomeworkHours = courseHourse * 1;
                    break;
                case MEDIUM:
                    courseHomeworkHours = courseHourse * 2;
                    break;
                case DIFFICULT:
                    courseHomeworkHours = courseHourse * 3;
                    break;
                default:
                    break;

            }
            totalCourseInfo.setHours(courseHomeworkHours);
            totalCourseInfo.setMinutes(0);

        }
        return totalCourseInfo;
    }

    

}
