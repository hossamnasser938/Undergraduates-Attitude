package com.example.android.undergraduatesattitude;


/**
 *
 * @author abdelkhalik
 */
public class Course {

    private String name;
    private ActivityDuration attendanceHours;
    private boolean assignments;
    private boolean finalProject;

    public enum Difficulty {
        EASY,
        MEDIUM,
        DIFFICULT,
    };

    private Difficulty difficulty;

    public Course(String name, ActivityDuration atendanceHours, Difficulty difficulty, boolean assignments, boolean finalProject) {
        this.name = name;
        this.attendanceHours = atendanceHours;
        this.difficulty = difficulty; //error 
        this.assignments = assignments;
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
    public boolean hasAssignments() {
        return assignments;
    }

    /**
     * @param assignments the assigments to set
     */
    public void setAssigments(boolean assignments) {
        this.assignments = assignments;
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
        ActivityDuration totalHomeworkHours = new ActivityDuration(0,0);
        
        switch (difficulty) {
            case EASY:
                totalHomeworkHours = attendanceHours;
                break;
            case MEDIUM:
                totalHomeworkHours = attendanceHours.mulDuration(2);
                break;
            case DIFFICULT:
                totalHomeworkHours = attendanceHours.mulDuration(3);
                break;
            default:
                break;
        }
        
        return totalHomeworkHours;
    }

    static private ActivityDuration courseInfo(Difficulty difficulty, ActivityDuration attendanceHours, boolean assigments, boolean finalProject) {
        ActivityDuration finalProjectDuration = new ActivityDuration(0,0);
        ActivityDuration assignmentsDuration = new ActivityDuration(0,0);

        if (finalProject) {
            switch (difficulty) {
                case EASY:
                    finalProjectDuration = attendanceHours;
                    break;
                case MEDIUM:
                    finalProjectDuration = attendanceHours.mulDuration(2);
                    break;
                case DIFFICULT:
                    finalProjectDuration = attendanceHours.mulDuration(3);
                    break;
                default:
                    break;

            }
            

        }
        if (assigments) {
            switch (difficulty) {
                case EASY:
                    assignmentsDuration = attendanceHours;
                    break;
                case MEDIUM:
                    assignmentsDuration = attendanceHours.mulDuration(2);
                    break;
                case DIFFICULT:
                    assignmentsDuration = attendanceHours.mulDuration(3);
                    break;
                default:
                    break;

            }
            

        }
        return ActivityDuration.addTwoDurations(finalProjectDuration, assignmentsDuration);
    }

    static public ActivityDuration calculateAllCourseHours(Course course){
        ActivityDuration allCourseHours = ActivityDuration.addTwoDurations(courseInfo(course.difficulty, course.attendanceHours, course.assignments, course.finalProject), courseHomework(course.difficulty, course.attendanceHours));
        allCourseHours = ActivityDuration.addTwoDurations(allCourseHours , course.attendanceHours);
        return allCourseHours;
    }

}
