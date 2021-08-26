package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView viewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        viewResult = (TextView) findViewById(R.id.viewResult);
        String nameUser = getIntent().getStringExtra("user");
        viewResult.setText("Bienvenido: "+nameUser);
    }
}