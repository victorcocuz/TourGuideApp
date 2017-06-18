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

public class CategoryItemAdapter extends ArrayAdapter<CategoryItem> {
    public CategoryItemAdapter(Activity context, ArrayList<CategoryItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View categoryItemView = convertView;
        if (categoryItemView == null) {
            categoryItemView = LayoutInflater.from(getContext()).inflate(R.layout.category_item, parent, false);
        }

        CategoryItem currentItem = getItem(position);

        ImageView imageView = (ImageView) categoryItemView.findViewById(R.id.category_item_image);
        imageView.setImageResource(currentItem.getCategoryItemImage());

        TextView titleView = (TextView) categoryItemView.findViewById(R.id.category_item_title);
        titleView.setText(currentItem.getCategoryItemTitle());

        TextView subtitleView = (TextView) categoryItemView.findViewById(R.id.category_item_type);
        subtitleView.setText(currentItem.getCategryItemSubtitle());

        return categoryItemView;
    }
}
