package com.example.start.saxhadlers;

import com.example.start.data.abstracts.AbsBlock;
import com.example.start.data.abstracts.IElement;
import com.example.start.data.elements.PostBlock;
import com.example.start.object.WDItemSmall;
import com.example.start.object.abstracts.AbsWDItem;
import com.example.start.utils.Utils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WDHandler extends DefaultHandler {

    IElement mElement;
    List<AbsWDItem> mPosts;
    LinkedList<AbsBlock> mBlocks;
    AbsWDItem Post;

    public WDHandler() {
        super();
        mPosts = new ArrayList();
        mBlocks = new LinkedList<AbsBlock>();
        mElement = new PostBlock();
        Post = new WDItemSmall();
    }

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (mElement.check(localName, attributes)) {
            mElement.provideDataTo(Post);//TODO: Do not forget to implement
            switch (mElement.getElementType()) {
                case BLOCK:
                    if (mBlocks.isEmpty() || !mBlocks.peekFirst().equals(mElement))
                        mBlocks.push((AbsBlock) mElement);
                    break;
            }
            mElement = mBlocks.peekFirst().nextElement();
            while (mElement == null) {
                mBlocks.removeFirst();
                if (mBlocks.size() == 0) {
                    mPosts.add(Post);
                    Post = new WDItemSmall();
                    mElement = new PostBlock();
                    break;
                }
                mElement = mBlocks.peekFirst().nextElement();
            }
            Utils.log(String.format("URI: %s, LocalName: %s, qName: %s", uri, localName, qName));
        }
    }

}
