package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class CategoryActivityPubs extends AppCompatActivity {

    private int[] pubImage = {R.drawable.pub_1, R.drawable.pub_2, R.drawable.pub_3, R.drawable.pub_4, R.drawable.pub_5, R.drawable.pub_6, R.drawable.pub_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final String[] pubTitle = getResources().getStringArray(R.array.pub_title);
        final String[] pubType = getResources().getStringArray(R.array.pub_type);
        final String[] pubPrice = getResources().getStringArray(R.array.pub_price);
        final String[] pubAddress = getResources().getStringArray(R.array.pub_address);
        final String[] pubContact = getResources().getStringArray(R.array.pub_contact);
        final String[] pubHours = getResources().getStringArray(R.array.pub_hours);
        ArrayList<CategoryItem> items = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            items.add(new CategoryItem(pubImage[i], pubTitle[i], pubType[i]));
        }

        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.category_list_view);
        listView.setAdapter(categoryItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivityPubs.this, DescriptionActivity.class);
                intent.putExtra("image", pubImage[position]);
                intent.putExtra("title", pubTitle[position]);
                intent.putExtra("type", pubType[position]);
                intent.putExtra("price", pubPrice[position]);
                intent.putExtra("address", pubAddress[position]);
                intent.putExtra("contact", pubContact[position]);
                intent.putExtra("hours", pubHours[position]);
                startActivity(intent);
            }
        });
    }
}
