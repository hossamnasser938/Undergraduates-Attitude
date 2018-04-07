package com.example.android.undergraduatesattitude;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author abdelkhalik
 */
public class Week {

    private Date startDate;
    private Date endDate;
    ArrayList<Activity> activity = new ArrayList<Activity>();
    //Report report = new Report();

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /*public Report getReport() {
        return report;
    }*/

}
