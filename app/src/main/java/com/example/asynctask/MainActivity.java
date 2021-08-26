package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Button btnSession;
    EditText txtUser, txtPassword;
    ProgressBar prgB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSession = (Button) findViewById(R.id.btnLogin);
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        prgB = (ProgressBar) findViewById(R.id.progressBar);

        btnSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute(txtUser.getText().toString());
            }
        });

    }


    class Task extends AsyncTask<String,Void,String>{

        String user;

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            return strings[0];
            //return null;
        }

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            prgB.setVisibility(View.VISIBLE);
            btnSession.setEnabled(false);
        }

        @Override
        protected void onPostExecute(String s) {
            prgB.setVisibility(View.INVISIBLE);
            btnSession.setEnabled(true);
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("user",txtUser.getText().toString());
            startActivity(intent);
        }
    }
}