package com.example.crimeintent.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crimeintent.R;

import java.util.UUID;


public class Detail_view_pagerFragment extends Fragment {

    public static final String ARGS_CRIME_ID="com.example.crimeintent.crimeId";
    public static Detail_view_pagerFragment newInstance(UUID id) {
        
        Bundle args = new Bundle();
        args.putSerializable(ARGS_CRIME_ID,id);
        Detail_view_pagerFragment fragment = new Detail_view_pagerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public Detail_view_pagerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_detail_view_pager, container, false);
        return view;
    }
}