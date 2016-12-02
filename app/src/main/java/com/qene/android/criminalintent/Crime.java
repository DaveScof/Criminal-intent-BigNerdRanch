package com.qene.android.criminalintent;

import java.util.UUID;

/**
 * Created by dave-5cof on 12/2/16.
 */

public class Crime {
    private UUID mID;
    private String mTitle;

    public Crime(){
        mID = UUID.randomUUID();
    }

    public UUID getmID() {
        return mID;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

}
