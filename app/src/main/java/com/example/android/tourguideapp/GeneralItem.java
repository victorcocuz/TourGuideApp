package com.example.android.tourguideapp;


public class GeneralItem {

    private int mImageResourceID;
    private String mTitle;

    public GeneralItem(int imageResourceID, String title) {

        mImageResourceID = imageResourceID;
        mTitle = title;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

    public String getTitle() {
        return mTitle;
    }
}
