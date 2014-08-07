package com.example.start.data.abstracts;

import org.xml.sax.Attributes;

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
    protected boolean mBlockFinished;
    protected boolean mCanBeFinished;

    protected AbsBlock() {
        setBlockFinished(false);
        mCanBeFinished = false;
        mElements = new ArrayList<IElement>();
        initBlock();
        i = mElements.listIterator();
        mSameTagsInsideCounter = 0;
    }

    protected void setBlockFinished(boolean finish) {
        mBlockFinished = finish;
    }

    public IElement nextElement() {
        if (i.hasNext()) {
            return i.next();
        } else {
            return null;
        }
    }

    public void finishBlock() {
        mSameTagsInsideCounter = 0;//TODO:Странная хуйня, подумать на досуге
        setBlockFinished(true);
    }

    @Override
    public boolean check(String tag, Attributes attributes) {
        boolean check = super.check(tag, attributes);
        if (check) {
            mCanBeFinished = true;
        }
        return check;
    }

    @Override
    public ElementType getElementType() {
        return ElementType.BLOCK;
    }

    public abstract void initBlock();

    public boolean canFinish() {
        return mSameTagsInsideCounter == 0 && mCanBeFinished;
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
