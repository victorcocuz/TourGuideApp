package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class CategoryActivityEntertainment extends AppCompatActivity {

    private int[] entertainmentImage = {R.drawable.entertainment_1, R.drawable.entertainment_2, R.drawable.entertainment_3, R.drawable.entertainment_4, R.drawable.entertainment_5, R.drawable.entertainment_6, R.drawable.entertainment_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final String[] entertainmentTitle = getResources().getStringArray(R.array.entertainment_title);
        final String[] entertainmentType = getResources().getStringArray(R.array.entertainment_type);
        final String[] entertainmentPrice = getResources().getStringArray(R.array.entertainment_price);
        final String[] entertainmentAddress = getResources().getStringArray(R.array.entertainment_address);
        final String[] entertainmentContact = getResources().getStringArray(R.array.entertainment_contact);
        final String[] entertainmentHours = getResources().getStringArray(R.array.entertainment_hours);
        ArrayList<CategoryItem> items = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            items.add(new CategoryItem(entertainmentImage[i], entertainmentTitle[i], entertainmentType[i]));
        }

        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.category_list_view);
        listView.setAdapter(categoryItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivityEntertainment.this, DescriptionActivity.class);
                intent.putExtra("image", entertainmentImage[position]);
                intent.putExtra("title", entertainmentTitle[position]);
                intent.putExtra("type", entertainmentType[position]);
                intent.putExtra("price", entertainmentPrice[position]);
                intent.putExtra("address", entertainmentAddress[position]);
                intent.putExtra("contact", entertainmentContact[position]);
                intent.putExtra("hours", entertainmentHours[position]);
                startActivity(intent);
            }
        });
    }
}
