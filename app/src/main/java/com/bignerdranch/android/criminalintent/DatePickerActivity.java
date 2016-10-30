package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.Date;

public class DatePickerActivity extends SingleFragmentActivity{

    private static final String EXTRA_DIALOG_DATE = "com.bignerdranch.android.criminalintent.dialog_date";
    public static final String EXTRA_DATE ="com.bignerdranch.android.criminalintent.date";

    public static Intent newIntent(Context packageContext, Date date){
        Intent intent = new Intent(packageContext, DatePickerActivity.class);
        intent.putExtra(EXTRA_DIALOG_DATE, date);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        Date date = (Date)getIntent().getSerializableExtra(EXTRA_DIALOG_DATE);
        return DatePickerFragment.newInstance(date);
    }

    public void setDialogDateResult(Date date) {
        /*
        if (getTargetFragment() == null) {
            return;
        }*/

        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, date);
        setResult(RESULT_OK, intent);

        /*
        getTargetFragment()
                .onActivityResult(getTargetRequestCode(), resultCode, intent);*/
    }
}
