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
    private String mSuspect;

    public Date getDate() {

        // This should be edited out!! Seriously
        return mDate;
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
        this(UUID.randomUUID());
    }

    public Crime (UUID uuid){
        mID = uuid;
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

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public String getPhotoFileName(){
        return "IMG_" + getID().toString() + ".jpg";
    }
}
