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

    public WDHandler() {
        super();
        mPosts = new ArrayList();
        mBlocks = new LinkedList<AbsBlock>();
        mPost = new WDItemSmall();
        setNextElement(new PostBlock());
    }

    private AbsBlock getCurrentBlock() {
        return mBlocks.size() > 0 ? mBlocks.getFirst() : null;
    }

    private IElement getNextElementInBlock() {
        if (!mBlocks.isEmpty()) {
            IElement element = mBlocks.peekFirst().nextElement();
            while (!mBlocks.isEmpty() && element == null) {
                mBlocks.removeFirst().terminateBlock();
                element = mBlocks.peekFirst().nextElement();
            }
            Utils.log(String.format("Next Element is: %s", element != null ? element.getTag() : "null"));
            return element;
        }
        return null;
    }

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

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (mElement.check(localName, attributes)) {
            mElement.provideDataTo(mPost);//TODO: Do not forget to implement
            if (!setNextElement(getNextElementInBlock())) {
                mPosts.add(mPost);
                mPost = new WDItemSmall();
                setNextElement(new PostBlock());
            }
//            Utils.log(String.format("URI: %s, LocalName: %s, qName: %s", uri, localName, qName));
        } else if (getCurrentBlock() != null && getCurrentBlock().checkSameTag(localName)) {
                getCurrentBlock().increaseSameTagCounter();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (getCurrentBlock() != null && getCurrentBlock().checkSameTag(localName)) {
            if (!getCurrentBlock().canClose()) {
                getCurrentBlock().decreaseSameTagCounter();
            } else {
                Utils.log("Block " + getCurrentBlock().getTag() + " is closed");
            }
        }
    }
}
