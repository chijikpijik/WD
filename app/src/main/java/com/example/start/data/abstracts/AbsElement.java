package com.example.start.data.abstracts;

import android.text.TextUtils;
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
    public boolean check(String tag, Attributes attributes) {
        if (!tag.equals(getTag()))
            return false;
        for (Attribute attribute : mAppropriateAttributes) {
            int index = attributes.getIndex(attribute.getName());
            if (index == -1) {
                return false;
            } else {
                if ((!TextUtils.isEmpty(attribute.getValue())
                        && !attribute.getValue().equals(attributes.getValue(index)))){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ElementType getElementType() {
        return ElementType.ELEMENT;
    }
}
