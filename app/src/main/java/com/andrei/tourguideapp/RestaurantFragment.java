package com.andrei.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Ruby Tuesday", getString(R.string.restaurant_1_description), "Sun - Thu:\t11AM-11PM\nFri - Sat:\t11AM-11:30PM", "021.323.78.71", R.drawable.ruby_tuesday, 44.427255, 26.131335, "ChIJw7BRM9n-sUARwGW5xLjoeg4", "http://www.ruby.ro/"));
        places.add(new Place("Templul Soarelui", getString(R.string.restaurant_2_description), "Mon - Sat:\t12AM-12PM", "021.211.16.93", R.drawable.templul_soarelui, 44.446463, 26.114743, "ChIJBYuRssr4sUARvBUJJdC4WHY", "http://www.templulsoarelui.ro"));

        PlaceAdapter adapter = new PlaceAdapter(getContext(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
