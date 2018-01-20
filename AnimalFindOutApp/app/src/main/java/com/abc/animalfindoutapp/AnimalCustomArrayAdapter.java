package com.abc.animalfindoutapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalCustomArrayAdapter extends ArrayAdapter{

    //Declaring private variables

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int designRes;
    private String [] mAnimalsData;
    private String [] mAnimalsCatData;
    private int [] mAnimalsImgData;

    public AnimalCustomArrayAdapter(Context mContext,
                                    int designRes,
                                    String [] mAnimalsData,
                                    String [] mAnimalsCatData,
                                    int [] mAnimalsImgData)    {

        //the below code did what is required to be ask from sir rizwan
        super(mContext, designRes, mAnimalsData);
        this.mContext = mContext;
        this.designRes = designRes;
        this.mAnimalsData = mAnimalsData;
        this.mAnimalsCatData = mAnimalsCatData;
        this.mAnimalsImgData = mAnimalsImgData;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mAnimalsData.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = mLayoutInflater.inflate(designRes, parent, false);
        ImageView imgVuAnimal = convertView.findViewById(R.id.img_vu_animal);
        TextView txtVuAnimalName = convertView.findViewById(R.id.txt_vu_animal_name);
        TextView txtVuAnimalCat = convertView.findViewById(R.id.txt_vu_animal_cat);

        txtVuAnimalName.setText(mAnimalsData[position]);

        txtVuAnimalCat.setText(mAnimalsCatData[position]);

        imgVuAnimal.setImageResource(mAnimalsImgData[position]);
        // the above line and below line code will also run if use one
        //imgVuAnimal.setImageDrawable(mContext.getResources().getDrawable(mAnimalsImgData[position]));

        return convertView;

    }
}
