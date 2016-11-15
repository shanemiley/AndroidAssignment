package com.example.shane.workoutrecorder20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;




public class NewWorkout extends Activity {

    // The EditText objects

    EditText name;
    EditText exercise1;
    EditText exercise2;
    EditText exercise3;
    EditText exercise4;

    DBTools dbTools = new DBTools(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_new_workout);

        // Initialize the EditText objects

        name = (EditText) findViewById(R.id.Name);
        exercise1 = (EditText) findViewById(R.id.exercise1);
        exercise2 = (EditText) findViewById(R.id.exercise2);
        exercise3 = (EditText) findViewById(R.id.exercise3);
        exercise4 = (EditText) findViewById(R.id.exercise4);

    }
    public void addNewContact(View view) {

        // Will hold the HashMap of values

        HashMap<String, String> queryValuesMap =  new  HashMap<String, String>();

        // Get the values from the EditText boxes

        queryValuesMap.put("name", name.getText().toString());
        queryValuesMap.put("exercise1", exercise1.getText().toString());
        queryValuesMap.put("exercise2", exercise2.getText().toString());
        queryValuesMap.put("exercise3", exercise3.getText().toString());
        queryValuesMap.put("exercise4", exercise4.getText().toString());

        // Call for the HashMap to be added to the database

        dbTools.insertWorkout(queryValuesMap);

        // Call for MainActivity to execute

        this.callMainActivity(view);
    }
    public void callMainActivity(View view) {
        Intent theIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(theIntent);
    }
}
