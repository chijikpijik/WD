package com.example.start.saxhadlers;

import android.text.TextUtils;
import com.example.start.data.WDBlock;
import com.example.start.data.abstracts.IBlock;
import com.example.start.data.abstracts.IElement;
import com.example.start.data.objects.Attribute;
import com.example.start.utils.Utils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WDHandler extends DefaultHandler {

    IBlock mBlock;
    IElement mElement;
    List<IBlock> mBlockList = new ArrayList<IBlock>();

    public WDHandler() {
        super();
        mBlock = new WDBlock();
        mElement = mBlock.nextElement();
    }

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        int count = mElement.getAttributesForMatch().size();
        if (localName.equals(mElement.getTag())) {     // Tag matching
            for (Iterator<Attribute> i = mElement.getAttributesForMatch().iterator(); i.hasNext();) {
                Attribute attr = i.next();
                String value = attributes.getValue(attr.getName()); // Check current tag attributes for appropriate
                if (value != null)
                    if (!TextUtils.isEmpty(attr.getValue())) { // If attribute must have special value
                        if (value.equals(attr.getValue()))
                            count--;
                    } else {
                        count--;
                    }
            }
            if (count == 0) {
                int i = 0;
                mElement.setAttributes(attributes);
                Utils.log(String.format("Element tag %s", localName));
                while (attributes.getValue(i) != null) {
                    Utils.log(String.format("attribute [%s] name: %s -> %s",
                            attributes.getClass(),
                            attributes.getQName(i),
                            attributes.getValue(i)));
                    i++;
                }
                mElement = mBlock.nextElement();
                if (mElement == null) {
                    mBlockList.add(mBlock);
                    mBlock = new WDBlock();
                    mElement = mBlock.nextElement();
                }
            }
        }
    }

    public List<IBlock> getBlockList() {
        return mBlockList;
    }
}
