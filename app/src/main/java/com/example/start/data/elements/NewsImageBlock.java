package com.example.start.data.elements;

import com.example.start.data.abstracts.AbsBlock;
import com.example.start.object.abstracts.AbsWDItem;

import java.net.URISyntaxException;

/**
 * Created by akarpov on 6/14/14.
 */
public class NewsImageBlock extends AbsBlock {

    @Override
    public void fillElements() {

    }

    @Override
    public String getTag() {
        return "div";
    }

    @Override
    public void provideDataTo(AbsWDItem item) throws URISyntaxException {

    }
}
