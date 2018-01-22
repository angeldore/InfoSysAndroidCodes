package com.jahangiri.alquranaudio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class quranPara extends ArrayAdapter {

    //Declaring private variables

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int designRes;
    private String [] mQuranParaNo;
    private String [] mQuranParaName;
    private int [] mQuranParaImg;

    public quranPara(@NonNull Context mContext, int designRes, @NonNull String [] mQuranParaNo,
                     String [] mQuranParaName,
                     int [] mQuranParaImg)
    {
        super(mContext, designRes, mQuranParaNo);
        this.mContext = mContext;
        this.designRes = designRes;
        this.mQuranParaNo = mQuranParaNo;
        this.mQuranParaName = mQuranParaName;
        this.mQuranParaImg = mQuranParaImg;
        this.mLayoutInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mQuranParaNo.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = mLayoutInflater.inflate(designRes, parent, false);
        ImageView imgVuPara = convertView.findViewById(R.id.img_vu_para);
        TextView txtParaNo = convertView.findViewById(R.id.txt_vu_para_no);
        TextView txtParaName = convertView.findViewById(R.id.txt_vu_para_name);

        txtParaNo.setText(mQuranParaNo[position]);

        txtParaName.setText(mQuranParaName[position]);

        //imgVuPara.setImageResource(mQuranParaImg[position]);
        // the above line and below line code will also run if use one
        imgVuPara.setImageDrawable(mContext.getResources().getDrawable(mQuranParaImg[position]));

        return convertView;

    }
}