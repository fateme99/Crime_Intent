package com.example.crimeintent.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.crimeintent.controller.activity.SingleFragmentActivity;
import com.example.crimeintent.controller.fragment.Crime_listFragment;

public class Crime_listActivity extends SingleFragmentActivity {



    @Override
    protected Fragment createFragment() {
        return new Crime_listFragment();
    }
}