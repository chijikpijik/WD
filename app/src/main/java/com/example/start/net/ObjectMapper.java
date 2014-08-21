package com.example.start.net;

import com.example.start.saxhadlers.WDHandler;
import com.example.start.utils.Utils;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import retrofit.converter.ConversionException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/**
 * Created by akarpov on 8/20/14.
 */
public class ObjectMapper {

    public Object readModel(InputStream src, Type valueType) throws ConversionException {
        if (valueType instanceof Class && DefaultHandler.class.isAssignableFrom((Class)valueType)) {
            try {
                WDMainParser parser = new WDMainParser((ContentHandler) ((Class)valueType).newInstance());
                return parser.parse(src);
            } catch (Exception e) {
                throw new ConversionException("Bad parser");
            }
        }
        throw new ConversionException("Bad type");
    }


}
