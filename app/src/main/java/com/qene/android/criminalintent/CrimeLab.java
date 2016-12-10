package com.qene.android.criminalintent;

import android.content.Context;

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

    public static CrimeLab get(Context context) {

        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab();
        }
        return sCrimeLab;
    }

    private CrimeLab (){
        mCrimes = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Random rand = new Random();
            Crime crime = new Crime();
            crime.setSolved(rand.nextInt(2) == 0);
            crime.setTitle("Crime #" + i);
            mCrimes.add(crime);
        }
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
}
