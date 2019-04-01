package com.andrei.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class BarFragment extends Fragment {


    public BarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Eden Garden", getString(R.string.bar_1_description), "Mon - Sat:\t4PM-2AM", "0744.510.687", R.drawable.eden_garden, 44.443726, 26.091422, "ChIJF8IdVlD_sUARFC6fcR-IBU0", "https://www.facebook.com/gradinaeden107/"));

        PlaceAdapter adapter = new PlaceAdapter(getContext(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
