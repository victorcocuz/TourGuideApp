package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class CategoryActivitySports extends AppCompatActivity {

    private int[] sportsImage = {R.drawable.sports_1, R.drawable.sports_2, R.drawable.sports_3, R.drawable.sports_4, R.drawable.sports_5, R.drawable.sports_6, R.drawable.sports_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final String[] sportsTitle = getResources().getStringArray(R.array.sports_title);
        final String[] sportsType = getResources().getStringArray(R.array.sports_type);
        final String[] sportsPrice = getResources().getStringArray(R.array.sports_price);
        final String[] sportsAddress = getResources().getStringArray(R.array.sports_address);
        final String[] sportsContact = getResources().getStringArray(R.array.sports_contact);
        final String[] sportsHours = getResources().getStringArray(R.array.sports_hours);
        ArrayList<CategoryItem> items = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            items.add(new CategoryItem(sportsImage[i], sportsTitle[i], sportsType[i]));
        }

        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.category_list_view);
        listView.setAdapter(categoryItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivitySports.this, DescriptionActivity.class);
                intent.putExtra("image", sportsImage[position]);
                intent.putExtra("title", sportsTitle[position]);
                intent.putExtra("type", sportsType[position]);
                intent.putExtra("price", sportsPrice[position]);
                intent.putExtra("address", sportsAddress[position]);
                intent.putExtra("contact", sportsContact[position]);
                intent.putExtra("hours", sportsHours[position]);
                startActivity(intent);
            }
        });
    }
}
