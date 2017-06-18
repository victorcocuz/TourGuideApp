package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentAdapter(Context Context, FragmentManager fm) {
        super(fm);
        mContext = Context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentPopular();
        }
        if (position == 1) {
            return new FragmentCategories();
        } else {
            return new FragmentCollections();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.fragment_popular);
        }
        if (position == 1) {
            return mContext.getString(R.string.fragment_categories);
        } else {
            return mContext.getString(R.string.fragment_collections);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}