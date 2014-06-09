package com.example.start.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.start.R;

import java.util.List;

/**
 * Created by akarpov on 6/9/14.
 */
public class DrawerMenuAdapter extends BaseAdapter {

    private List mItems;
    private Context mContext;

    public DrawerMenuAdapter(Context context) {
        super();
        mContext = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_drawer, parent, false);
        switch (position) {
            case 0:
                ((TextView)convertView.findViewById(R.id.fieldTitle)).setText("Login via facebook");
                break;
            case 1:
                ((TextView)convertView.findViewById(R.id.fieldTitle)).setText("Login via vk");
                break;
            case 2:
                ((TextView)convertView.findViewById(R.id.fieldTitle)).setText("About");
                break;
        }
        return convertView;
    }
}
