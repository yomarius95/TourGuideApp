/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.andrei.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = Fragment.instantiate(mContext, RestaurantFragment.class.getName());
                break;
            case 1:
                fragment = Fragment.instantiate(mContext, BarFragment.class.getName());
                break;
            case 2:
                fragment = Fragment.instantiate(mContext, ParkFragment.class.getName());
                break;
            case 3:
                fragment = Fragment.instantiate(mContext, FunFragment.class.getName());
                break;
        }
        return fragment;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.restaurant_text);
        } else if (position == 1) {
            return mContext.getString(R.string.bar_text);
        } else if (position == 2){
            return mContext.getString(R.string.park_text);
        } else {
            return mContext.getString(R.string.fun_text);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
