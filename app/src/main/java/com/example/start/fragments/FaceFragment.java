package com.example.start.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.example.start.net.WDService;
import com.example.start.net.converter.WDConverter;
import com.example.start.view.WDItemSmall;
import com.example.start.view.abstracts.AbsWDItem;
import com.example.start.R;
import com.example.start.adapters.WDListAdapter;
import com.example.start.data.abstracts.IBlock;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaceFragment extends Fragment {

    private List<WDItemSmall> mItems = new ArrayList<WDItemSmall>();

    private ListAdapter mAdapter;

    private List<IBlock> mBlocks;

    public static FaceFragment newInstance() {
        return new FaceFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.face_list_fragment, container, false);
        ((Button) v.findViewById(R.id.btnStartDownload)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDownload();
                v.setVisibility(View.GONE);
            }
        });
        mAdapter = new WDListAdapter(getActivity(), mItems);
        ((ListView) v.findViewById(R.id.lstMain)).setAdapter(mAdapter);
        return v;
    }

    private void startDownload() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://webdiscover.ru")
                .build();
        WDService wdService = restAdapter.create(WDService.class);
         wdService.getBody(new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                fillItemsData(WDConverter.fromBody(response.getBody()));
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    public void fillItemsData(List<IBlock> blocks) {
        Iterator<IBlock> i = blocks.iterator();
        Integer pos = 0;
        for (; i.hasNext(); ) {
            AbsWDItem item = new WDItemSmall(pos, getActivity());
            IBlock block = i.next();
            block.fillItem(item);
            mItems.add((WDItemSmall) item);
            pos++;
        }
        updateList();
    }

    private void updateList() {
        ((WDListAdapter) mAdapter).notifyDataSetChanged();
    }
}
