package com.example.start.data.elements;

import com.example.start.data.abstracts.AbsElement;
import com.example.start.data.elements.strategies.ATitleStrategy;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;

/**
 * Created by akarpov on 7/10/14.
 */
public class ATitleElement extends AbsElement {

    public ATitleElement() {
        this(new ATitleStrategy() {
            @Override
            public String getHrefValue() {
                return "";
            }

            @Override
            public String getIdValue() {
                return "";
            }
        });
    }

    public ATitleElement(ATitleStrategy strategy) {
        addAppropriateAttribute(new Attribute("href", strategy.getHrefValue()));
        addAppropriateAttribute(new Attribute("id", strategy.getIdValue()));
    }

    @Override
    public String getTag() {
        return "a";
    }

    @Override
    public void provideDataTo(AbsWDItem item) {

    }
}
