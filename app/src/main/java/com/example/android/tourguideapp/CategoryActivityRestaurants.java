package com.example.android.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class CategoryActivityRestaurants extends AppCompatActivity {

    private int[] restaurantImage = {R.drawable.restaurant_1, R.drawable.restaurant_2, R.drawable.restaurant_3, R.drawable.restaurant_4, R.drawable.restaurant_5, R.drawable.restaurant_6, R.drawable.restaurant_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final String[] restaurantTitle = getResources().getStringArray(R.array.restaurants_title);
        final String[] restaurantType = getResources().getStringArray(R.array.restaurants_type);
        final String[] restaurantPrice = getResources().getStringArray(R.array.restaurants_price);
        final String[] restaurantAddress = getResources().getStringArray(R.array.restaurants_address);
        final String[] restaurantContact = getResources().getStringArray(R.array.restaurants_contact);
        final String[] restaurantHours = getResources().getStringArray(R.array.restaurants_hours);
        ArrayList<CategoryItem> items = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            items.add(new CategoryItem(restaurantImage[i], restaurantTitle[i], restaurantType[i]));
        }

        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.category_list_view);
        listView.setAdapter(categoryItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivityRestaurants.this, DescriptionActivity.class);
                intent.putExtra("image", restaurantImage[position]);
                intent.putExtra("title", restaurantTitle[position]);
                intent.putExtra("type", restaurantType[position]);
                intent.putExtra("price", restaurantPrice[position]);
                intent.putExtra("address", restaurantAddress[position]);
                intent.putExtra("contact", restaurantContact[position]);
                intent.putExtra("hours", restaurantHours[position]);
                startActivity(intent);
            }
        });
    }
}
