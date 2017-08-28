package com.example.vad.dailyprogress;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubmitHasil extends AppCompatActivity {
    TextView hmitra, halamat, htinggi, hsite, hpondasi, htower, hbow, hdurasi;
    Button blih;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_submit_hasil );
        blih = (Button) findViewById ( R.id.blih );
        blih.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent ( SubmitHasil.this, Outputt.class );
                startActivity ( i );
            }
        } );


        String mitra = getIntent ().getStringExtra ( MainActivity.MITRA );
        String site = getIntent ().getStringExtra ( MainActivity.SITE );
        String tinggi = getIntent ().getStringExtra ( MainActivity.SP_TINGGI );
        String sitetype = getIntent ().getStringExtra ( MainActivity.SPSITE );
        String pondasi = getIntent ().getStringExtra ( MainActivity.SP_PONDASI );
        String tower = getIntent ().getStringExtra ( MainActivity.SP_TOWER );
        String tanggal = getIntent ().getStringExtra ( MainActivity.TGL );
        String durasi = getIntent ().getStringExtra ( MainActivity.TGL );


        TextView hmitra = (TextView) findViewById ( R.id.hmitra );
        hmitra.setText ( mitra );
        TextView halamat = (TextView) findViewById ( R.id.halamat );
        halamat.setText ( site );
        TextView htinggi = (TextView) findViewById ( R.id.htinggi );
        htinggi.setText ( tinggi );
        TextView hsite = (TextView) findViewById ( R.id.hsite );
        hsite.setText ( sitetype );
        TextView hpondasi = (TextView) findViewById ( R.id.hpondasi );
        hpondasi.setText ( pondasi );
        TextView htower = (TextView) findViewById ( R.id.htower );
        htower.setText ( tower );
        TextView hbow = (TextView) findViewById ( R.id.hbow );
        hbow.setText ( tanggal );
        TextView hdurasi = (TextView) findViewById ( R.id.hdurasi );
        hdurasi.setText ( durasi );


    }
}
