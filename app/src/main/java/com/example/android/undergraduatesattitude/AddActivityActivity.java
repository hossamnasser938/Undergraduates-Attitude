package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);

        Spinner categorySpinner = (Spinner) findViewById(R.id.category_spinner);

        ArrayList<String> categorySpinnerList = new ArrayList<>();
        categorySpinnerList.add("Choose Category");
        categorySpinnerList.addAll(KnowledgeBase.optimalCategoryList);
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, categorySpinnerList);
        categoryAdapter.setDropDownViewResource(R.layout.spinner_item);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Spinner activitySpinner = (Spinner) findViewById(R.id.activity_spinner);
                Spinner courseActivitySpinner = (Spinner) findViewById(R.id.course_activity_spinner);
                ArrayList<String> activitySpinnerList = new ArrayList<>();
                ArrayAdapter<String> activityAdapter;

                if(position == 1){
                    activitySpinnerList.add("Choose Course");
                    activitySpinnerList.addAll(KnowledgeBase.Educational);
                    activityAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, activitySpinnerList);
                    activityAdapter.setDropDownViewResource(R.layout.spinner_item);
                    activitySpinner.setAdapter(activityAdapter);

                    courseActivitySpinner.setVisibility(View.VISIBLE);
                    ArrayList<String> courseActivitySpinnerList = new ArrayList<>();
                    courseActivitySpinnerList.add("Choose Course Activity");
                    courseActivitySpinnerList.addAll(KnowledgeBase.courseActivities);
                    ArrayAdapter<String> courseActivityAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, courseActivitySpinnerList);
                    courseActivityAdapter.setDropDownViewResource(R.layout.spinner_item);
                    courseActivitySpinner.setAdapter(courseActivityAdapter);
                }
                else{
                    courseActivitySpinner.setVisibility(View.GONE);
                    activitySpinnerList.add("Choose Activity");
                    switch(position){
                        case 2 :
                            activitySpinnerList.addAll(KnowledgeBase.Healthy);
                            break;
                        case 3 :
                            activitySpinnerList.addAll(KnowledgeBase.Life);
                            break;
                        case 4 :
                            activitySpinnerList.addAll(KnowledgeBase.Responsibility);
                            break;
                        case 5 :
                            activitySpinnerList.addAll(KnowledgeBase.Entertainment);
                            break;
                        case 6 :
                            activitySpinnerList.addAll(KnowledgeBase.Skills);
                            break;
                    }

                    activityAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, activitySpinnerList);
                    activityAdapter.setDropDownViewResource(R.layout.spinner_item);
                    activitySpinner.setAdapter(activityAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void notifyActivityAdded(View view){
        addActivity();
        Toast.makeText(getApplicationContext() , "Activity Added" , Toast.LENGTH_SHORT).show();
    }

    public void addActivity() {
        Report report = User.user.getCurrentWeek().getReport();
        Spinner activityCategory = findViewById(R.id.category_spinner);
        Spinner activityName = findViewById(R.id.activity_spinner);
        EditText h = findViewById(R.id.Hours);
        EditText m = findViewById(R.id.Minutes);
        ActivityDuration d = new ActivityDuration(Integer.parseInt(h.getText().toString()), Integer.parseInt(m.getText().toString()));
        report.addToAllCommittedHours(d.getHours() + (double) d.getMinutes() / 60);
        CommittedActivity committedActivity = new CommittedActivity(Category.valueOf(activityCategory.getSelectedItem().toString()), activityName.getSelectedItem().toString(), d);

        int i = 0;

        for (CommittedCategory c : User.user.getCurrentWeek().getReport().getCommittedCategories()) {
            if (c.getCategory().equals(committedActivity.getCategory())) {
                c.getCommittedDuration().setHours(c.getCommittedDuration().getHours() + committedActivity.getDuration().getHours());
                c.getCommittedDuration().setMinutes(c.getCommittedDuration().getMinutes() + committedActivity.getDuration().getMinutes());

                int j = 0;
                boolean found = false;

                for(CommittedActivity ca : c.getCommittedActivities()){
                    if(ca.getName().equals(committedActivity.getName())){
                        User.user.getCurrentWeek().getReport().getCommittedCategories().get(i).getCommittedActivities().get(j).setDuration(ActivityDuration.addTwoDurations(ca.getDuration(), committedActivity.getDuration()));
                        found = true;
                        break;
                    }
                    j++;
                }

                if(!found){
                    User.user.getCurrentWeek().getReport().getCommittedCategories().get(i).getCommittedActivities().add(committedActivity);
                }
            }
            i++;
        }

        /*
        UserPrefs prefs =new UserPrefs(getApplicationContext());
        prefs.save();
        */

    }
}
