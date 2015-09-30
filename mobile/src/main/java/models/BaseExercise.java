package models;

import java.util.ArrayList;

/**
 * Created by Kevin on 21-09-2015.
 */
public abstract class BaseExercise {
    String name;
    String description;
    ArrayList<Muscle> muscles = new ArrayList<Muscle>();

    public void addMuscle(Muscle m){
        muscles.add(m);
    }

}
