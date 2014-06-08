package com.example.start.view;

import android.content.Context;
import com.example.start.utils.Utils;
import com.example.start.view.abstracts.AbsWDItem;

public class WDItemSmallView extends AbsWDItem {

    private int mPosition;

    public WDItemSmallView(int position, Context context) {
        mPosition = position;
        Utils.log(String.format("ITEM INIT pos: %s", position));
    }

    public int getPosition() {
        return mPosition;
    }
}
