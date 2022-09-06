package com.example.registrationform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner dzongkhagSpinner, countrySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dzongkhagSpinner = findViewById(R.id.dzo_spinner);
        dzongkhagSpinner.setOnItemSelectedListener(this);

        countrySpinner = findViewById(R.id.country_spinner);
        countrySpinner.setOnItemSelectedListener(this);
    }

    public void showAlert(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Help Service");
        alert.setMessage("Do you need any help?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Please, Contact: 17358766", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Okay, proceed with the form", Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
