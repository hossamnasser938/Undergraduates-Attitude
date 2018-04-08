package com.example.android.undergraduatesattitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        Toast.makeText(getApplicationContext(), "Still waiting for work to complete", Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
        //startActivity(intent);
    }

    public void navigateToCompare(View view){
        Toast.makeText(getApplicationContext(), "Not implemented Yet", Toast.LENGTH_LONG).show();
    }

    public void navigateToShow(View view){
        Toast.makeText(getApplicationContext(), "Not implemented Yet", Toast.LENGTH_LONG).show();
    }
}
