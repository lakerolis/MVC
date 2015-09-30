package models;

import java.util.ArrayList;

/**
 * Created by dasas on 10/09/15.
 */
public class Workout {

    private String workoutName;
    private int numberOfExercises;
    private String exersizeName;
    private int numberOfRounds;

    private ArrayList<String> exersizes = new ArrayList<String>();

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public int getNumberOfExercises() {
        return numberOfExercises;
    }

    public void setNumberOfExercises(int numberOfExercises) {
        this.numberOfExercises = numberOfExercises;
    }

    public String getExersizeName() {
        return exersizeName;
    }

    public void setExersizeName(String exersizeName) {
        this.exersizeName = exersizeName;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public ArrayList<String> getExersizes() {
        return exersizes;
    }

    public void setExersizes(String exerciseName) {
        exersizes.add(exerciseName);
    }

    public Workout(String workoutName, int numberOfExercises, String exersizeName, int numberOfRounds) {
        this.workoutName = workoutName;
        this.numberOfExercises = numberOfExercises;
        this.exersizeName = exersizeName;
        this.numberOfRounds = numberOfRounds;
    }



}
