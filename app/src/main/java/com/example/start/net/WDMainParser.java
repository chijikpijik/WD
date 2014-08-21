package com.example.start.net;

import com.example.start.saxhadlers.WDHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import retrofit.mime.TypedInput;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by akarpov on 8/20/14.
 */
public class WDMainParser {

    private final ContentHandler mConcreteHandler;

    public WDMainParser(ContentHandler mConcreteHandler) {
        this.mConcreteHandler = mConcreteHandler;
    }

    public ContentHandler parse(InputStream body) {
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader("org.ccil.cowan.tagsoup.Parser");
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(body, "windows-1251"));
        } catch (Exception e){
        }

        xmlReader.setContentHandler(mConcreteHandler);
        try {
            xmlReader.parse(new InputSource(reader));
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return mConcreteHandler;
    }

}
