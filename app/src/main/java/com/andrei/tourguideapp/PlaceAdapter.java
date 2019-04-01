package com.andrei.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {


    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Place currentPlace = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentPlace.getImageResourceId());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentPlace.getName());

        TextView workingHoursTextView = (TextView) listItemView.findViewById(R.id.working_hours_text_view);

        if(currentPlace.getWorkingHours() != null) {
            workingHoursTextView.setText(currentPlace.getWorkingHours());
        } else {
            workingHoursTextView.setVisibility(View.GONE);
        }

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        descriptionTextView.setText(currentPlace.getDescription());

        ImageButton phoneNumberImageButton = (ImageButton) listItemView.findViewById(R.id.phone_number_image_button);

        if(currentPlace.getPhoneNumber() != null) {
            phoneNumberImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + currentPlace.getPhoneNumber()));
                    getContext().startActivity(intent);
                }
            });
        } else {
            phoneNumberImageButton.setVisibility(View.GONE);
        }

        ImageButton locationImageButton = (ImageButton) listItemView.findViewById(R.id.location_image_button);
        locationImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Location currentLocation = currentPlace.getLocation();

                String locationString = currentLocation.getLongitude() + "," + currentLocation.getLatitude() + "&query_place_id=" + currentLocation.getProvider();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/?api=1&query=" + locationString));

                intent.setPackage("com.google.android.apps.maps");

                getContext().startActivity(intent);
            }
        });

        ImageButton websiteImageButton = (ImageButton) listItemView.findViewById(R.id.website_image_button);

        if(currentPlace.getWebsite() != null) {
            websiteImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentPlace.getWebsite()));
                    getContext().startActivity(intent);
                }
            });
        } else {
            websiteImageButton.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
