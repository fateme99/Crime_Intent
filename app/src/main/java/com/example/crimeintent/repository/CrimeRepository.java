package com.example.crimeintent.repository;

import com.example.crimeintent.model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public  class CrimeRepository implements IRepository<Crime>{
    private List<Crime> mCrimes;
    private static CrimeRepository sInstance;

    private CrimeRepository() {

        mCrimes=new ArrayList<>();
        mCrimes.add(new Crime("crime1","description for crim1"));
        mCrimes.add(new Crime("crime2","description for crim2"));
        mCrimes.add(new Crime("crime3","description for crim3"));
        mCrimes.add(new Crime("crime4","description for crim4"));
        mCrimes.add(new Crime("crime5","description for crim5"));
        mCrimes.add(new Crime("crime6","description for crim6"));
        mCrimes.add(new Crime("crime7","description for crim7"));
        mCrimes.add(new Crime("crime8","description for crim8"));
        mCrimes.add(new Crime("crime9","description for crim9"));
        mCrimes.add(new Crime("crime10","description for crim10"));
        mCrimes.add(new Crime("crime11","description for crim11"));
        mCrimes.add(new Crime("crime12","description for crim12"));
        mCrimes.add(new Crime("crime13","description for crim13"));
        mCrimes.add(new Crime("crime14","description for crim14"));
        mCrimes.add(new Crime("crime15","description for crim15"));
        mCrimes.add(new Crime("crime16","description for crim16"));
        mCrimes.add(new Crime("crime17","description for crim17"));
    }

    public static CrimeRepository getInstance() {
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
        exCrime.setSolved(crime.isSolved());

    }


}
