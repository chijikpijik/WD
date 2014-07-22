package com.example.start.data.elements;

import com.example.start.data.abstracts.AbsElement;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;

/**
 * Created by akarpov on 7/10/14.
 */
public class ATitleElement extends AbsElement {

       @Override
    public String getTag() {
        return "a";
    }

    @Override
    public void provideDataTo(AbsWDItem item) {

    }
}
