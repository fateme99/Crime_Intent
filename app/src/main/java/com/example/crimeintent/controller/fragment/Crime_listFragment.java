package com.example.crimeintent.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crimeintent.R;
import com.example.crimeintent.controller.activity.Crime_listActivity;
import com.example.crimeintent.controller.activity.Detail_view_pagerActivity;
import com.example.crimeintent.model.Crime;
import com.example.crimeintent.repository.CrimeRepository;

import java.util.List;


public class Crime_listFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private CrimeRepository mCrimeRepository;

    public Crime_listFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrimeRepository=CrimeRepository.getInstance();

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
        mRecyclerView.setAdapter(new CrimeAdapter(mCrimeRepository.getList()));
    }
    private class CrimeHolder extends RecyclerView.ViewHolder{
        TextView mTextView_title;
        TextView mTextView_desc;
        ImageView mImageView_pic;
        Crime mCrime;
        public CrimeHolder(@NonNull final View itemView) {
            super(itemView);
            mTextView_title=itemView.findViewById(R.id.item_title);
            mTextView_desc=itemView.findViewById(R.id.item_desc);
            mImageView_pic=itemView.findViewById(R.id.item_pic);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=Detail_view_pagerActivity.newIntent(getActivity(),mCrime.getUUID());
                    startActivity(intent);
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

}