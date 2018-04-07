package com.example.android.undergraduatesattitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

}
