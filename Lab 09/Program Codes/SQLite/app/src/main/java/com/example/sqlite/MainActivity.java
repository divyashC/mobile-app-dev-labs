package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View; import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText fn, ln, ph;
    private Button btn;
    private DatabaseCon db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fn = findViewById(R.id.first_name);
        ln = findViewById(R.id.last_name);
        ph = findViewById(R.id.phone_no);
        btn = findViewById(R.id.button);
        db = new DatabaseCon(MainActivity.this);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               String fname = fn.getText().toString();
               String lname = ln.getText().toString();
               String phone = ph.getText().toString();
                if (fname.isEmpty() && lname.isEmpty() && phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill up all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                db.addNewUser(fname, lname, phone);
                Toast.makeText(MainActivity.this, "Form has been submitted", Toast.LENGTH_SHORT).show();
                fn.setText("");
                ln.setText("");
                ph.setText("");
            }
        });
    }
}