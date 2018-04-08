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

    private void notifyActivityAdded(View view){
        Toast toast = Toast.makeText(getApplicationContext() , getResources().getString(R.string.activity_added_successfully) , Toast.LENGTH_SHORT);
        toast.show();
    }
    public void addActivity (User user) {
        Spinner category=findViewById(R.id.Category);
        Spinner task=findViewById(R.id.Task);
        EditText h=findViewById(R.id.Hours);
        EditText m=findViewById(R.id.Minutes);
        ActivityDuration d=new ActivityDuration(Integer.parseInt(h.getText().toString()),Integer.parseInt(m.getText().toString()));
        Activity activity=new Activity(task.getSelectedItem().toString(),category.getSelectedItem(),d);
        int i=0;
        boolean found=false;
        for(Activity a:user.getWeeks().get(Week.getNum()).getActivities())
        {
            if(a.getName().equals(activity.getName())) {
            user.getWeeks().get(Week.getNum()).getActivities().get(i).setDuration(new ActivityDuration(a.getDuration().getHours()+activity.getDuration().getHours(),a.getDuration().getMinutes()+activity.getDuration().getMinutes()));
        found=true;
            }
            i++;
}
if(!found)
    user.getWeeks().get(Week.getNum()).getActivities().add(activity);
    if(!user.getWeeks().get(Week.getNum()).getReport().getCommittedCategory().contains(activity.getCategory()))
        user.getWeeks().get(Week.getNum()).getReport().getCommittedCategory().add(activity.getCategory());
    }


}
