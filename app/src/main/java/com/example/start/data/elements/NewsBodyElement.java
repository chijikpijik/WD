package com.example.start.data.elements;

import com.example.start.view.abstracts.AbsWDItem;
import com.example.start.data.abstracts.IElement;
import org.xml.sax.Attributes;

import java.util.List;

public class NewsBodyElement implements IElement {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public List getAttributesForMatch() {
        return null;
    }

    @Override
    public Attributes getAttributes() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAttributes(Attributes attributes) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void fillData(AbsWDItem item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
