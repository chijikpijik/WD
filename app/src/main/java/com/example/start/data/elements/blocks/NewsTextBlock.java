package com.example.start.data.elements.blocks;

import com.example.start.data.abstracts.AbsBlock;
import com.example.start.data.abstracts.IElement;
import com.example.start.data.elements.ATagElement;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;

/**
 * Created by akarpov on 7/10/14.
 */
public class NewsTextBlock extends AbsBlock {

    private static final String ATTR_CLASS = "class";
    private static final String ATTR_CLASS_VALUE = "news-s-body";

    @Override
    public void initBlock() {
        addAppropriateAttribute(new Attribute(ATTR_CLASS, ATTR_CLASS_VALUE));
    }

    @Override
    public String getTag() {
        return "div";
    }

    @Override
    public void provideDataTo(AbsWDItem item) {

    }

    @Override
    public IElement nextElement() {
        if (!mBlockFinished) {
            return new ATagElement();
        } else {
            return null;
        }
    }
}
