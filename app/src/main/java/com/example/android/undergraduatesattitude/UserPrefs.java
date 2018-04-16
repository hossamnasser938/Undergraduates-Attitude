package com.example.android.undergraduatesattitude;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

public class UserPrefs {
    static public User user=new User();
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
int wNums=user.getWeeks().size();
        editor.putString(id, user_json);
editor.putInt("wnums",wNums);
for(Week w:user.getWeeks()){
    String week=gson.toJson(w);
    Log.e("Week : "+w.getwNum(),week);
    editor.putString("week"+w.getwNum(),week);
}

        editor.commit();
        editor.apply();


    }

    public void load() {
        String user_json ;
        String id = "" + User.getId();
        user_json = settings.getString(id, "");

        //user =new User();

        user = gson.fromJson(user_json, User.class);
        ArrayList<Week> weeks=new ArrayList<>();
        Week w=new Week();String week;
        int WN=settings.getInt("wnums",0);
        for(int i=0;i<WN;i++) {
            week=settings.getString("week"+i,"");
            w=gson.fromJson(week,Week.class);
            weeks.add(w);
        }
        user.setWeeks(weeks);

        Week.setNum(Week.getNum()-3-WN);
        Log.v("WNum : ",String.valueOf(Week.getNum()));
System.out.println(user);
    }

    public static SharedPreferences getSettings() {
        return settings;
    }
}
