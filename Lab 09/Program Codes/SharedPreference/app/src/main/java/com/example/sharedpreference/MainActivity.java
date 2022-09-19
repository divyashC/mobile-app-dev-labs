package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText first_name, last_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first_name = findViewById(R.id.first);
        last_name = findViewById(R.id.last);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String fn = sh.getString("first_name", "");
        String ln = sh.getString("last_name", "");
        first_name.setText(fn);
        last_name.setText(ln);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("first_name", first_name.getText().toString());
        myEdit.putString("last_name", last_name.getText().toString());
        myEdit.apply();
    }
}