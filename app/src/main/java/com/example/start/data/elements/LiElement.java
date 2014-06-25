package com.example.start.data.elements;

import com.example.start.object.abstracts.AbsWDItem;
import com.example.start.data.abstracts.AbsElement;
import com.example.start.data.objects.Attribute;

import java.net.URISyntaxException;

public class LiElement extends AbsElement {

    private static final String ATTR_DATA_ID = "data-id";
    private static final String ATTR_DATA_LINK = "data-link";
    private static final String ATTR_DATA_TYPE = "data-type";

    private static final String TAG = "li";

    public LiElement() {
        addAppropriateAttribute(new Attribute(ATTR_DATA_ID, ""));
        addAppropriateAttribute(new Attribute(ATTR_DATA_TYPE, "1"));
    }

    @Override
    public String getTag() {
        return TAG;
    }

    @Override
    public void provideDataTo(AbsWDItem item) throws URISyntaxException {
        item.setDataType(getAttributes().getValue(ATTR_DATA_TYPE));
    }}
