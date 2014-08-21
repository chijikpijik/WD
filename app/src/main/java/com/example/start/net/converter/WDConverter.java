package com.example.start.net.converter;

import android.webkit.MimeTypeMap;
import com.example.start.net.ObjectMapper;
import com.example.start.object.abstracts.AbsWDItem;
import com.example.start.saxhadlers.WDHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akarpov on 6/8/14.
 */
public class WDConverter implements Converter {

    private final ObjectMapper mObjectMapper;

    public WDConverter() {
        mObjectMapper = new ObjectMapper();
    }

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        try {
            return mObjectMapper.readModel(body.in(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TypedOutput toBody(Object object) {
        try {
            return new TypedByteArray("application/html; charset=windows-1251",
                    ((String)object).getBytes("windows-1251"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
