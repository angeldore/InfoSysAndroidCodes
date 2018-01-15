package com.abc.newlistproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //declaring of variable of type listview
    ListView listViewflowers;

    //declaring an array with name of myflowersArray of type string
    String[] myflowersArray = {"Jasmine", "Tulip",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "Rose",
            "BlackBeck"};

    //declaring an array adapter

    ArrayAdapter myArrayAdapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //list in design view with name of lst_viweflw is associated with this newly created varaible
        // ctrl+shift+space is direct shortcut googel it at your own time
        listViewflowers = findViewById(R.id.lst_viewflw);

        // assigining array values to an adapter

        myArrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, myflowersArray);

        //assigning the adapter to my listview variable declare above
        listViewflowers.setAdapter(myArrayAdapter);


    }
}
