package com.example.crimeintent.model;

import java.util.UUID;

public class Crime {
    private UUID mUUID;
    private String mTitle;
    private String mDescription;
    private boolean solved;

    public Crime(String title, String description) {
        mTitle = title;
        mDescription = description;
        mUUID=UUID.randomUUID();
        solved =true;
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

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
