package com.qene.android.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.qene.android.criminalintent.Crime;
import com.qene.android.criminalintent.database.CrimeDbSchema.CrimeTable;

/**
 * Created by dave-5cof on 12/19/16.
 */

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime (){
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));

        return null;
    }

}