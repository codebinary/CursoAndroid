package com.james.codebinary.googlemaps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by codebinary on 17/07/16.
 */
public class FirstMapFragment extends SupportMapFragment {

    public FirstMapFragment(){

    }

    public static FirstMapFragment newInstance(){
        return new FirstMapFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = super.onCreateView(inflater, container, bundle);
        return view;
    }
}
