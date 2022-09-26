package com.example.listview;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Images extends AppCompatActivity {

    private ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        img = findViewById(R.id.imageView);
        txt = findViewById(R.id.label);
        registerForContextMenu(txt);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Image to Display");
        // add menu items
        menu.add(0, v.getId(), 0, "Image1");
        menu.add(0, v.getId(), 0, "Image2");
        menu.add(0, v.getId(), 0, "Image3");
        menu.add(0, v.getId(), 0, "Image4");
    }

    @Override
    public boolean onContextItemSelected(android.view.MenuItem item) {

        if (item.getTitle() == "Image1") {
            img.setImageResource(R.drawable._1);
        } else if (item.getTitle() == "Image2") {
            img.setImageResource(R.drawable._2);
        } else if (item.getTitle() == "Image3") {
            img.setImageResource(R.drawable._3);
        } else if (item.getTitle() == "Image4") {
            img.setImageResource(R.drawable._4);
        }
        return true;
    }
}