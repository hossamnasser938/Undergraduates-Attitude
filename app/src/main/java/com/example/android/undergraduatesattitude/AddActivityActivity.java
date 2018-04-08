package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);
    }

    public void notifyActivityAdded(View view){
        Toast.makeText(getApplicationContext() , "Activity Added" , Toast.LENGTH_SHORT).show();
    }

    public void addActivity (User user) {
        Spinner category=findViewById(R.id.Category);
        Spinner task=findViewById(R.id.Task);
        EditText h=findViewById(R.id.Hours);
        EditText m=findViewById(R.id.Minutes);

        Category category1 = Category.valueOf(category.getSelectedItem().toString());

        ActivityDuration d=new ActivityDuration(Integer.parseInt(h.getText().toString()),Integer.parseInt(m.getText().toString()));

        CommittedActivity activity = new CommittedActivity(category1, task.getSelectedItem().toString(),d,  OptimalActivity.Priority.MANDATORY);

        int i=0;
        boolean found=false;
        for(Activity a:User.user.getWeek().getActivities())
        {
            if(a.getName().equals(activity.getName())) {
            user.getWeek().getActivities().get(i).setDuration(new ActivityDuration(a.getDuration().getHours()+activity.getDuration().getHours(),a.getDuration().getMinutes()+activity.getDuration().getMinutes()));
            found=true;
            }
            i++;
        }
        if(!found)
            user.getWeek().getActivities().add(activity);
            //ToDo: Add an object of CommittedCategory
        //if(!user.getWeek().getReport().getCommittedCategories().contains(activity.getCategory()))
            //user.getWeek().getReport().getCommittedCategories().add(activity.getCategory());
    }


}
