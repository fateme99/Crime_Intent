package com.example.crimeintent.controller.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.crimeintent.R;
import com.example.crimeintent.controller.activity.Detail_view_pagerActivity;
import com.example.crimeintent.model.Crime;
import com.example.crimeintent.repository.CrimeRepository;


public class EmptyFragment extends Fragment {

    private Button mButton_add;
    public EmptyFragment() {
        // Required empty public constructor
    }

    public static EmptyFragment newInstance() {

        Bundle args = new Bundle();

        EmptyFragment fragment = new EmptyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_empty, container, false);
        findViews(view);
        setListeners();
        return view;
    }
    private void findViews(View view){
        mButton_add=view.findViewById(R.id.add_btn);
    }
    private void setListeners(){
        mButton_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crime crime=new Crime();
                CrimeRepository.getInstance().insert(crime);
                Intent intent= Detail_view_pagerActivity.newIntent(getActivity(),crime.getUUID());
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}