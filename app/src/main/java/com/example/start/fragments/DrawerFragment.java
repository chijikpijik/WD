package com.example.start.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import com.example.start.R;
import com.example.start.adapters.DrawerMenuAdapter;

public class DrawerFragment extends Fragment {

    public static DrawerFragment newInstance() {
        DrawerFragment fragment = new DrawerFragment();
        return fragment;
    }
    public DrawerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_drawer, container, false);
        ((ListView)v.findViewById(R.id.drawerMenu)).setAdapter(new DrawerMenuAdapter(getActivity()));
        return v;
    }

}
