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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        UserPrefs prefs =new UserPrefs(getApplicationContext());
        prefs.load();
        */

    }

    public void navigateToCreateProfile(View view){
        Intent intent = new Intent(getApplicationContext() , CreateProfileActivity.class);
        startActivity(intent);
    }

}
