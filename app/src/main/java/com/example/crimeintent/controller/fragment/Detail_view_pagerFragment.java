package com.example.crimeintent.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.crimeintent.R;
import com.example.crimeintent.model.Crime;
import com.example.crimeintent.repository.CrimeRepository;

import java.util.UUID;


public class Detail_view_pagerFragment extends Fragment {

    private TextView mTextView_title,mTextView_desc;
    private Button mButton_date;
    private CheckBox mCheckBox;
    private Crime mCrime;
    private CrimeRepository mCrimeRepository;
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
        mCrimeRepository=CrimeRepository.getInstance();
        mCrime=mCrimeRepository.get((UUID) getArguments().getSerializable(ARGS_CRIME_ID));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_detail_view_pager, container, false);
        findViews(view);
        initView();
        return view;
    }
    private void findViews(View view){
        mTextView_title=view.findViewById(R.id.crime_title);
        mTextView_desc=view.findViewById(R.id.crime_decs);
        mButton_date=view.findViewById(R.id.crime_date);
        mCheckBox=view.findViewById(R.id.crime_solved);
    }
    private void initView(){
        mTextView_title.setText(mCrime.getTitle());
        mTextView_desc.setText(mCrime.getDescription());
        mButton_date.setText(mCrime.getDate().toString());
        mCheckBox.setChecked(mCrime.isSolved());
    }
}