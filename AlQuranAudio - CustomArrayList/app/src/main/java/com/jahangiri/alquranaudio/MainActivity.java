package com.jahangiri.alquranaudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        Button btnMain;
        LinearLayout innerLayout;

    ListView lstVuPara;

    quranPara quranAdapter;

    String [] quranParaNo = {"1.", "2.", "3."};
    String [] quranParaName = {"Alif Laam Mim", "Sayaqool Us Suhafa", "Tilk ur Rusoolo"};
    int [] quranParaImg = {R.drawable.quranaudio, R.drawable.quranaudio, R.drawable.quranaudio};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = findViewById(R.id.btn_start);
        innerLayout = findViewById(R.id.lnr_layoutinner);
        lstVuPara = findViewById(R.id.lst_vu_para);


                btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "You click on the file", Toast.LENGTH_SHORT).show();
                innerLayout.setVisibility(View.INVISIBLE);

                quranAdapter = new quranPara(MainActivity.this, R.layout.custom_list_vu_design, quranParaNo,
                        quranParaName, quranParaImg);
                lstVuPara.setAdapter(quranAdapter);

            }
        });
    }
}
