package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;


public class FragmentCollections extends Fragment {

    private int[] favoritesImage = {R.drawable.favorites_1, R.drawable.favorites_2, R.drawable.favorites_3};

    public FragmentCollections() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_category, container, false);

        final String[] favoritesTitle = getResources().getStringArray(R.array.favorites_title);
        final String[] favoritesType = getResources().getStringArray(R.array.favorites_type);
        ArrayList<CategoryItem> items = new ArrayList<>();

        for (int i = 0; i <= 2; i++) {
            items.add(new CategoryItem(favoritesImage[i], favoritesTitle[i], favoritesType[i]));
        }

        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.category_list_view);
        listView.setAdapter(categoryItemAdapter);

        return rootView;
    }

}
