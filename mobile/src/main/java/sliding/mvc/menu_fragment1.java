package sliding.mvc;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import controllers.WorkoutController;
import models.Workout;

/**
 * Created by dasas on 12/09/15.
 */
public class menu_fragment1 extends Fragment {
    View rootview;
    Workout wo;
    WorkoutController wc;
    List<String> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_layout, container, false);


        wc = new WorkoutController();
        final EditText txtName = (EditText) rootview.findViewById(R.id.txtName);
        final Button btnSave = (Button) rootview.findViewById(R.id.btnSave);
        final Button btnLoad = (Button) rootview.findViewById(R.id.btnLoad);
        final TextView tv = (TextView) rootview.findViewById(R.id.txtDescription);

        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                wo = new Workout(txtName.getText().toString(), 2, "Run", 3);
                wc.saveToParse(wo);

                Context context = rootview.getContext();
                Toast toast = Toast.makeText(context, "Saved", Toast.LENGTH_LONG);

            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = wc.retrieveListOfAllWorkoutsFromParse();
                tv.setText(list.size());

            }
        });

        return rootview;

    }
}
