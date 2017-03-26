package com.qene.android.criminalintent;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by dave-5cof on 12/5/16.
 */

public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.CallBack, CrimeFragment.CallBack {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId(){
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detail_fragment_container) == null){
            Intent intent = CrimePagerActivity.newIntent(this, crime.getID());
            startActivity(intent);
        }
        else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getID());
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.detail_fragment_container, newDetail).
                    commit();
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {
        CrimeListFragment listFragment = (CrimeListFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.detail_fragment_container);
        listFragment.updateUI();
    }
}
