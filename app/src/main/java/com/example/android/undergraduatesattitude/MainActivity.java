package com.example.android.undergraduatesattitude;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File file = new File("user_file");
        if(file.exists()){
            try {
                User.load(getApplicationContext());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            setContentView(R.layout.activity_sub_main);
        }
        else{
            setContentView(R.layout.activity_main);
        }

    }

    public void navigateToCreateProfile(View view){
        Intent intent = new Intent(getApplicationContext() , CreateProfileActivity.class);
        startActivity(intent);
    }

}
