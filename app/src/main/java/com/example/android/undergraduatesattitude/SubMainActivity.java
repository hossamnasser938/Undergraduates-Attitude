package com.example.android.undergraduatesattitude;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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
        AlertDialog.Builder chooseActionDialog = new AlertDialog.Builder(SubMainActivity.this);
        chooseActionDialog.setTitle("Choose Action");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item);
        adapter.add("Just show current report");
        adapter.add("End this week, Show its report, and Start a new week");

        chooseActionDialog.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                        intent.putExtra("EXTRA_WEEK_NO", Week.getNum());
                        if(which == 0){
                            startActivity(intent);
                        }
                        else{
                            User.user.getWeeks().add(new Week());
                            startActivity(intent);
                        }
                    }
                });

        chooseActionDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        chooseActionDialog.show();

                //Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                //startActivity(intent);
    }

    public void navigateToShow(View view){
        Toast.makeText(getApplicationContext(), "Not implemented Yet", Toast.LENGTH_LONG).show();
    }
}
