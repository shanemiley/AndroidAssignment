package com.example.shane.workoutrecorder20;

        import java.util.HashMap;
        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;

public class EditContact extends Activity{

    EditText Name;
    EditText Exercise1;
    EditText Exercise2;
    EditText Exercise3;
    EditText Exercise4;

    DBTools dbTools = new DBTools(this);

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_workout);
        Name = (EditText) findViewById(R.id.Name);
        Exercise1 = (EditText) findViewById(R.id.Exercise1);
        Exercise2 = (EditText) findViewById(R.id.Exercise2);
        Exercise3 = (EditText) findViewById(R.id.Exercise3);
        Exercise4 = (EditText) findViewById(R.id.Exercise4);

        Intent theIntent = getIntent();

        String workoutId = theIntent.getStringExtra("workoutId");

        HashMap<String, String> workoutList = dbTools.getWorkoutInfo(workoutId);

        if(workoutList.size() != 0){

            Name.setText(contactList.get("Name"));
            Exercise1.setText(contactList.get("Exercise1"));
            Exercise2.setText(contactList.get("Exercise2"));
            Exercise3.setText(contactList.get("Exercise3"));
            Exercise4.setText(contactList.get("Exercise4"));

        }
    }

    public void editWorkout(View view){

        HashMap<String, String> queryValuesMap = new HashMap<String, String>();
        Name = (EditText) findViewById(R.id.Name);
        Exercise1 = (EditText) findViewById(R.id.Exercise1);
        Exercise3 = (EditText) findViewById(R.id.Exercise2);
        Exercise3 = (EditText) findViewById(R.id.Exercise3);
        Exercise4 = (EditText) findViewById(R.id.Exercise4);

        Intent theIntent = getIntent();

        String contactId = theIntent.getStringExtra("workoutId");

        queryValuesMap.put("workoutId", contactId);
        queryValuesMap.put("Name", Name.getText().toString());
        queryValuesMap.put("Exercise1", Exercise1.getText().toString());
        queryValuesMap.put("Exercise2", Exercise2.getText().toString());
        queryValuesMap.put("Exercise3", Exercise3.getText().toString());
        queryValuesMap.put("Exercise4", Exercise4.getText().toString());

        dbTools.updateWorkout(queryValuesMap);
        this.callMainActivity(view);
    }

    public void removeWorkout(View view){
        Intent theIntent = getIntent();
        String workoutIdtId = theIntent.getStringExtra("workoutId");
        dbTools.deleteWorkout(workoutId);
        this.callMainActivity(view);
    }

    public void callMainActivity(View view){
        Intent objIntent = new Intent(getApplication(), MainActivity.class);
        startActivity(objIntent);
    }

}
