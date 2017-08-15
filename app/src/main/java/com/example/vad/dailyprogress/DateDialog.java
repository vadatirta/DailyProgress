package com.example.vad.dailyprogress;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by VAD on 14/08/2017.
 */
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    EditText tgl;

    public DateDialog(View view) {
        tgl = (EditText) view;
    }

    public Dialog OnCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        String date = day + "/" + (month + 1) + "/" + year;
        tgl.setText(date);
    }

}
