package controllers;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import models.Workout;

/**
 * Created by dasas on 12/09/15.
 *
 * MEGET VIGTIG CONTROLLER 2
 */
public class WorkoutController extends android.app.Application{

    public static final String YOUR_APPLICATION_ID = "KA6jprHrQVzFreYkI6kRkc8tzBQMhOouXlsC6RRt";
    public static final String YOUR_CLIENT_KEY = "cL9PJAYd1F7WMYrHtCrmgnnhaOFfrmciAm86cvtb";

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);

    }

    public void saveToParse(Workout w){
        // Enable Local Datastore.
        ParseObject workout  = new ParseObject("workout");
        workout.put("workout_name", w.getWorkoutName());
        workout.put("exersizes_name", w.getExersizeName());
        workout.put("number_of_exercises", w.getNumberOfExercises());
        workout.put("number_of_rounds", w.getNumberOfRounds());
        workout.saveInBackground();
    }
    public List<String> retrieveListOfAllWorkoutsFromParse(){
        final List<String> list = null;
        ParseQuery<ParseObject> workout = new ParseQuery<ParseObject>("workout");

        workout.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for (ParseObject workoutObject : objects) {
                        Log.d("Retrieve: ", workoutObject.get("workout_name").toString());
                        list.add(workoutObject.get("workout_name").toString());
                    }
                } else {
                    Log.d("App", "Error: " + e.getMessage());
                }
            }
        });
        return list;
    }

}
