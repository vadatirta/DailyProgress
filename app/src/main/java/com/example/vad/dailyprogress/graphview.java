package com.example.vad.dailyprogress;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;
import java.util.Date;

public class graphview extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate ( R.layout.activity_graphview, null );


        Calendar calendar = Calendar.getInstance ();
        Date d1 = calendar.getTime ();
        calendar.add ( Calendar.DATE, 1 );
        Date d2 = calendar.getTime ();
        calendar.add ( Calendar.DATE, 1 );
        Date d3 = calendar.getTime ();

        GraphView graph = (GraphView) v.findViewById ( R.id.graph );

// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<> ( new DataPoint[]{
                new DataPoint ( d1, 1 ),
                new DataPoint ( d2, 5 ),
                new DataPoint ( d3, 3 )
        } );

        graph.addSeries ( series );

// set date label formatter
        graph.getGridLabelRenderer ().setLabelFormatter ( new DateAsXAxisLabelFormatter ( getActivity () ) );
        graph.getGridLabelRenderer ().setNumHorizontalLabels ( 3 ); // only 4 because of the space

// set manual x bounds to have nice steps
        graph.getViewport ().setMinX ( d1.getTime () );
        graph.getViewport ().setMaxX ( d3.getTime () );
        graph.getViewport ().setXAxisBoundsManual ( true );

// as we use dates as labels, the human rounding to nice readable numbers
// is not necessary
        graph.getGridLabelRenderer ().setHumanRounding ( false );
        graph = (GraphView) v.findViewById ( R.id.graph );
        series = new LineGraphSeries<> ( new DataPoint[]{
                new DataPoint ( 0, 1 ),
                new DataPoint ( 1, 5 ),
                new DataPoint ( 2, 3 ),
                new DataPoint ( 3, 2 ),
                new DataPoint ( 4, 6 )
        } );
        graph.addSeries ( series );

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<> ( new DataPoint[]{
                new DataPoint ( 0, 30 ),
                new DataPoint ( 1, 30 ),
                new DataPoint ( 2, 60 ),
                new DataPoint ( 3, 20 ),
                new DataPoint ( 4, 50 )
        } );
// set second scale
        graph.getSecondScale ().addSeries ( series2 );
// the y bounds are always manual for second scale
        graph.getSecondScale ().setMinY ( 0 );
        graph.getSecondScale ().setMaxY ( 100 );
        graph.getViewport ().setScrollable ( true ); // enables horizontal scrolling
        graph.getViewport ().setScrollableY ( true ); // enables vertical scrolling
        graph.getViewport ().setScalable ( true ); // enables horizontal zooming and scrolling
        graph.getViewport ().setScalableY ( true );
        series2.setColor ( Color.RED );
        graph.getGridLabelRenderer ().setVerticalLabelsSecondScaleColor ( Color.RED );

        return v;
    }

}




