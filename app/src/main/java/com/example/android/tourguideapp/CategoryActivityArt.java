package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class CategoryActivityArt extends AppCompatActivity {

    private int[] artImage = {R.drawable.art_1, R.drawable.art_2, R.drawable.art_3, R.drawable.art_4, R.drawable.art_5, R.drawable.art_6, R.drawable.art_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final String[] artTitle = getResources().getStringArray(R.array.art_title);
        final String[] artType = getResources().getStringArray(R.array.art_type);
        final String[] artPrice = getResources().getStringArray(R.array.art_price);
        final String[] artAddress = getResources().getStringArray(R.array.art_address);
        final String[] artContact = getResources().getStringArray(R.array.art_contact);
        final String[] artHours = getResources().getStringArray(R.array.art_hours);
        ArrayList<CategoryItem> items = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            items.add(new CategoryItem(artImage[i], artTitle[i], artType[i]));
        }

        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.category_list_view);
        listView.setAdapter(categoryItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivityArt.this, DescriptionActivity.class);
                intent.putExtra("image", artImage[position]);
                intent.putExtra("title", artTitle[position]);
                intent.putExtra("type", artType[position]);
                intent.putExtra("price", artPrice[position]);
                intent.putExtra("address", artAddress[position]);
                intent.putExtra("contact", artContact[position]);
                intent.putExtra("hours", artHours[position]);
                startActivity(intent);
            }
        });
    }
}
