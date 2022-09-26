package com.example.listview;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        List<String> list = new ArrayList<>();
        list.add("Open Messages");
        list.add("Search for location in Map");
        list.add("Open Image");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                if (i == 0) {
                    Toast.makeText(MainActivity.this, "Opening Messages....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                    startActivity(intent);
                } else if (i == 1) {
                    Toast.makeText(MainActivity.this, "Opening Maps....", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder alertName = new AlertDialog.Builder(MainActivity.this);
                    final EditText editText = new EditText(MainActivity.this);
                    alertName.setTitle("Search location");

                    alertName.setView(editText);
                    LinearLayout layoutName = new LinearLayout(getApplicationContext());
                    layoutName.setOrientation(LinearLayout.VERTICAL);
                    layoutName.addView(editText); // displays the user input bar
                    alertName.setView(layoutName);

                    alertName.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            location = editText.getText().toString();
                            Uri uri = Uri.parse("http://maps.google.com/maps?q=" + location);

                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            startActivity(mapIntent);
                        }
                    });
                    alertName.show();
                } else if (i == 2) {
                    startActivity (new Intent(MainActivity.this, Images.class));
                    Toast.makeText(MainActivity.this, "Opening Images....", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}