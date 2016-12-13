package com.qene.android.criminalintent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.Date;

/**
 * Created by dave-5cof on 12/13/16.
 */

public class DateDialogActivity extends SingleFragmentActivity {
    private static final String EXTRA_DATE = "com.qene.android.criminalintent";

    @Override
    protected Fragment createFragment() {
        Date date = (Date) getIntent().getSerializableExtra(EXTRA_DATE);
        return DatePickerFragment.newInstance(date);
    }

    public static Intent setDateIntent (Context packageContext, Date date){
        Intent intent = new Intent(packageContext, DateDialogActivity.class);
        intent.putExtra(EXTRA_DATE, date);

        return intent;
    }

}