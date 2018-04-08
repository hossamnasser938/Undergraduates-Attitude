package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

    public void notifyCourseAdded(View view){
        Toast.makeText(getApplicationContext(), "Course Added", Toast.LENGTH_LONG).show();
    }

    public void addCourse (User user) {
        Spinner difficulty =findViewById(R.id.difficulty_spinner);
        EditText name=findViewById(R.id.Name);
        EditText hours=findViewById(R.id.Hours);
        EditText minutes=findViewById(R.id.Minutes);
        CheckBox assignments=findViewById(R.id.Assignments);
        CheckBox finalProject=findViewById(R.id.Final_Project);

        Course.Difficulty difficulty1 = Course.Difficulty.valueOf(difficulty.getSelectedItem().toString());

        Course c = new Course(name.getText().toString(), new ActivityDuration(Integer.parseInt(hours.toString()), Integer.parseInt(minutes.toString())), difficulty1, assignments.isChecked(), finalProject.isChecked());
        user.getCourses().add(c);

    }

}
