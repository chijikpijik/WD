package com.example.start.data.elements;

import com.example.start.data.abstracts.AbsBlock;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;

import java.net.URISyntaxException;

/**
 * Created by akarpov on 6/14/14.
 */
public class NewsRateBlock extends AbsBlock {

    private static final String ATTR_CLASS = "class";
    private static final String ATTR_CLASS_VALUE = "news-s-rate";

    @Override
    public void fillElements() {
        mElements.add(new BRateElement());
        addAppropriateAttribute(new Attribute(ATTR_CLASS, ATTR_CLASS_VALUE));
    }

    @Override
    public String getTag() {
        return "div";
    }

    @Override
    public void provideDataTo(AbsWDItem item) throws URISyntaxException {

    }

}
