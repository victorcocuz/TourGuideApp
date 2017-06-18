package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;

public class FragmentCategories extends Fragment {

    private HashMap<String, Class> hashMap = new HashMap<>();
    private String[] hashMapString;
    private int[] categoriesImages = {R.drawable.categories_1, R.drawable.categories_2, R.drawable.categories_3, R.drawable.categories_4, R.drawable.categories_5, R.drawable.categories_6};

    public FragmentCategories() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_categories, container, false);

        String[] categoriesTitle = getResources().getStringArray(R.array.categories_title);

        hashMapString = getResources().getStringArray(R.array.categories_title);

        hashMap.put(hashMapString[0], CategoryActivityRestaurants.class);
        hashMap.put(hashMapString[1], CategoryActivityPubs.class);
        hashMap.put(hashMapString[2], CategoryActivityEntertainment.class);
        hashMap.put(hashMapString[3], CategoryActivityOutdoors.class);
        hashMap.put(hashMapString[4], CategoryActivityArt.class);
        hashMap.put(hashMapString[5], CategoryActivitySports.class);

        ArrayList<GeneralItem> categories = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            categories.add(new GeneralItem(categoriesImages[i], categoriesTitle[i]));
        }

        GeneralItemAdapter generalItemAdapter = new GeneralItemAdapter(getActivity(), categories);
        GridView gridView = (GridView) rootView.findViewById(R.id.categories_list_view);
        gridView.setAdapter(generalItemAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), hashMap.get(hashMapString[position]));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
