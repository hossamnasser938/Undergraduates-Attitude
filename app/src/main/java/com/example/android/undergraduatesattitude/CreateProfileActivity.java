package com.example.android.undergraduatesattitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    public boolean signUpUser() {

        EditText name = findViewById(R.id.Name);
        EditText department = findViewById(R.id.Department);
        EditText college = findViewById(R.id.College);
        EditText academicYear = findViewById(R.id.Academic_Year);

        if(name.getText().toString().matches("") || college.getText().toString().isEmpty() || department.getText().toString().isEmpty() || academicYear.getText().toString().isEmpty()){
            return false;
        }

        UserPrefs.user.setName(name.getText().toString());
        UserPrefs.user.setCollege(college.getText().toString());
        UserPrefs.user.setDepartment(department.getText().toString());
        UserPrefs.user.setAcademicYear(Integer.parseInt(academicYear.getText().toString()));

        MainActivity.prefs =new UserPrefs(getApplicationContext());
        MainActivity.prefs.save();

        return true;
      
    }

    public void navigateToSubMainLayout(View view){
        if(signUpUser()){
            Toast.makeText(getApplicationContext(), "Profile Created", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext() , SubMainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Please, fill all fields", Toast.LENGTH_SHORT).show();
        }

    }

}
