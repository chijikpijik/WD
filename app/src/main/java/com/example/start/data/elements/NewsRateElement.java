package com.example.start.data.elements;

import com.example.start.data.abstracts.AbsElement;
import com.example.start.object.abstracts.AbsWDItem;

public class NewsRateElement extends AbsElement {

    private static final String ATTR_TITLE = "title";

    @Override
    public String getTag() {
        return "b";  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void provideDataTo(AbsWDItem item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
