package com.example.start.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.start.R;
import com.example.start.object.WDItemSmall;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WDListAdapter extends BaseAdapter {

    private List<WDItemSmall> mItems;
    private Context mContext;
    private Map<Integer, VisibleDetail> mDetailsVisibilityState = null;

    public static enum VisibleDetail {
        TITLE,
        RATE,
        HASH_TAGS
    }

    static class Holder {

        Button mRateButton;

        Button mUserButton;

        Button mHashTagButton;

        TextView mTitle;

        TextView mRate;

        TextView mHashTags;

        ImageView mImage;

    }

    public WDListAdapter(Context ctx) {
        this(ctx, new ArrayList<WDItemSmall>());
    }

    public WDListAdapter(Context ctx, List items) {
        mItems = items;
        mContext = ctx;
    }

    public void setItems(List items) {
        mItems = new ArrayList<WDItemSmall>();
        mItems.addAll(items);
        refreshDetailsState();
    }

    private void refreshDetailsState() {
        mDetailsVisibilityState = new HashMap<Integer, VisibleDetail>();
        for (int i = 0; i < getCount(); i++) {
            mDetailsVisibilityState.put(i, VisibleDetail.TITLE);
        }
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Holder viewHolder;
        View v = null;
        if (convertView == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.main_list_item_big, parent, false);
            viewHolder = new Holder();
            viewHolder.mRateButton = (Button) v.findViewById(R.id.rateButton);
            viewHolder.mHashTagButton = (Button) v.findViewById(R.id.hashTagsButton);
            viewHolder.mUserButton = (Button) v.findViewById(R.id.userButton);
            viewHolder.mRate = (TextView) v.findViewById(R.id.rate);
            viewHolder.mTitle = (TextView) v.findViewById(R.id.title);
            viewHolder.mHashTags = (TextView) v.findViewById(R.id.hashTags);
            viewHolder.mImage = (ImageView) v.findViewById(R.id.itemImage);
            v.setTag(viewHolder);
        } else {
            v = convertView;
            viewHolder = (Holder) v.getTag();
        }
        viewHolder.mRateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDetailsVisibilityState.put(position, VisibleDetail.RATE);
                showDetail(VisibleDetail.RATE, viewHolder);
            }
        });
        viewHolder.mHashTagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDetailsVisibilityState.put(position, VisibleDetail.HASH_TAGS);
                showDetail(VisibleDetail.HASH_TAGS, viewHolder);
            }
        });
        viewHolder.mTitle.setText(getItem(position).getTitle());
        viewHolder.mRate.setText(getItem(position).getRate());
        showDetail(mDetailsVisibilityState.get(position), viewHolder);
        Picasso.with(mContext).load(getItem(position).getImageUri()).into(viewHolder.mImage);
        return v;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    private void showDetail(VisibleDetail detail, Holder viewHolder) {
        switch (detail) {
            case RATE:
                viewHolder.mRate.setVisibility(View.VISIBLE);
                viewHolder.mTitle.setVisibility(View.GONE);
                viewHolder.mHashTags.setVisibility(View.GONE);
                break;
            case TITLE:
                viewHolder.mRate.setVisibility(View.GONE);
                viewHolder.mTitle.setVisibility(View.VISIBLE);
                viewHolder.mHashTags.setVisibility(View.GONE);
                break;
            case HASH_TAGS:
                viewHolder.mRate.setVisibility(View.GONE);
                viewHolder.mTitle.setVisibility(View.GONE);
                viewHolder.mHashTags.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
