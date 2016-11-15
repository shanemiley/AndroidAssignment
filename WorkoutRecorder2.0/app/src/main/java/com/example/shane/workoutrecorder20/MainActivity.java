package com.example.shane.workoutrecorder20;


        import java.util.ArrayList;
        import java.util.HashMap;


        import android.os.Bundle;
        import android.app.ListActivity;
        import android.content.Intent;

        import android.view.View;

        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.ListAdapter;
        import android.widget.SimpleAdapter;
        import android.widget.TextView;
        import android.widget.ListView;


public class MainActivity extends ListActivity {


    TextView workoutId;

    DBTools dbTools = new DBTools(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<HashMap<String, String>> workoutList =  dbTools.getAllWorkouts();


        if(workoutList.size()!=0) {

            ListView listView = getListView();
            listView.setOnItemClickListener(new OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    workoutId = (TextView) view.findViewById(R.id.workoutId);
                    String workoutIdValue = workoutId.getText().toString();
                    Intent  theIntent = new Intent(getApplication(),EditWorkout.class);
                    theIntent.putExtra("workoutId", workoutIdValue);
                    startActivity(theIntent);
                }
            });
            ListAdapter adapter = new SimpleAdapter( MainActivity.this,workoutList, R.layout.workout_entry, new String[] { "workoutId","Workout Name"}, new int[] {R.id.workoutId, R.id.Name});
            setListAdapter(adapter);
        }
    }

    public void showAddWorkout(View view) {
        Intent theIntent = new Intent(getApplicationContext(), NewWorkout.class);
        startActivity(theIntent);
    }
}
