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

public class QuranAdapter extends ArrayAdapter<QuranModel> {

    //Declaring private variables

    private Context context;
    private int resource;
    private QuranModel [] objects;
    LayoutInflater mLayoutInflater;


    public QuranAdapter(@NonNull Context context, int resource, @NonNull QuranModel [] objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        mLayoutInflater = LayoutInflater.from( context);

    }

    @Override
    public int getCount() {
        return objects.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = mLayoutInflater.inflate(R.layout.custom_list_vu_design, parent, false);
        ImageView imgVuPara = convertView.findViewById(R.id.img_vu_para);
        TextView txtParaNo = convertView.findViewById(R.id.txt_vu_para_no);
        TextView txtParaName = convertView.findViewById(R.id.txt_vu_para_name);

        txtParaNo.setText(objects[position].getQuranParaNo());


        txtParaName.setText(objects[position].getQuranParaName());

        //imgVuPara.setImageResource(mQuranParaImg[position]);
        // the above line and below line code will also run if use one
        imgVuPara.setImageDrawable(context.getResources().getDrawable(objects[position].getImageId()));

        return convertView;

    }
}