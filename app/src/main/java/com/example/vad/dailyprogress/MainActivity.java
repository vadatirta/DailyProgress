package com.example.vad.dailyprogress;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    static final int DATE_ID = 0;
    Spinner spTinggi, spPondasi, spSite, spTower;
    Button btnSubmit;
    EditText editMitra, editSite, tgl;
    DatabaseReference databaseReference;
    int year, month, day, myear, mmonth, mday;
    Calendar C = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOFYear, int dayOfMonth) {
                    myear = year;
                    mmonth = monthOFYear;
                    mday = dayOfMonth;
                    input_tgl();
                }


            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseReference = FirebaseDatabase.getInstance().getReference("Model");
        tgl = (EditText) findViewById(R.id.tgl);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        spTinggi = (Spinner) findViewById(R.id.spTinggi);
        spSite = (Spinner) findViewById(R.id.spSite);
        spPondasi = (Spinner) findViewById(R.id.spPondasi);
        spTower = (Spinner) findViewById(R.id.spTower);
        editMitra = (EditText) findViewById(R.id.editMitra);
        editSite = (EditText) findViewById(R.id.editSite);
        year = C.get(Calendar.YEAR);
        month = C.get(Calendar.MONTH);
        day = C.get(Calendar.DAY_OF_MONTH);
        tgl = (EditText) findViewById(R.id.tgl);
        tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_ID);

            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addModel();
            }
        });

    }

    private void input_tgl() {
        tgl.setText(mday + " - " + (mmonth + 1) + " - " + myear + " ");
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, year, month, day);

        }
        return null;
    }


    private void addModel() {
        String mitra = editMitra.getText().toString().trim();
        String site = editSite.getText().toString().trim();
        String tinggi = spTinggi.getSelectedItem().toString().trim();
        String sitetype = spSite.getSelectedItem().toString().trim();
        String pondasi = spPondasi.getSelectedItem().toString().trim();
        String tower = spTower.getSelectedItem().toString().trim();
        String tanggal = tgl.getText().toString().trim();


        if (!TextUtils.isEmpty(mitra)) {
            Model dataa = new Model(mitra, site, tinggi, sitetype, pondasi, tower, tanggal);

            databaseReference.child(site).setValue(dataa);
            Toast.makeText(this, "Data added, Bowplank mulai dari " + (mday + " - " + (mmonth + 1) + " - " + myear + " ")
                    , Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Inputkan", Toast.LENGTH_LONG).show();
        }


    }

}


