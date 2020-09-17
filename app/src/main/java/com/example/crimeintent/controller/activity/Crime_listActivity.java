package com.example.crimeintent.controller.activity;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;

import com.example.crimeintent.controller.fragment.Crime_listFragment;
import com.example.crimeintent.repository.CrimeRepository;

public class Crime_listActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent=new Intent(context,Crime_listActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {


        return  Crime_listFragment.newInstance();
    }
}