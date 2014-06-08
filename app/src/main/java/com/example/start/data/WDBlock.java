package com.example.start.data;

import com.example.start.view.abstracts.AbsWDItem;
import com.example.start.data.abstracts.IBlock;
import com.example.start.data.abstracts.IElement;
import com.example.start.data.elements.LiElement;
import com.example.start.data.elements.NewsImageElement;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WDBlock implements IBlock {

    @Override
    public AbsWDItem fillItem(AbsWDItem item) {
        Iterator<IElement> i = mElements.iterator();
        for (;i.hasNext();) {
            IElement el = i.next();
            try {
                el.fillData(item);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return item;
    }

    private List<IElement> mElements = new ArrayList<IElement>();
    Iterator i;
    public WDBlock() {
        mElements.add(new LiElement());
        mElements.add(new NewsImageElement());
        i = mElements.iterator();    }

    @Override
    public IElement nextElement() {
        return i.hasNext() ? (IElement) i.next() : null;
    }

    @Override
    public List<IElement> getElementList() {
        return mElements;
    }
}
