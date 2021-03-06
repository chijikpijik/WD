package com.example.start.data.elements.blocks;

import com.example.start.data.abstracts.AbsBlock;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;

/**
 * Created by akarpov on 7/10/14.
 */
public class NewsAboutBlock extends AbsBlock {

    private static final String ATTR_CLASS = "class";
    private static final String ATTR_CLASS_VALUE = "news-s-about";

    @Override
    public void initBlock() {
//        mElements.add(new BRateElement());
        addAppropriateAttribute(new Attribute(ATTR_CLASS, ATTR_CLASS_VALUE));
    }

    @Override
    public String getTag() {
        return "div";
    }

    @Override
    public void provideDataTo(AbsWDItem item) {

    }
}
