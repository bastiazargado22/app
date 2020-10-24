package com.example.async_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar barra;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra=(ProgressBar)findViewById(R.id.progressBar);
        barra.setVisibility(View.INVISIBLE);//inicia con el progress bar invisible
        btn=(Button)findViewById(R.id.botnIngrese);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();
            }
        });
    }
    class Task extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            barra.setVisibility(View.VISIBLE);//progressbar visisble
        }

        @Override
        protected String doInBackground(String... strings) {

            for(int i=1;i<=10;i++){
                try{
                    Thread.sleep(500);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            barra.setVisibility(View.INVISIBLE);
            Intent i= new Intent(getBaseContext(), Menu_act.class);
            startActivity(i);
        }
    }
}