package com.qene.android.criminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.qene.android.criminalintent.database.CrimeBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by dave-5cof on 12/5/16.
 */

public class CrimeLab {

    public static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CrimeLab get(Context context) {

        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab (Context context){
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
        mCrimes = new ArrayList<>();

    }

    public void addCrime(Crime crime){
        mCrimes.add(crime);
    }

    public void deleteCrime (int crimeIndex){
        mCrimes.remove(crimeIndex);
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID uuid) {
        for (Crime crime: mCrimes) {
            if (crime.getID().equals(uuid))
                return crime;
        }
        return null;
    }

    public int getPosition (Crime crime){
        return mCrimes.indexOf(crime);
    }

}
