package com.abc.newlistproject;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    //declaring of variable of type listview
    //ListView listViewflowers;

    ListView listViewCity;

    Spinner spinnerflowers;

    //declaring an array with name of myflowersArray of type string
    //String[] myflowersArray = {"Jasmine", "Tulip", "Rose", "Poppy", "Pansy", "Sunflower"};

    String[] mycityNames = {"Islamabad", "Karachi", "Quetta", "Peshawar", "Lahore"};

    //String[] spinnerflowersArray = {"Islamabad", "Karachi", "Quetta", "Peshawar", "Lahore"};

    //declaring an array adapter

    //ArrayAdapter myArrayAdapter;
    ArrayAdapter cityArrayAdapter;

    //SpinnerAdapter spinnerFlowersArrayAdapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //list in design view with name of lst_viweflw is associated with this newly created varaible
        // ctrl+shift+space is direct shortcut googel it at your own time
        //listViewflowers = findViewById(R.id.lst_viewflw);
        listViewCity = findViewById(R.id.lst_viewcty);
        spinnerflowers = findViewById(R.id.elst_flowers);

        // assigining array values to an adapter

        //myArrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, myflowersArray);
        cityArrayAdapter = new ArrayAdapter(MainActivity.this, R.layout.custom_listview_style, mycityNames);
        //spinnerflowers = new Spinner(MainActivity.this, android.R.layout.simple_spinner_item, spinnerflowersArray);
        //assigning the adapter to my listview variable declare above
        //listViewflowers.setAdapter(myArrayAdapter);
        listViewCity.setAdapter(cityArrayAdapter);
        spinnerflowers.setAdapter(cityArrayAdapter);


    }
}
