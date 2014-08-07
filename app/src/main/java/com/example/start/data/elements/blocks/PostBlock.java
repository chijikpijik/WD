package com.example.start.data.elements.blocks;

import com.example.start.data.abstracts.AbsBlock;
import com.example.start.data.elements.blocks.NewsImageBlock;
import com.example.start.data.elements.blocks.NewsRateBlock;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;

/**
 * Created by akarpov on 6/14/14.
 */
public class PostBlock extends AbsBlock {

    private static final String ATTR_DATA_ID = "data-id";
    private static final String ATTR_DATA_LINK = "data-link";
    private static final String ATTR_DATA_TYPE = "data-type";

    @Override
    public String getTag() {
        return "li";
    }

    @Override
    public void provideDataTo(AbsWDItem item) {

    }

    @Override
    public void initBlock() {
        addAppropriateAttribute(new Attribute(ATTR_DATA_ID, ""));
        addAppropriateAttribute(new Attribute(ATTR_DATA_TYPE, ""));
        addAppropriateAttribute(new Attribute(ATTR_DATA_LINK, ""));
        mElements.add(new NewsRateBlock());
        mElements.add(new NewsImageBlock());
        mElements.add(new NewsTextBlock());
    }
}
