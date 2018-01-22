package com.jahangiri.alquranaudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

        Button btnMain;
        LinearLayout innerLayout;

    ListView lstVuPara;

    QuranModel [] quranData;

    QuranAdapter mQuranAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = findViewById(R.id.btn_start);
        innerLayout = findViewById(R.id.lnr_layoutinner);
        lstVuPara = findViewById(R.id.lst_vu_para);

        quranData = new QuranModel[30];
        int imageName = R.drawable.quranaudio;

        for (int i = 1; i < 31; ++i)
        {
            QuranModel model = new QuranModel(imageName, ""+i, "Para Name:");
            quranData[i-1] = model;

        }


                btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "You click on the file", Toast.LENGTH_SHORT).show();
                innerLayout.setVisibility(View.INVISIBLE);

                mQuranAdapter = new QuranAdapter(MainActivity.this, R.layout.custom_list_vu_design, quranData);
                lstVuPara.setAdapter(mQuranAdapter);

            }
        });
    }
}
