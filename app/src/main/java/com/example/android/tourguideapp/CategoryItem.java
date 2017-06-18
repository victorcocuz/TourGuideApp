package com.example.android.tourguideapp;

public class CategoryItem {

    private int mCategoryItemImage;
    private String mCategoryItemTitle;
    private String mCategoryItemSubtitle;

    public CategoryItem(int categoryItemImage, String categoryItemTitle, String categoryItemSubtitle) {
        mCategoryItemImage = categoryItemImage;
        mCategoryItemTitle = categoryItemTitle;
        mCategoryItemSubtitle = categoryItemSubtitle;
    }

    public int getCategoryItemImage() {
        return mCategoryItemImage;
    }

    public String getCategoryItemTitle() {
        return mCategoryItemTitle;
    }

    public String getCategryItemSubtitle() {
        return mCategoryItemSubtitle;
    }
}
