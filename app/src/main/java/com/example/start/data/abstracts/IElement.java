package com.example.start.data.abstracts;

import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;
import org.xml.sax.Attributes;

import java.net.URISyntaxException;
import java.util.List;

public interface IElement {

    public enum ElementType {
        BLOCK,
        ELEMENT
    }

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

    public void setTagContent(String string);

    public String getTagContent();

    public void provideDataTo(AbsWDItem item);

    public boolean isTagContentRelated();

    public ElementType getElementType();

    public boolean check(String tag, Attributes attributes);

 }
