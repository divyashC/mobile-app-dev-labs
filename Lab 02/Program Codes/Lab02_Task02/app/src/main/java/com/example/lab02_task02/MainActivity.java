package com.example.lab02_task02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputA, inputB, output;
    Button addB, resetB, cancelB;
    Float sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputA = (EditText) findViewById(R.id.inputA);
        inputB = (EditText) findViewById(R.id.inputB);
        output = (EditText) findViewById(R.id.output);
        addB = (Button) findViewById(R.id.addButton);
        resetB = (Button) findViewById(R.id.resetButton);
        cancelB = (Button) findViewById(R.id.cancelButton);
    }

    public void add(View view) {
        sum = Float.valueOf(inputA.getText().toString()) + Float.valueOf(inputB.getText().toString());
        Toast.makeText(this, "Adding...", Toast.LENGTH_SHORT).show();
        output.setText(String.valueOf(sum));
    }

    public void reset(View view) {
        Toast.makeText(this, "Resetting...", Toast.LENGTH_SHORT).show();
        inputA.setText("");
        inputA.setHint("Input A");
        inputB.setText("");
        inputB.setHint("Input A");
        output.setText("");
        output.setHint("0.0");
    }

    public void cancel(View view) {
        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
        inputA.setText("");
        inputA.setHint("Input A");
        inputB.setText("");
        inputB.setHint("Input A");
    }
}