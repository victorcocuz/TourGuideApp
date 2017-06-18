package com.example.android.tourguideapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager generalViewPager = (ViewPager) findViewById(R.id.general_view_pager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this, getSupportFragmentManager());
        generalViewPager.setAdapter(fragmentAdapter);

        TabLayout generalTabLayout = (TabLayout) findViewById(R.id.general_tab_layout);
        generalTabLayout.setupWithViewPager(generalViewPager);
    }

}
