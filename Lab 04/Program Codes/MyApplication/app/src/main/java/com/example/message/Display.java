package com.example.message;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {

    TextView msgDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);
        msgDisplay = findViewById(R.id.messageDisplay);

        Intent intent = getIntent();

        String str = intent.getStringExtra("message_text");
        msgDisplay.setText(str);
    }

}
