package com.example.start.data.elements;

import com.example.start.data.abstracts.AbsElement;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;
import com.example.start.utils.Utils;
import org.xml.sax.Attributes;

/**
 * Created by akarpov on 7/10/14.
 */
public class ATagElement extends AbsElement {

    public ATagElement() {
        addAppropriateAttribute(new Attribute("href", ""));
        addAppropriateAttribute(new Attribute("class", "news-s-tag mr5"));
    }

    @Override
    public String getTag() {
        return "a";
    }

    @Override
    public boolean isTagContentRelated() {
        return true;
    }

    @Override
    public void provideDataTo(AbsWDItem item) {
//        Utils.log("Tag: " + getTagContent());
    }
}
