package com.qene.android.criminalintent;

import android.content.Context;

/**
 * Created by dave-5cof on 12/5/16.
 */

public class CrimeLab {

    public static CrimeLab sCrimeLab;

    public static CrimeLab get(Context context) {

        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab();
        }
        return sCrimeLab;
    }

    private CrimeLab (){
    }


}
