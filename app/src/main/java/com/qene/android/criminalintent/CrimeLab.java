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
    }

    public void addCrime(Crime crime){

    }

    public void deleteCrime (int crimeIndex){

    }

    public List<Crime> getCrimes() {
        return new ArrayList<>();
    }

    public Crime getCrime(UUID uuid) {
        return null;
    }

    public int getPosition (Crime crime){
        return 0;
    }

}
