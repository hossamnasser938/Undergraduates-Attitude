package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class AddCourseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
    }
    public void addCourse (User user) {
        Spinner category=findViewById(R.id.Category);
        Spinner difficulty =findViewById(R.id.Difficulity);
        EditText name=findViewById(R.id.Name);
        EditText hours=findViewById(R.id.Hours);
        EditText minutes=findViewById(R.id.Minutes);
        CheckBox assignments=findViewById(R.id.Assignments);
        CheckBox finalProjects=findViewById(R.id.Final_Project);

       // difficulty.setAdapter(new ArrayAdapter<Difficulty>(this , android.R));
        Course c=new Course();
        c.setAssignments(assignments.isChecked());
        //c.setDifficulty(difficulty.getSelectedItem());
        c.setFinalProject(finalProjects.isChecked());
        c.setName(name.getText().toString());
        //c.setCategory(category.getSelectedItem());
user.getCourses().add(c);

    }

}
