package com.jahangiri.alquranaudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

        Button btnMain;
        LinearLayout innerLayout;

    ListView lstVuPara;

    QuranModel [] quranData;

    QuranAdapter mQuranAdapter;

    ImageView imgVuQuranMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = findViewById(R.id.btn_start);
        innerLayout = findViewById(R.id.lnr_layoutinner);
        lstVuPara = findViewById(R.id.lst_vu_para);

        //use of glide below code will explain about the use of glide
        imgVuQuranMain = findViewById(R.id.img_vu_quran_main);
        Glide.with(MainActivity.this).load("http://rfbasolutions.com/wp-content/uploads/2018/01/web-development.png").into(imgVuQuranMain);

        quranData = new QuranModel[30];
        int imageName = R.drawable.quranaudio;


        for (int i = 1; i < 31; ++i)
        {
            String paraName = "Para Name";

            switch (i) {
                case 1:
                    paraName = " الم Alif Lam Meem";
                    break;

                case 2:
                    paraName = "Sayaqool سَيَقُولُ ";
                    break;

                case 3:
                    paraName = "Tilkal Rusull تِلْكَ الرُّسُلُ ";
                    break;

                case 4:
                    paraName = "Lan Tana Loo لَنْ تَنَالُوا ";
                    break;

                case 5:
                paraName = "Wal Mohsanat وَالْمُحْصَنَاتُ ";
                break;

                case 6:
                paraName = "La Yuhibbullah لَا يُحِبُّ اللَّهُ ";
                break;

                case 7:
                paraName = "Wa Iza Samiu وَإِذَا سَمِعُوا ";
                break;

                case 8:
                paraName = "Wa Lau Annana وَلَوْ أَنَّنَا ";
                break;

                case 9:
                paraName = "Qalal Malao قَالَ الْمَلَأُ ";
                break;

                case 10:
                paraName = "Wa A'lamu وَاعْلَمُوا ";
                break;

            }

            QuranModel model = new QuranModel(imageName, i+".", paraName);
            quranData[i-1] = model;

        }


                btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "You click on the file", Toast.LENGTH_SHORT).show();
                innerLayout.setVisibility(View.INVISIBLE);

                mQuranAdapter = new QuranAdapter(MainActivity.this, R.layout.custom_list_vu_design, quranData);
                lstVuPara.setAdapter(mQuranAdapter);

                lstVuPara.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View incomingView, int position, long l) {
                        TextView TxtVuIncomingParaName = incomingView.findViewById(R.id.txt_vu_para_name);
                        String incomingParaName = TxtVuIncomingParaName.getText().toString();

                        //Toast.makeText(MainActivity.this, incomingTitle, Toast.LENGTH_SHORT).show();
                        Intent mintent = new Intent(MainActivity.this, PlayActivity.class);

                        //to put an extra that carry string to other activity

                        mintent.putExtra("txt_vu_para_name", incomingParaName);
                        startActivity(mintent);
                        //to finsish the current intent use finsish();


                    }
                });

            }
        });
    }
}
