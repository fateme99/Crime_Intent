package com.example.crimeintent.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crimeintent.R;
import com.example.crimeintent.controller.activity.Crime_listActivity;
import com.example.crimeintent.controller.activity.Detail_view_pagerActivity;
import com.example.crimeintent.model.Crime;
import com.example.crimeintent.repository.CrimeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Crime_listFragment extends Fragment {
    private Button mButton_add;
    private RecyclerView mRecyclerView;
    private CrimeRepository mCrimeRepository;
    private List<UUID>deleteitems;
    private CrimeAdapter mAdapter;
    private FrameLayout mFrameLayout;

    public Crime_listFragment() {
        // Required empty public constructor
    }

    public static Crime_listFragment newInstance() {
        
        Bundle args = new Bundle();
        
        Crime_listFragment fragment = new Crime_listFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrimeRepository=CrimeRepository.getInstance();
        deleteitems=new ArrayList<>();
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.detail_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_menuItem:
                for (int i = 0; i <deleteitems.size() ; i++) {
                    CrimeRepository.getInstance().delete(deleteitems.get(i));
                }
                updateView();


                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_crime_list, container, false);
        findViews(view);
        setListenes();
        initView();
        return view;
    }
    private void findViews(View view){
        mRecyclerView=view.findViewById(R.id.recycler_crime_list);
        mButton_add=view.findViewById(R.id.add_btn);
        mFrameLayout=view.findViewById(R.id.empty_framLayout);
    }
    private void setListenes(){
        mButton_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crime crime=new Crime();
                CrimeRepository.getInstance().insert(crime);
                Intent intent= Detail_view_pagerActivity.newIntent(getActivity(),crime.getUUID());
                startActivity(intent);


            }
        });
    }
    private void initView(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateView();
    }
    private class CrimeHolder extends RecyclerView.ViewHolder{
        TextView mTextView_title;
        TextView mTextView_desc;
        ImageView mImageView_pic;
        CheckBox mCheckBox;
        Crime mCrime;
        public CrimeHolder(@NonNull final View itemView) {
            super(itemView);
            mTextView_title=itemView.findViewById(R.id.item_title);
            mTextView_desc=itemView.findViewById(R.id.item_desc);
            mImageView_pic=itemView.findViewById(R.id.item_pic);
            mCheckBox=itemView.findViewById(R.id.checkbox_selected);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=Detail_view_pagerActivity.newIntent(getActivity(),mCrime.getUUID());
                    startActivity(intent);
                }
            });
            mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (mCheckBox.isChecked()){
                        deleteitems.add(mCrime.getUUID());
                    }
                    else {
                        deleteitems.remove(mCrime.getUUID());
                    }
                }
            });
        }
        public void bindCrime(Crime crime){
            mCrime=crime;
            mTextView_title.setText(mCrime.getTitle());
            mTextView_desc.setText(mCrime.getDescription());
            //mImageView_pic.setImageResource(R.drawable.ic_handcuffs);
            mImageView_pic.setVisibility(mCrime.isSolved()?View.VISIBLE:View.INVISIBLE);
        }

    }
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime>mCrimes;

        public List<Crime> getCrimes() {
            return mCrimes;
        }

        public void setCrimes(List<Crime> crimes) {
            mCrimes = crimes;
        }

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(getActivity()).inflate(R.layout.fragment_crime_item,parent,false);
            CrimeHolder crimeHolder=new CrimeHolder(view);
            return crimeHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            holder.bindCrime(mCrimes.get(position));
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
    private void updateView(){

        if (CrimeRepository.getInstance().getList().size()==0){
            mFrameLayout.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }
        else {
            mFrameLayout.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            List<Crime> crimes = CrimeRepository.getInstance().getList();

            if ( mAdapter== null) {
                mAdapter = new CrimeAdapter(crimes);
                mRecyclerView.setAdapter(mAdapter);
            } else {
                mAdapter.notifyDataSetChanged();
            }
        }


    }

}