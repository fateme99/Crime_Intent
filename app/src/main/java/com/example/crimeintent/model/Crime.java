package com.example.crimeintent.model;

import java.util.UUID;

public class Crime {
    private UUID mUUID;
    private String mTitle;
    private String mDescription;
    private boolean mIs_solved;

    public Crime(String title, String description) {
        mTitle = title;
        mDescription = description;
        mUUID=UUID.randomUUID();
        mIs_solved=false;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public boolean isIs_solved() {
        return mIs_solved;
    }

    public void setIs_solved(boolean is_solved) {
        mIs_solved = is_solved;
    }
}
