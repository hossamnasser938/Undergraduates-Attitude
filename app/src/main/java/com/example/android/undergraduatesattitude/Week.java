package com.example.android.undergraduatesattitude;


import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author abdelkhalik
 */
public class Week {

    private static int num=-1;
    private int wNum;
    private Date startDate;
    private Date endDate;
    private Report report;

    public Week() {
        report = new Report();
        num++;
        Log.e("WNUM : ",String.valueOf(num));
        wNum=num;

    }

    public static void setNum(int num) {
        Week.num = num;
    }

    public int getwNum(){
        return wNum;
}
    public static int getNum() {
        return num;
    }

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

    public Report getReport() {
        return report;
    }


}
