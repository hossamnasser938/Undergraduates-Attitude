package com.example.android.undergraduatesattitude;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class UserPrefs {
    /** This application's preferences label */
    Gson gson = new Gson();

    String user_json = gson.toJson(User.user);
    private static final String PREFS_NAME = "com.example.android.undergraduatesattitude.UserPrefs";

    /** This application's preferences */

    private static SharedPreferences settings;

    /** This application's settings editor*/

    private static SharedPreferences.Editor editor;

    /** Constructor takes an android.content.Context argument*/

    public UserPrefs(Context ctx){

        if(settings == null){

            settings = ctx.getSharedPreferences(PREFS_NAME,

                    Context.MODE_PRIVATE );

        }

        /*

         * Get a SharedPreferences editor instance.

         * SharedPreferences ensures that updates are atomic

         * and non-concurrent

         */

        editor = settings.edit();

    }
    public void save(){
        String id =  "" +  User.getId(); // get storage key

        editor.putString(id, user_json);

        editor.commit();


    }
    public void load(){
        String id =  "" +  User.getId();
        user_json = settings.getString(id, "");

        User.user  = gson.fromJson(user_json, User.class);

    }
}
