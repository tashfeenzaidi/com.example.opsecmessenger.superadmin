package com.example.opsecmessenger_admin.models;

import android.graphics.drawable.Drawable;

public class AnalyticsViewPagerModel {

    String title;
    Drawable image;

    public AnalyticsViewPagerModel(String title, Drawable image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getImage() {
        return image;
    }
}
