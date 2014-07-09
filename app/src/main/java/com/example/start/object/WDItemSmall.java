package com.example.start.object;

import android.content.Context;
import com.example.start.utils.Utils;
import com.example.start.object.abstracts.AbsWDItem;

public class WDItemSmall extends AbsWDItem {

    private int mPosition;

    public WDItemSmall() {
        super();
    }

    public WDItemSmall(int position, Context context) {
        mPosition = position;
        Utils.log(String.format("ITEM INIT pos: %s", position));
    }

    public int getPosition() {
        return mPosition;
    }
}
