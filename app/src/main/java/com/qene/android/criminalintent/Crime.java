package com.qene.android.criminalintent;


import android.text.format.DateFormat;

import java.util.Date;
import java.util.UUID;

/**
 * Created by dave-5cof on 12/2/16.
 */

public class Crime {
    private UUID mID;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public String getDate() {

        // This should be edited out!! Seriously
        return DateFormat.format("dd/mm/yyyy",mDate).toString();
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Crime(){
        mID = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getID() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
