package com.example.crimeintent.controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.crimeintent.R;


public class Crime_listFragment extends Fragment {
    private RecyclerView mRecyclerView;

    public Crime_listFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_crime_list, container, false);
        findViews(view);
        initView();
        return view;
    }
    private void findViews(View view){
        mRecyclerView=view.findViewById(R.id.recycler_crime_list);
    }
    private void initView(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    private class CrimeHolder extends RecyclerView.ViewHolder<CrimeHolder>{

        public CrimeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}