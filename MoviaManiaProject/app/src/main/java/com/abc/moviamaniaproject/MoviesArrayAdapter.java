package com.abc.moviamaniaproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MoviesArrayAdapter extends ArrayAdapter {
    Context mContext;
    LayoutInflater mLayoutInflator;
    int ResID;
    String [] mData;

    public MoviesArrayAdapter(Context mContext, int ResID, String[] mData) {

        super(mContext, ResID, mData);
        this.mContext = mContext;
        this.ResID = ResID;
        this.mData = mData;
        this.mLayoutInflator = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {

        return mData.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = mLayoutInflator.inflate(ResID, parent, false);
        ImageView mMovieIcon = convertView.findViewById(R.id.imageView);
        TextView mMovietitle = convertView.findViewById(R.id.txt_view1);
        TextView mMoviesubtitle = convertView.findViewById(R.id.txt_view2);
        return super.getView(position, convertView, parent);
    }
}


