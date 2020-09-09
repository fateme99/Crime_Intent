package com.example.crimeintent.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.crimeintent.controller.activity.SingleFragmentActivity;
import com.example.crimeintent.controller.fragment.Crime_listFragment;

public class Crime_listActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent=new Intent(context,Crime_listActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new Crime_listFragment();
    }
}