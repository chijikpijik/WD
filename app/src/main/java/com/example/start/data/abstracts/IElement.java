package com.example.start.data.abstracts;

import com.example.start.view.abstracts.AbsWDItem;
import org.xml.sax.Attributes;

import java.net.URISyntaxException;
import java.util.List;

public interface IElement {
     /**
     * @return tag name
     */
    public String getTag();

    /**
     * Returns Map of significant attributes to help find element in html code
     * @return Map: attr.name -> value
     */
    public List getAttributesForMatch(); //maybe getAppropriateAttributes

    public Attributes getAttributes();

    public void setAttributes(Attributes attributes);

    public void fillData(AbsWDItem item) throws URISyntaxException;
 }
