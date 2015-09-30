package models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kevin on 21-09-2015.
 */
public class WOD {
    String name;
    String description;
    int rounds;
    Date date;
    boolean isBenchmark;
    long startTime, endTime;
    ArrayList<BaseExercise> exercises = new ArrayList<BaseExercise>();
    ArrayList<String> notes = new ArrayList<String>();

    public void addNote(String txt){
        notes.add(txt);
    }

    public void addExercise(BaseExercise ex){
        exercises.add(ex);
    }


}
