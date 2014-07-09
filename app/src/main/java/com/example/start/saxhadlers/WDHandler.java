package com.example.start.saxhadlers;

import android.text.TextUtils;
import com.example.start.data.abstracts.AbsBlock;
import com.example.start.data.abstracts.IElement;
import com.example.start.data.elements.PostBlock;
import com.example.start.data.objects.Attribute;
import com.example.start.net.converter.WDConverter;
import com.example.start.object.abstracts.AbsWDItem;
import com.example.start.utils.Utils;
import org.ccil.cowan.tagsoup.AttributesImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WDHandler extends DefaultHandler {

    IElement mElement;
    List<AbsWDItem> mPosts;
    LinkedList<AbsBlock> mBlocks;

    public WDHandler() {
        super();
        mPosts = new ArrayList();
        mBlocks = new LinkedList<AbsBlock>();
        mElement = new PostBlock();
    }

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (mElement.check(localName, attributes)) {
            mElement.provideDataTo(AbsItem);
            switch (mElement.getElementType()) {
                case BLOCK:
                    if (!mBlocks.peekLast().equals(mElement))
                        mBlocks.push((AbsBlock) mElement);
                    break;
            }
            mElement = mBlocks.peekLast().nextElement();
            while (mElement == null) {
                mBlocks.removeLast();
                if (mBlocks.size() == 0) {
                    break;
                }
                mElement = mBlocks.peekLast().nextElement();
            }
        }
        Utils.log(String.format("URI: %s, LocalName: %s, qName: %s", uri, localName, qName));
    }

}
