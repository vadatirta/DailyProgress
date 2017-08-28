package com.example.vad.dailyprogress;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    public static final String MITRA = "Mitra";
    public static final String SITE = "site";
    public static final String SP_TINGGI = "spTinggi";
    public static final String TOWER = "tower";
    public static final String DURASI = "durasi";
    public static final String SITETYPE = "sitetype";
    public static final String PONDASI = "pondasi";
    public static final String TGL = "tgl";
    public static final String SP_TOWER = "spTower";
    public static final String SP_PONDASI = "spPondasi";
    public static final String SPSITE = "spsite";
    static final int DATE_ID = 0;
    Button btnSubmit;
    EditText editMitra, editSite, tgl, hd;
    DatabaseReference databaseReference;
    int year, month, day, myear, mmonth, mday;
    Calendar C = Calendar.getInstance();
    private Spinner spTinggi;
    private Spinner spPondasi;
    private Spinner spSite;
    private Spinner spTower;
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOFYear, int dayOfMonth) {
                    myear = year;
                    mmonth = monthOFYear;
                    mday = dayOfMonth;
                    input_tgl();
                }


            };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseReference = FirebaseDatabase.getInstance().getReference("Model");
        tgl = (EditText) findViewById(R.id.tgl);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        spTinggi = (Spinner) findViewById(R.id.spTinggi);
        String[] tinggi = {"15/20", "32", "42", "52", "62", "72"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String> ( this, android.R.layout.simple_spinner_dropdown_item, tinggi );
        spTinggi.setAdapter ( adapter );

        spSite = (Spinner) findViewById(R.id.spSite);
        String[] site = {"Monopole", "SST"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String> ( this, android.R.layout.simple_spinner_dropdown_item, site );
        spSite.setAdapter ( adapter1 );

        spPondasi = (Spinner) findViewById(R.id.spPondasi);
        String[] pondasi = {"Bor pile", "Raft", "Stacking Gedung"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String> ( this, android.R.layout.simple_spinner_dropdown_item, pondasi );
        spPondasi.setAdapter ( adapter2 );


        spTower = (Spinner) findViewById(R.id.spTower);
        String[] tower = {"Green Field", "Roof Top"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String> ( this, android.R.layout.simple_spinner_dropdown_item, tower );
        spTower.setAdapter ( adapter3 );

        editMitra = (EditText) findViewById(R.id.editMitra);
        editSite = (EditText) findViewById(R.id.editSite);
        hd = (EditText) findViewById ( R.id.hd );

        year = C.get(Calendar.YEAR);
        month = C.get(Calendar.MONTH);
        day = C.get(Calendar.DAY_OF_MONTH);


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


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder ( this ).addApi ( AppIndex.API ).build ();
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

            Intent intent = new Intent ( MainActivity.this, SubmitHasil.class );
            intent.putExtra ( MITRA, mitra );
            intent.putExtra ( SITE, site );
            intent.putExtra ( SP_TINGGI, tinggi );
            intent.putExtra ( SPSITE, sitetype );
            intent.putExtra ( SP_PONDASI, pondasi );
            intent.putExtra ( SP_TOWER, tower );
            intent.putExtra ( TGL, tanggal );


            startActivity ( intent );


        } else {
            Toast.makeText ( this, "Inputkan", Toast.LENGTH_LONG ).show ();
        }


        if (!TextUtils.isEmpty ( mitra )) {
            Model dataa = new Model(mitra, site, tinggi, sitetype, pondasi, tower, tanggal);

            databaseReference.child(site).setValue(dataa);
            Toast.makeText(this, "Data added, Bowplank mulai dari " + (mday + " - " + (mmonth + 1) + " - " + myear + " ")
                    , Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Inputkan", Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public void onStart() {
        super.onStart ();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect ();
        Action viewAction = Action.newAction (
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse ( "http://host/path" ),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse ( "android-app://com.example.vad.dailyprogress/http/host/path" )
        );
        AppIndex.AppIndexApi.start ( client, viewAction );
    }

    @Override
    public void onStop() {
        super.onStop ();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction (
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse ( "http://host/path" ),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse ( "android-app://com.example.vad.dailyprogress/http/host/path" )
        );
        AppIndex.AppIndexApi.end ( client, viewAction );
        client.disconnect ();
    }
}


