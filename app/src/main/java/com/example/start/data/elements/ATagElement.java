package com.example.start.data.elements;

import com.example.start.data.abstracts.AbsElement;
import com.example.start.data.objects.Attribute;
import com.example.start.object.abstracts.AbsWDItem;
import org.xml.sax.Attributes;

/**
 * Created by akarpov on 7/10/14.
 */
public class ATagElement extends AbsElement {

    private CheckToogle mCheckToogle;

    private enum CheckToogle {
        NEVER,
        CHECKED,
        TOOGLED;
    }

    public ATagElement() {
        mCheckToogle = CheckToogle.NEVER;
        addAppropriateAttribute(new Attribute("href", ""));
        addAppropriateAttribute(new Attribute("class", "news-s-tag mr5"));
    }

    @Override
    public String getTag() {
        return "a";
    }

    @Override
    public boolean check(String tag, Attributes attributes) {
        return toogleCheckCounter(super.check(tag, attributes));
    }

    private boolean toogleCheckCounter(boolean isCheck) {
        if (isCheck) {
            if (mCheckToogle == CheckToogle.NEVER) {
                    mCheckToogle = CheckToogle.CHECKED;
            }
        } else if (mCheckToogle == CheckToogle.CHECKED){
            mCheckToogle = CheckToogle.TOOGLED;
        }
        return isCheck;
    }

    public boolean isToogle() {
        return mCheckToogle == CheckToogle.TOOGLED;
    }

    @Override
    public void provideDataTo(AbsWDItem item) {

    }
}
