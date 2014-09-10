package com.dc.core;

import com.dc.models.Offers;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Parser {
    private Offers offers;
    private Digester digester;
    private FileInputStream fis;

    public Parser(String uri, Double price) throws FileNotFoundException {
        DigesterLoader digesterLoader = DigesterLoader.newLoader(new OffersModule());
        digester = digesterLoader.newDigester();
        digester.push(new Offers(price));

        this.fis = new FileInputStream(uri);
    }

    public void run() throws IOException, SAXException {
        if(fis != null)
            offers = digester.parse(fis);
    }

    public Offers getOffers() {
        return offers;
    }
}
