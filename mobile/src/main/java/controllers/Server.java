package controllers;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import models.WOD;

/**
 * Created by dasas on 07/10/15.
 */
public class Server {

    public void connect(WOD wod){
        new MyConnect(wod).execute();
    }
    private class MyConnect extends AsyncTask<Void, Void, Void> {

        private WOD w;
        public MyConnect(WOD w){
            this.w = w;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Gson gson = new Gson();
                String s = gson.toJson(w);
                Log.d("TEST", s.toString());
                URL url = new URL("http://72.9.151.78/~wody/wod_save.php");
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setDoInput(true);
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                con.getOutputStream().write(("wod="+s).getBytes());
                con.connect();

                Scanner scanner = new Scanner(con.getInputStream());
                String s1 = "";
                while (scanner.hasNext()) {
                    s1 += scanner.nextLine();
                }
                Log.d("TEST", s1);
                System.out.println(s1);
                scanner.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}


