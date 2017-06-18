package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class GeneralItemAdapter extends ArrayAdapter<GeneralItem> {


    public GeneralItemAdapter(Activity context, ArrayList<GeneralItem> generalItem) {
        super(context, 0, generalItem);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View generalItemView = convertView;
        if (generalItemView == null) {
            generalItemView = LayoutInflater.from(getContext()).inflate(R.layout.general_item, parent, false);
        }

        GeneralItem currentItem = getItem(position);

        ImageView imageView = (ImageView) generalItemView.findViewById(R.id.general_item_image);
        imageView.setImageResource(currentItem.getImageResourceID());

        TextView titleView = (TextView) generalItemView.findViewById(R.id.general_item_title);
        titleView.setText(currentItem.getTitle());

        return generalItemView;
    }
}
