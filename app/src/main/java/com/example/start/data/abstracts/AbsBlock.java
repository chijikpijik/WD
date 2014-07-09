package com.example.start.data.abstracts;

import com.example.start.data.abstracts.AbsElement;
import com.example.start.data.abstracts.IElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akarpov on 6/14/14.
 */
public abstract class AbsBlock extends AbsElement{

    protected List<IElement> mElements;
    Iterator<IElement> i;

    protected AbsBlock() {
        mElements = new ArrayList<IElement>();
        fillElements();
        i = mElements.iterator();
    }

    public IElement nextElement() {
        return i.hasNext() ? i.next() : null;
    }

    @Override
    public ElementType getElementType() {
        return ElementType.BLOCK;
    }

    public abstract void fillElements();

}
