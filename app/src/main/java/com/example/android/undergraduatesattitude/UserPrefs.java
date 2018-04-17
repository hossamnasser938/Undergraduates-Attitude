package com.example.android.undergraduatesattitude;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class UserPrefs {
    static public User user = new User();
    /**
     * This application's preferences label
     */
    Gson gson = new Gson();


    private static final String PREFS_NAME = "com.example.android.undergraduatesattitude.UserPrefs";

    /**
     * This application's preferences
     */

    private static SharedPreferences settings;

    /**
     * This application's settings editor
     */

    private static SharedPreferences.Editor editor;

    /**
     * Constructor takes an android.content.Context argument
     */

    public UserPrefs(Context ctx) {

        if (settings == null) {

            settings = ctx.getSharedPreferences(PREFS_NAME,

                    Context.MODE_PRIVATE);

        }

        /*

         * Get a SharedPreferences editor instance.

         * SharedPreferences ensures that updates are atomic

         * and non-concurrent

         */

        editor = settings.edit();

    }

    public void save() {
        String user_json = gson.toJson(user);
        String id = "" + User.getId(); // get storage key
        int wNums = user.getWeeks().size();
        editor.putString(id, user_json);
        editor.putInt("wnums", wNums);
        for (Week w : user.getWeeks()) {
            String week = gson.toJson(w);
            Log.e("Week : " + w.getwNum(), week);
            editor.putString("week" + w.getwNum(), week);
        }
        String edu = gson.toJson(KnowledgeBase.getEducational());
        editor.putString("edu", edu);

        //Hosam
        String eduCat = gson.toJson(KnowledgeBase.getEducationalCat());
        editor.putString("eduCat", eduCat);

        String optActList = gson.toJson(KnowledgeBase.getOptimalActivityList());
        editor.putString("optActList", optActList);

        String optActs = gson.toJson(KnowledgeBase.getOptimalActivities());
        editor.putString("optActs", optActs);
        //

        editor.commit();
        editor.apply();


    }

    public void load() {
        String user_json;
        String id = "" + User.getId();
        user_json = settings.getString(id, "");

        //user =new User();

        user = gson.fromJson(user_json, User.class);
        ArrayList<Week> weeks = new ArrayList<>();
        Week w = new Week();
        String week;
        int WN = settings.getInt("wnums", 0);
        for (int i = 0; i < WN; i++) {
            week = settings.getString("week" + i, "");
            w = gson.fromJson(week, Week.class);
            weeks.add(w);
        }
        user.setWeeks(weeks);

        Week.setNum(Week.getNum() - 3 - WN);
        String edu = settings.getString("edu", "");
        ArrayList<String> e = gson.fromJson(edu, new TypeToken<ArrayList<String>>() {
        }.getType());
        KnowledgeBase.setEducational(e);

        //Hosam
        String eduCat = settings.getString("eduCat", "");
        OptimalCategory ec = gson.fromJson(eduCat, new TypeToken<OptimalCategory>() {
        }.getType());
        KnowledgeBase.setEducationalCat(ec);

        String optActList = settings.getString("optActList", "");
        ArrayList<String> oal = gson.fromJson(optActList, new TypeToken<ArrayList<String>>() {
        }.getType());
        KnowledgeBase.setOptimalActivityList(oal);

        String optActs = settings.getString("optActs", "");
        ArrayList<OptimalActivity> oas = gson.fromJson(optActs, new TypeToken<ArrayList<OptimalActivity>>() {
        }.getType());
        KnowledgeBase.setOptimalActivities(oas);
        //
    }

    public static SharedPreferences getSettings() {
        return settings;
    }
}
