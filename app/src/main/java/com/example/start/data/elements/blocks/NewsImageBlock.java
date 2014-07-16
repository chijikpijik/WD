package com.example.start.data.elements.blocks;

import com.example.start.data.abstracts.AbsBlock;
import com.example.start.data.elements.NewsImageElement;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;

import java.net.URISyntaxException;

/**
 * Created by akarpov on 6/14/14.
 */
public class NewsImageBlock extends AbsBlock {

    private static final String ATTR_CLASS = "class";
    private static final String ATTR_CLASS_VALUE = "news-s-img";

    @Override
    public void initBlock() {
        mElements.add(new NewsImageElement());
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
