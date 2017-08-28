package com.example.vad.dailyprogress;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vad.dailyprogress.adapter.TahapAdapter;
import com.example.vad.dailyprogress.model.Tahap;

import java.util.ArrayList;

public class ProsesTahapan extends Fragment {
    ArrayList<Tahap> mList = new ArrayList<> ();
    TahapAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate ( R.layout.activity_proses_tahapan, null );

        RecyclerView recyclerView = (RecyclerView) v.findViewById ( R.id.rv );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager ( this.getContext () );
        recyclerView.setLayoutManager ( layoutManager );
        mAdapter = new TahapAdapter ( mList );
        recyclerView.setAdapter ( mAdapter );


        fillData ();
        return v;
    }

    private void fillData() {
        Resources resources = getResources ();
        String[] artahap = resources.getStringArray ( R.array.tahapan );

        for (int i = 0; i < artahap.length; i++) {
            mList.add ( new Tahap ( artahap[i] ) );

        }
        mAdapter.notifyDataSetChanged ();


    }
}



