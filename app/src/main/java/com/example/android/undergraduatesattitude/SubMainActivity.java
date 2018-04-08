package com.example.android.undergraduatesattitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SubMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
    }

    public void navigateToAddCourseActivity(View view){
        Intent intent = new Intent(getApplicationContext(), AddCourseActivity.class);
        startActivity(intent);
    }

    public void navigateToAddActivityActivity(View view){
        Intent intent = new Intent(getApplicationContext(), AddActivityActivity.class);
        startActivity(intent);
    }

    public void navigateToReportActivity(View view){
        Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
        startActivity(intent);
    }
}
