package com.example.start.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.start.R;
import com.example.start.object.WDItemSmall;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WDListAdapter extends BaseAdapter {

    private List<WDItemSmall> mItems;
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
    public WDItemSmall getItem(int position) {
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
        ((TextView)convertView.findViewById(R.id.itemTitle)).setText(getItem(position).getTitle());
        ((TextView)convertView.findViewById(R.id.itemRate)).setText(getItem(position).getRate());
        ImageView imageView = (ImageView) convertView.findViewById(R.id.itemImage);
        Picasso.with(mContext).load(getItem(position).getImageUri()).into(imageView);
        return convertView;
    }
}
