package com.example.message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    EditText messageText;

    @SuppressWarnings("Convert2Lambda")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.sendButton);
        messageText = findViewById(R.id.messageInput);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String messageStr = messageText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Display.class);
                intent.putExtra("message_text", messageStr);
                startActivity(intent);
            }
        });
    }
}