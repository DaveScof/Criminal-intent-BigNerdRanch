package com.qene.android.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by dave-5cof on 12/2/16.
 */

public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";
    private static final String EXTRA_DATA_CHANGED = "data_changed";
    private static final String EXTRA_CHANGE_POSITION = "change_position";
    private static final String DIALOG_DATE = "DialogDate";
    private static final String DIALOG_TIME = "DialogTime";
    private static final int REQUEST_DATE = 0;
    private static final int REQUEST_TIME = 1;

    private Crime mCrime;
    private EditText mEditText;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private boolean mDataChanged = false;
    private int mChangePosition;
    private Button mTimeButton;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
        mChangePosition = CrimeLab.get(getActivity()).getPosition(mCrime);
    }

    public static CrimeFragment newInstance (UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);
        mEditText = (EditText) view.findViewById(R.id.crime_title_editText);
        mEditText.setText(mCrime.getTitle());
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCrime.setTitle(charSequence.toString());
                mDataChanged = true;
                setActivityResult();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        mDateButton = (Button) view.findViewById(R.id.crime_date_button);
        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mCrime.getDate());
                dialog.setTargetFragment(CrimeFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
                mDataChanged = true;
                setActivityResult();
            }
        });

        mTimeButton = (Button) view.findViewById(R.id.crime_time_button);
        upDateTime();
        mTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment fragment = TimePickerFragment.newInstance(new Time(mCrime.getDate().getTime()));
                fragment.setTargetFragment(CrimeFragment.this,REQUEST_TIME);
                fragment.show(getFragmentManager(),DIALOG_TIME);

            }
        });
        mSolvedCheckBox = (CheckBox) view.findViewById(R.id.crime_solved_checkbox);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCrime.setSolved(b);
                mDataChanged = true;
                setActivityResult();
            }
        });

        return view;
    }

    private void setActivityResult (){
        Intent data = new Intent();
        data.putExtra(EXTRA_DATA_CHANGED, mDataChanged);
        data.putExtra(EXTRA_CHANGE_POSITION, mChangePosition);

        getActivity().setResult(Activity.RESULT_OK, data);
    }

    public static boolean wasDataChanged (Intent result){
        return result.getBooleanExtra(EXTRA_DATA_CHANGED, false);
    }

    public static int changedPosition(Intent result){
        return result.getIntExtra(EXTRA_CHANGE_POSITION, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK)
            return;

        if (requestCode == REQUEST_DATE){
            mCrime.setDate(DatePickerFragment.getDate(data));
            updateDate();
        }

        if (requestCode == REQUEST_TIME){
            mCrime.setDate(TimePickerFragment.getDate(data));
            upDateTime();
        }
    }

    private void updateDate() {
        mDateButton.setText(mCrime.getDate().toString());
    }

    private void upDateTime() {
        mTimeButton.setText(new Time(mCrime.getDate().getTime()).toString());
    }
}
