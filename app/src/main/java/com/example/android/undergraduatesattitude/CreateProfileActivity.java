package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
    }

    private void navigateToSubMainLayout(View view){
        MainActivity.navigateTo(this , SubMainActivity.class);
    }
}
