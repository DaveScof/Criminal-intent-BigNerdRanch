package com.qene.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by dave-5cof on 12/5/16.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
