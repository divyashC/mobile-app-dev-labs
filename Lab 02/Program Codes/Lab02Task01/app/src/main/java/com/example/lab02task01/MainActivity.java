package com.example.lab02task01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numberOfClicks = 0;
    TextView count_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count_number = findViewById(R.id.countView);
    }

    public void toast(View view){
        String text = "Let's get counting!";
        Toast toast= Toast.makeText(this,text, Toast.LENGTH_LONG);
        toast.show();
    }

    @SuppressLint("SetTextI18n")
    public void increment(View view) {
        numberOfClicks++;
        count_number.setText(Integer.toString(numberOfClicks));
    }

}