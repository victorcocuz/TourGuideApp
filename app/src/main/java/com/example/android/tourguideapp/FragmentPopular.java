package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class FragmentPopular extends Fragment {

    private int[] popularImage = {R.drawable.popular_1, R.drawable.popular_2, R.drawable.popular_3, R.drawable.popular_4, R.drawable.popular_5, R.drawable.popular_6, R.drawable.popular_7};

    public FragmentPopular() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_category, container, false);

        final String[] popularTitle = getResources().getStringArray(R.array.popular_title);
        final String[] popularType = getResources().getStringArray(R.array.popular_type);
        final String[] popularPrice = getResources().getStringArray(R.array.popular_price);
        final String[] popularAddress = getResources().getStringArray(R.array.popular_address);
        final String[] popularContact = getResources().getStringArray(R.array.popular_contact);
        final String[] popularHours = getResources().getStringArray(R.array.popular_hours);
        ArrayList<CategoryItem> items = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            items.add(new CategoryItem(popularImage[i], popularTitle[i], popularType[i]));
        }

        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.category_list_view);
        listView.setAdapter(categoryItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                intent.putExtra("image", popularImage[position]);
                intent.putExtra("title", popularTitle[position]);
                intent.putExtra("type", popularType[position]);
                intent.putExtra("price", popularPrice[position]);
                intent.putExtra("address", popularAddress[position]);
                intent.putExtra("contact", popularContact[position]);
                intent.putExtra("hours", popularHours[position]);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
