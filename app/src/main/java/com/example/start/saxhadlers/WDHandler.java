package com.example.start.saxhadlers;

import com.example.start.data.abstracts.AbsBlock;
import com.example.start.data.abstracts.IElement;
import com.example.start.data.elements.blocks.PostBlock;
import com.example.start.object.WDItemSmall;
import com.example.start.object.abstracts.AbsWDItem;
import com.example.start.utils.Utils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class WDHandler extends DefaultHandler {

    IElement mElement;
    List<AbsWDItem> mPosts;
    LinkedList<AbsBlock> mBlocks;
    AbsWDItem mPost;
    StringBuilder mTagContent;
    boolean mObtainText;

    public WDHandler() {
        super();
        mPosts = new ArrayList();
        mBlocks = new LinkedList<AbsBlock>();
        moveToNextElement();
        mObtainText = false;
    }

    private AbsBlock getCurrentBlock() {
        return mBlocks.size() > 0 ? mBlocks.getFirst() : null;
    }

    private String getTagContent() {
        return mTagContent.toString();
    }

    private IElement getNextElementInBlock() {
        if (!mBlocks.isEmpty()) {
            IElement element = mBlocks.peekFirst().nextElement();
            while (element == null) {
                mBlocks.removeFirst().finishBlock();
                if (mBlocks.isEmpty()) {
                    return null;
                }
                element = mBlocks.peekFirst().nextElement();
            }
            return element;
        }
        return null;
    }

    /**
     * Sets next element
     * @param element
     * @return false if element is null
     */
    private boolean setNextElement(IElement element) {
        if (element == null)
            return false;
        switch (element.getElementType()) {
            case BLOCK:
                if (mBlocks.isEmpty() || !mBlocks.peekFirst().equals(element)) {
                    mBlocks.push((AbsBlock) element);
                }
                break;
        }
        mElement = element;
        return true;
    }

    private void moveToNextElement() {
        if (!setNextElement(getNextElementInBlock())) {
            mPost = new WDItemSmall();
            setNextElement(new PostBlock());
            mPosts.add(mPost);
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (mObtainText) {
            mTagContent = new StringBuilder();
            mTagContent.append(ch, start, length);
        }
    }

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        Utils.log(String.format("Tag: %s", localName));
        if (mElement.check(localName, attributes)) {
            mElement.setAttributes(attributes);
            if (mElement.isTagContentRelated()) {
                mObtainText = true;
            } else {
                mElement.provideDataTo(mPost);
                moveToNextElement();
            }
        } else if (getCurrentBlock() != null && getCurrentBlock().checkSameTag(localName)) {
                getCurrentBlock().increaseSameTagCounter();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (getCurrentBlock() != null && getCurrentBlock().checkSameTag(localName)) {
            if (!getCurrentBlock().canFinish()) {
                getCurrentBlock().decreaseSameTagCounter();
            } else {
                getCurrentBlock().finishBlock();
                moveToNextElement();
            }
        }
        if (mObtainText) {
            mObtainText = false;
            mElement.setTagContent(getTagContent());
            mElement.provideDataTo(mPost);
            moveToNextElement();
        }
    }

    public List<AbsWDItem> getWDModel() {
        return mPosts;
    }

}
