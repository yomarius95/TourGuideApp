package com.andrei.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FunFragment extends Fragment {


    public FunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("IDM Club", getString(R.string.fun_1_description), "Mon - Sat:\t8AM-5AM", "021.316.10.52", R.drawable.idm_club, 44.443560, 26.048776, "ChIJl-paLZUBskARyynrQzqcv0E", "http://www.idmclub.ro/"));
        places.add(new Place("Edenlandia Park", getString(R.string.fun_2_description), "Mon - Fri:\t9AM-18PM\nSun - Sat:\t10AM-19PM", "0733.365.263", R.drawable.eden_land, 44.650631, 26.104746, "ChIJ_chrc_wYskARwWoQntWsfnA", "https://www.edenland.ro/"));

        PlaceAdapter adapter = new PlaceAdapter(getContext(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
