package com.example.start.data.abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by akarpov on 6/14/14.
 */
public abstract class AbsBlock extends AbsElement{

    protected List<IElement> mElements;
    ListIterator<IElement> i;

    protected AbsBlock() {
        mElements = new ArrayList<IElement>();
        initBlock();
        i = mElements.listIterator();
    }

    public IElement nextElement() {
        return i.hasNext() ? i.next() : null;
    }

    @Override
    public ElementType getElementType() {
        return ElementType.BLOCK;
    }

    public abstract void initBlock();

}
