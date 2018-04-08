package com.example.android.undergraduatesattitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class CreateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
    }

    public void signUpUser() {
        EditText name = findViewById(R.id.Name);
        EditText department = findViewById(R.id.Department);
        EditText college = findViewById(R.id.College);
        EditText academicYear = findViewById(R.id.Academic_Year);
        User user = new User();
        user.setName(name.getText().toString());
        user.setCollege(college.getText().toString());
        user.setDepartment(department.getText().toString());
        user.setAcademicYear(Integer.parseInt(academicYear.getText().toString()));
        try {
            user.save(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToSubMainLayout(View view){
        Intent intent = new Intent(getApplicationContext() , SubMainActivity.class);
        startActivity(intent);
    }

}
