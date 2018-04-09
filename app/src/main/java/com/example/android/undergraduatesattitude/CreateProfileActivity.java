package com.example.android.undergraduatesattitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        User.user.setName(name.getText().toString());
        User.user.setCollege(college.getText().toString());
        User.user.setDepartment(department.getText().toString());
        User.user.setAcademicYear(Integer.parseInt(academicYear.getText().toString()));
        try {
            User.user.save(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToSubMainLayout(View view){
        signUpUser();
        Toast.makeText(getApplicationContext(), "Profile Created", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext() , SubMainActivity.class);
        startActivity(intent);
    }

}
