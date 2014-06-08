package com.example.start.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.start.R;
import com.example.start.net.ImageAssigner;
import com.example.start.utils.Utils;
import com.example.start.view.WDItemSmallView;

import java.util.List;

public class WDListAdapter extends BaseAdapter {

    private List<WDItemSmallView> mItems;
    private Context mContext;

    public WDListAdapter(Context ctx, List items) {
        mItems = items;
        mContext = ctx;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public WDItemSmallView getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_small, parent, false);
        ImageAssigner loader;
        ((TextView)convertView.findViewById(R.id.itemTitle)).setText(getItem(position).getTitle());
        ((TextView)convertView.findViewById(R.id.itemRate)).setText(
                String.format("Pos in adapter: %s, Pos from Item: %s", position, getItem(position).getPosition()));
        loader = new ImageAssigner(mContext,
                getItem(position).getImageUri(),
                (ImageView)convertView.findViewById(R.id.itemImage),
                getItem(position).getPosition());
        loader.assign();
        Utils.log("Convert view: " + getItem(position).getPosition());
        return convertView;
    }
}
