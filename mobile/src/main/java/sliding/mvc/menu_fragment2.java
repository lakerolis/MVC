package sliding.mvc;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import models.SensorData;
import models.TimeExercise;
import models.WOD;
import models.Workout;

/**
 * Created by dasas on 12/09/15.
 */
public class menu_fragment2 extends Fragment implements SensorEventListener {
    View rootview;


    private SensorManager mSensorManager;
    private Sensor acSensor;

    private  WOD wod;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu2_layout, container, false);

        mSensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        acSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(this, acSensor, SensorManager.SENSOR_DELAY_NORMAL);

        wod = new WOD("Half-cindy","",1);
        wod.addExercise(new TimeExercise("Push-ups", 5));
        wod.addExercise(new TimeExercise("Sit-ups", 10));

        return rootview;
    }

    @Override
    public void onSensorChanged(SensorEvent evt) {
        //x = evt.values[0], y = evt.values[1], z = evt.values[2], timestamp = evt.timestamp
        TimeExercise ex = (TimeExercise)wod.getExercises().get(0);
        SensorData s = new SensorData(evt.values, evt.timestamp);
        ex.addData(s);
        Log.d(""+Log.VERBOSE,""+evt.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


}
        }