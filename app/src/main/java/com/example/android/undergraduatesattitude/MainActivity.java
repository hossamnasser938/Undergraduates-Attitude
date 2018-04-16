package com.example.android.undergraduatesattitude;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static UserPrefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String id = "" + User.getId();

        prefs = new UserPrefs(getApplicationContext());

        if (UserPrefs.getSettings().contains(id)) {
            Toast.makeText(getApplicationContext(), "Found", Toast.LENGTH_SHORT).show();
            prefs.load();
            Intent intent = new Intent(getApplicationContext(), SubMainActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
        }

    }


    public void navigateToCreateProfile(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateProfileActivity.class);
        startActivity(intent);
    }

    public void navigateToAddCourseActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), AddCourseActivity.class);
        startActivity(intent);
    }

    public void navigateToAddActivityActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), AddActivityActivity.class);
        startActivity(intent);
    }

    public void navigateToReportActivity(View view) {

        AlertDialog.Builder chooseActionDialog = new AlertDialog.Builder(MainActivity.this);
        chooseActionDialog.setTitle("Choose Action");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item);
        adapter.add("Just show current report");
        adapter.add("End this week, Show its report, and Start a new week");

        chooseActionDialog.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                intent.putExtra("EXTRA_WEEK_INDEX", Week.getNum());
                if (which == 0) {
                    startActivity(intent);
                } else {
                    UserPrefs.user.getWeeks().add(new Week());
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

    }

    public void navigateToShow(View view) {

        AlertDialog.Builder chooseWeekDialog = new AlertDialog.Builder(MainActivity.this);
        chooseWeekDialog.setTitle("Choose week");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item);
        for (int i = 0; i < UserPrefs.user.getWeeks().size(); i++) {
            adapter.add("Week" + (i + 1));
        }

        chooseWeekDialog.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                intent.putExtra("EXTRA_WEEK_INDEX", which);
                startActivity(intent);
            }
        });

        chooseWeekDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        chooseWeekDialog.show();

    }

}
