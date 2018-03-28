package com.example.android.undergraduatesattitude;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void navigateToCreateProfile(View view){
        navigateTo(this , CreateProfileActivity.class);
    }

    static void navigateTo(Context context, Class activity){
        Intent intent = new Intent(context , activity.getClass());
        context.startActivity(intent);
    }

}
