package com.example.crimeintent.repository;

import com.example.crimeintent.model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeRepository implements IRepository<Crime>{
    private List<Crime> mCrimes;
    private static CrimeRepository sInstance;

    private CrimeRepository() {

        mCrimes=new ArrayList<>();
    }

    public CrimeRepository getInstance() {
        if (sInstance==null)
            sInstance=new CrimeRepository();
        return sInstance;
    }

    @Override
    public List getList() {
        return mCrimes;
    }

    @Override
    public Crime get(UUID id) {
        for (Crime crime:mCrimes) {
            if (crime.getUUID().equals(id))
                return crime;
        }
        return null;
    }

    @Override
    public void insert(Crime crime) {
        mCrimes.add(crime);
    }

    @Override
    public void insertList(List list) {
        mCrimes.addAll(list);
    }

    @Override
    public void delete(UUID id) {
        mCrimes.remove(get(id));
    }

    @Override
    public void update(Crime crime) {
        Crime exCrime=get(crime.getUUID());
        exCrime.setTitle(crime.getTitle());
        exCrime.setDescription(crime.getDescription());
        exCrime.setIs_solved(crime.isIs_solved());

    }


}
