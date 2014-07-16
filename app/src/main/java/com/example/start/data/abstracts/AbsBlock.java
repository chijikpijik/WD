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
    private short mSameTagsInsideCounter;


    protected AbsBlock() {
        mElements = new ArrayList<IElement>();
        initBlock();
        i = mElements.listIterator();
        mSameTagsInsideCounter = 0;
    }

    public IElement nextElement() {
        if (i.hasNext()) {
            return i.next();
        } else {
            return null;
        }
    }

    public void terminateBlock() {
        mSameTagsInsideCounter = 0;//TODO:Странная хуйня, подумать на досуге
    }

    @Override
    public ElementType getElementType() {
        return ElementType.BLOCK;
    }

    public abstract void initBlock();

    public boolean canClose() {
        return mSameTagsInsideCounter == 0;
    }

    public boolean checkSameTag(String tagName) {
        return getTag().equals(tagName);
    }

    public void increaseSameTagCounter() {
        mSameTagsInsideCounter++;
    }

    public void decreaseSameTagCounter() {
        if (mSameTagsInsideCounter > 0) {
            mSameTagsInsideCounter--;
        }
    }

}
