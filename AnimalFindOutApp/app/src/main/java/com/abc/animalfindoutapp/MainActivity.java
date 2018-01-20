package com.abc.animalfindoutapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lstVuAnimal;

    AnimalCustomArrayAdapter animalAdapter;

    String [] AnimalNames = {"Cat", "Dog", "Lion", "Tiger"};
    String [] AnimalCat = {"Animal", "Animal", "Animal", "Animal"};
    int [] AnimalsImg = {R.drawable.cat, R.drawable.dog, R.drawable.cat, R.drawable.tiger};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstVuAnimal = findViewById(R.id.lst_vu_animal);

        animalAdapter = new AnimalCustomArrayAdapter(MainActivity.this, R.layout.custom_list_vu_design, AnimalNames, AnimalCat, AnimalsImg);
        lstVuAnimal.setAdapter(animalAdapter);

        ListView lstVuAnimal = (ListView) findViewById(R.id.lst_vu_animal);
        lstVuAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View convertedView, int i, long l) {

                TextView AnimalName = convertedView.findViewById(R.id.txt_vu_animal_name);

                String incomingAnimalName = AnimalName.getText().toString();

                Toast.makeText(MainActivity.this, "You clicked on <<: "+incomingAnimalName+" :>>", Toast.LENGTH_LONG).show();

            }
        });
    }
}
