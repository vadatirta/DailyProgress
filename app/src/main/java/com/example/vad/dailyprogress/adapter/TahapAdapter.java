package com.example.vad.dailyprogress.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vad.dailyprogress.R;
import com.example.vad.dailyprogress.model.Tahap;

import java.util.ArrayList;

/**
 * Created by VAD on 24/08/2017.
 */
public class TahapAdapter extends RecyclerView.Adapter<TahapAdapter.ViewHolder> {
    ArrayList<Tahap> tahaps;

    public TahapAdapter(ArrayList<Tahap> tahaps) {
        this.tahaps = tahaps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.template, parent, false );
        ViewHolder vh = new ViewHolder ( v );
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tahap tahap = tahaps.get ( position );
        holder.tv1.setText ( tahap.awal );


    }

    @Override
    public int getItemCount() {
        if (tahaps != null)
            return tahaps.size ();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1;

        public ViewHolder(View itemView) {
            super ( itemView );
            tv1 = (TextView) itemView.findViewById ( R.id.ttahap );
        }
    }
}
