package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Bundle extras = getIntent().getExtras();

        ImageView imageView = (ImageView) findViewById(R.id.description_image);
        imageView.setImageResource(extras.getInt("image"));

        TextView titleView = (TextView) findViewById(R.id.description_title);
        titleView.setText(extras.getString("title"));

        TextView typeView = (TextView) findViewById(R.id.description_type);
        typeView.setText(extras.getString("type"));

        TextView priceView = (TextView) findViewById(R.id.description_price);
        priceView.setText(extras.getString("price"));

        TextView addressView = (TextView) findViewById(R.id.description_address);
        addressView.setText(extras.getString("address"));

        TextView contactView = (TextView) findViewById(R.id.description_contact);
        contactView.setText(extras.getString("contact"));

        TextView hoursMondayView = (TextView) findViewById(R.id.description_hours_monday);
        hoursMondayView.setText(extras.getString("hours"));

        TextView hoursTuesdayView = (TextView) findViewById(R.id.description_hours_tuesday);
        hoursTuesdayView.setText(extras.getString("hours"));

        TextView hoursWednesdayView = (TextView) findViewById(R.id.description_hours_wednesday);
        hoursWednesdayView.setText(extras.getString("hours"));

        TextView hoursThursdayView = (TextView) findViewById(R.id.description_hours_thursday);
        hoursThursdayView.setText(extras.getString("hours"));

        TextView hoursFridayView = (TextView) findViewById(R.id.description_hours_friday);
        hoursFridayView.setText(extras.getString("hours"));

        TextView hoursSaturdayView = (TextView) findViewById(R.id.description_hours_saturday);
        hoursSaturdayView.setText(extras.getString("hours"));

        TextView hoursSundayView = (TextView) findViewById(R.id.description_hours_sunday);
        hoursSundayView.setText(extras.getString("hours"));
    }
}
