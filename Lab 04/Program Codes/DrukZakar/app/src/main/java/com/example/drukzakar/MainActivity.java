package com.example.drukzakar;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //date
        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());

        TextView textViewDate = findViewById(R.id.textView);
        textViewDate.setText(currentDate);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        myAdapter.addFragment(new select_date(), "SELECT DATE");
        myAdapter.addFragment(new dzongkha(), "DZONGKHA");
        myAdapter.addFragment(new english(), "ENGLISH");
        myAdapter.addFragment(new Audio(), "AUDIO");
        viewPager.setAdapter(myAdapter);


    }
}