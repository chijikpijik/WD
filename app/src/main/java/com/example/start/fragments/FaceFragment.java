package com.example.start.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import com.example.start.net.WDService;
import com.example.start.net.converter.WDConverter;
import com.example.start.R;
import com.example.start.adapters.WDListAdapter;
import com.example.start.object.abstracts.AbsWDItem;
import com.example.start.saxhadlers.WDHandler;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.List;

public class FaceFragment extends Fragment {

    private List<AbsWDItem> mItems;

    private WDListAdapter mAdapter;

    public static FaceFragment newInstance() {
        return new FaceFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.face_list_fragment, container, false);
        ((Button) v.findViewById(R.id.btnStartDownload)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                v.setVisibility(View.GONE);
            }
        });
        mAdapter = new WDListAdapter(getActivity());
        ((ListView) v.findViewById(R.id.lstMain)).setAdapter(mAdapter);
        ((ListView) v.findViewById(R.id.lstMain)).setDivider(null);
        return v;
    }

    private void download() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setConverter(new WDConverter())
                .setEndpoint("http://webdiscover.ru")
                .build();
        WDService wdService = restAdapter.create(WDService.class);
         wdService.getMainPageHandler(new Callback<WDHandler>() {
             @Override
             public void success(WDHandler wdHandler, Response response) {
                fillListModel(wdHandler.getWDModel());
             }

             @Override
             public void failure(RetrofitError error) {

             }
         });
    }

    public void fillListModel(List<AbsWDItem> items) {
        mItems = new ArrayList<AbsWDItem>();
        mItems.addAll(items);
        mAdapter.setItems(items);
        updateList();
    }

    private void updateList() {
        ((WDListAdapter) mAdapter).notifyDataSetChanged();
    }

}
