package com.example.start.data.abstracts;

import com.example.start.data.objects.Attribute;
import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsElement implements IElement {

    protected List<Attribute> mAppropriateAttributes = new ArrayList<Attribute>();
    protected Attributes mAttributes;

    protected void addAppropriateAttribute(Attribute attribute) {
        mAppropriateAttributes.add(attribute);
    }

    @Override
    public List getAttributesForMatch() {
        return mAppropriateAttributes;
    }


    @Override
    public Attributes getAttributes() {
        return mAttributes;
    }

    @Override
    public void setAttributes(Attributes attributes) {
        mAttributes = attributes;
    }



    @Override
    public ElementType getElementType() {
        return ElementType.ELEMENT;
    }
}
