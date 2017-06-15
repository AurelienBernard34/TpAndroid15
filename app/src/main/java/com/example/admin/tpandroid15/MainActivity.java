package com.example.admin.tpandroid15;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Traitement traitement;

    class Traitement extends AsyncTask<Void, Integer, String> {

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(),"Demarrage",Toast.LENGTH_LONG).show();
        }
        @Override
        protected void onProgressUpdate(Integer ... values){
            progressBar.setProgress(values[0]);
        }

        @Override
        protected String doInBackground(Void ... arg0){
            int progress;
            for (progress = 0;progress<=100;progress++){
                if(isCancelled()) break;
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                publishProgress(progress);
            }
            return " ,dong";
        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getApplicationContext(),"Fini",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        traitement = new Traitement();
        traitement.execute();
    }

}

