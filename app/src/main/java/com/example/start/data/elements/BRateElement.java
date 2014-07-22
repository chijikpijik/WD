package com.example.start.data.elements;

import com.example.start.data.abstracts.AbsElement;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;

import java.net.URISyntaxException;

/**
 * Created by akarpov on 6/25/14.
 */
public class BRateElement extends AbsElement {

    public BRateElement() {
        addAppropriateAttribute(new Attribute("title", ""));
    }

    @Override
    public String getTag() {
        return "b";
    }

    @Override
    public void provideDataTo(AbsWDItem item) {
        item.setRate(getTagContent());
    }

    @Override
    public boolean isTagContentRelated() {
        return true;
    }
}
