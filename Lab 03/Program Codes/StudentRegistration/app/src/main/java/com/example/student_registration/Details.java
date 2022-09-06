package com.example.student_registration;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView name,id,pg,yr,sm,ay,md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // assigning variables with thier IDs from xml
        name = (TextView) findViewById(R.id.name_display);
        id = (TextView) findViewById(R.id.student_id_display);
        pg = (TextView) findViewById(R.id.programme_display);
        yr = (TextView) findViewById(R.id.year_display);
        sm = (TextView) findViewById(R.id.semester_display);
        ay = (TextView) findViewById(R.id.academic_year_display);
        md = (TextView) findViewById(R.id.module_display);

        //getting the string passed from previous activity
        String sname = getIntent().getStringExtra("name");
        String stid = getIntent().getStringExtra("id");
        String spg= getIntent().getStringExtra("programme");
        String syr = getIntent().getStringExtra("year");
        String ssm = getIntent().getStringExtra("semester");
        String say = getIntent().getStringExtra("ayear");
        String smd = getIntent().getStringExtra("module");

        //displaying the text
        name.setText(sname);
        id.setText(stid);
        pg.setText(spg);
        yr.setText(syr);
        sm.setText(ssm);
        ay.setText(say);
        md.setText(smd);
    }
}