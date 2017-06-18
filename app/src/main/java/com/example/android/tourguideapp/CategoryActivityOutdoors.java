package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class CategoryActivityOutdoors extends AppCompatActivity {

    private int[] outdoorsImage = {R.drawable.outdoors_1, R.drawable.outdoors_2, R.drawable.outdoors_3, R.drawable.outdoors_4, R.drawable.outdoors_5, R.drawable.outdoors_6, R.drawable.outdoors_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final String[] outdoorsTitle = getResources().getStringArray(R.array.outdoors_title);
        final String[] outdoorsType = getResources().getStringArray(R.array.outdoors_type);
        final String[] outdoorsPrice = getResources().getStringArray(R.array.outdoors_price);
        final String[] outdoorsAddress = getResources().getStringArray(R.array.outdoors_address);
        final String[] outdoorsContact = getResources().getStringArray(R.array.outdoors_contact);
        final String[] outdoorsHours = getResources().getStringArray(R.array.outdoors_hours);
        ArrayList<CategoryItem> items = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            items.add(new CategoryItem(outdoorsImage[i], outdoorsTitle[i], outdoorsType[i]));
        }

        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.category_list_view);
        listView.setAdapter(categoryItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivityOutdoors.this, DescriptionActivity.class);
                intent.putExtra("image", outdoorsImage[position]);
                intent.putExtra("title", outdoorsTitle[position]);
                intent.putExtra("type", outdoorsType[position]);
                intent.putExtra("price", outdoorsPrice[position]);
                intent.putExtra("address", outdoorsAddress[position]);
                intent.putExtra("contact", outdoorsContact[position]);
                intent.putExtra("hours", outdoorsHours[position]);
                startActivity(intent);
            }
        });
    }
}
