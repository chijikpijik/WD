package com.example.start.data.abstracts;

import com.example.start.view.abstracts.AbsWDItem;

import java.util.List;

public interface IBlock {

    public AbsWDItem fillItem(AbsWDItem item);

    public IElement nextElement();

    public List<IElement> getElementList();
}
