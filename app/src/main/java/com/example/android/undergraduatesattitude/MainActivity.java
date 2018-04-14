package com.example.android.undergraduatesattitude;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static UserPrefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String id = "" + User.getId();
        super.onCreate(savedInstanceState);

        prefs = new UserPrefs(getApplicationContext());
        
        if (UserPrefs.getSettings().contains(id)) {
            Toast.makeText(getApplicationContext(), "Found", Toast.LENGTH_SHORT).show();

            prefs.load();
            setContentView(R.layout.activity_sub_main);
        } else {
            Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
        }
      
        setContentView(R.layout.activity_main);

    }

    public void navigateToCreateProfile(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateProfileActivity.class);
        startActivity(intent);
    }

}
