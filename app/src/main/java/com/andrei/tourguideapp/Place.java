package com.andrei.tourguideapp;

import android.location.Location;

public class Place {

    private String mName;
    private String mDescription;
    private String mWorkingHours;
    private String mPhoneNumber;
    private int mImageResourceId;
    private Location mLocation;
    private String mWebsite;

    public Place(String name, String description, int imageResourceId, double longitude, double latitude, String locationId) {

        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
        mLocation = new Location(locationId);
        mLocation.setLongitude(longitude);
        mLocation.setLatitude(latitude);
    }

    public Place(String name, String description, String workinghours, String phoneNumber, int imageResourceId, double longitude, double latitude, String locationId, String website) {

        mName = name;
        mDescription = description;
        mWorkingHours = workinghours;
        mPhoneNumber = phoneNumber;
        mImageResourceId = imageResourceId;
        mLocation = new Location(locationId);
        mLocation.setLongitude(longitude);
        mLocation.setLatitude(latitude);
        mWebsite = website;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getWorkingHours() {
        return mWorkingHours;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public Location getLocation() {
        return mLocation;
    }

    public String getWebsite() {
        return mWebsite;
    }
}
