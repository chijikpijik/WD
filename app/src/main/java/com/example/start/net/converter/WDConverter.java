package com.example.start.net.converter;

import com.example.start.object.abstracts.AbsWDItem;
import com.example.start.saxhadlers.WDHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akarpov on 6/8/14.
 */
public class WDConverter {

    public static List<AbsWDItem> fromBody(TypedInput body) {
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader("org.ccil.cowan.tagsoup.Parser");
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(body.in(), "windows-1251"));
        } catch (Exception e){
        }

        ContentHandler liHandler = new WDHandler();
        xmlReader.setContentHandler(liHandler);
        try {
            xmlReader.parse(new InputSource(reader));
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
       return ((WDHandler)liHandler).getWDModel();
    }
}
