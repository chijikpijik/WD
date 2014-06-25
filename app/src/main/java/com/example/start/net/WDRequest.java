package com.example.start.net;

import com.example.start.data.abstracts.IBlock;
import com.example.start.saxhadlers.WDHandler;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.net.URI;
import java.util.*;

public class WDRequest extends Request {

//    private List<IBlock> mBlocks;

    @Override
    public URI getUri() throws Exception {
        return new URI("http://webdiscover.ru/");
    }

    @Override
    public void parse(InputStream input) {
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader("org.ccil.cowan.tagsoup.Parser");
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(input, "windows-1251"));
        } catch (Exception e){
        }

        ContentHandler liHandler = new WDHandler();
        xmlReader.setContentHandler(liHandler);
//        mBlocks = ((WDHandler)liHandler).getBlockList();
        try {
            xmlReader.parse(new InputSource(reader));
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

//    public List<IBlock> getBlocks() {
//        return mBlocks;
//    }

}
