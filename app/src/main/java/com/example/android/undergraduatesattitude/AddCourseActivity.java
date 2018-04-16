package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class AddCourseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        Spinner difficultySpinner = (Spinner) findViewById(R.id.difficulty_spinner);

        ArrayList<String> difficultySpinnerList = new ArrayList<>();
        difficultySpinnerList.add("Anticipate Difficulty Level");
        difficultySpinnerList.add("EASY");
        difficultySpinnerList.add("MEDIUM");
        difficultySpinnerList.add("DIFFICULT");
        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, difficultySpinnerList);
        difficultyAdapter.setDropDownViewResource(R.layout.spinner_item);
        difficultySpinner.setAdapter(difficultyAdapter);
    }

    public void notifyCourseAdded(View view) {
        if (addCourse()) {
            Toast.makeText(getApplicationContext(), "Course Added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please, fill Required fields", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean addCourse() {
        Spinner difficulty = findViewById(R.id.difficulty_spinner);
        EditText name = findViewById(R.id.Name);
        EditText hours = findViewById(R.id.Hours);
        EditText minutes = findViewById(R.id.Minutes);
        CheckBox assignments = findViewById(R.id.Assignments);
        CheckBox finalProject = findViewById(R.id.Final_Project);

        if (difficulty.getSelectedItem().equals("Anticipate Difficulty Level") || name.getText().toString().matches("")) {
            return false;
        }

        if (hours.getText().toString().matches("") && minutes.getText().toString().matches("")) {
            return false;
        }

        if (hours.getText().toString().matches("")) {
            hours.setText("0");
        }

        if (minutes.getText().toString().matches("")) {
            minutes.setText("0");
        }

        Course.Difficulty difficulty1 = Course.Difficulty.valueOf(difficulty.getSelectedItem().toString());

        Course c = new Course(name.getText().toString(), new ActivityDuration(Integer.parseInt(hours.getText().toString()), Integer.parseInt(minutes.getText().toString())), difficulty1, assignments.isChecked(), finalProject.isChecked());
        UserPrefs.user.getCourses().add(c);
        KnowledgeBase.createCourseActivity(c);

        MainActivity.prefs.save();

        return true;

    }

}
