package com.example.start.data.elements;

import com.example.start.view.abstracts.AbsWDItem;
import com.example.start.data.abstracts.AbsElement;
import com.example.start.data.objects.Attribute;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

public class NewsImageElement extends AbsElement {

    private static final String ATTR_SRC = "src";
    private static final String ATTR_ALT = "alt";

    private static final String TAG = "img";

    public NewsImageElement() {
        addAppropriateAttribute(new Attribute(ATTR_SRC, ""));
        addAppropriateAttribute(new Attribute(ATTR_ALT, ""));
    }

    @Override
    public String getTag() {
        return TAG;
    }

    @Override
    public void fillData(AbsWDItem item) throws URISyntaxException {
        String title = null;
        try {
            title = new String(getAttributes().getValue(ATTR_ALT).getBytes());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        item.setImageUri(new URI(getAttributes().getValue(ATTR_SRC)));
        item.setTitle(getAttributes().getValue(ATTR_ALT));
    }
}
