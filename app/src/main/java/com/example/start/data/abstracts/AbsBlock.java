package com.example.start.data.abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by akarpov on 6/14/14.
 */
public abstract class AbsBlock extends AbsElement{

    protected List<IElement> mElements;
    private OnRepeatElementCondition mOnRepeatElementCondition;
    ListIterator<IElement> i;

    protected AbsBlock() {
        mElements = new ArrayList<IElement>();
        initBlock();
        i = mElements.listIterator();
    }

    public void addOnRepeatElementCondition(OnRepeatElementCondition condition) {
        mOnRepeatElementCondition = condition;
    }

    public IElement nextElement() {
        if (mOnRepeatElementCondition != null && mOnRepeatElementCondition.repeatPreviousElement())
            return i.hasNext() ? mElements.get(i.nextIndex() - 1) : mElements.get(mElements.size() - 1);
        else
            return i.hasNext() ? i.next() : null;
    }

    @Override
    public ElementType getElementType() {
        return ElementType.BLOCK;
    }

    public abstract void initBlock();

    public static interface OnRepeatElementCondition {

        public boolean repeatPreviousElement();

    }

}
