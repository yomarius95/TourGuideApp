package com.andrei.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ParkFragment extends Fragment {


    public ParkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Herastrau Park", getString(R.string.park_1_description), R.drawable.parc_herastrau, 44.468463, 26.080524, "ChIJKY2Wd2oCskARMfjunqzJVHU"));
        places.add(new Place("Tineretului Park", getString(R.string.park_2_description), R.drawable.parc_tineretului, 44.405725, 26.106018, "ChIJ_9zV0qr_sUARjk_kKHWdIpw"));

        PlaceAdapter adapter = new PlaceAdapter(getContext(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
