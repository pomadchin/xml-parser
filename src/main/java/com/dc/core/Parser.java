package com.dc.core;

import com.dc.models.Offers;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;

public class Parser {
    private Offers offers;
    private Digester digester;
    private FileInputStream fis;
    private PrintWriter pw; // output file writer

    // init to prevent code copy
    private void privateInit(String uri) throws FileNotFoundException {
        DigesterLoader digesterLoader = DigesterLoader.newLoader(new OffersModule());
        this.digester = digesterLoader.newDigester();
        this.fis = new FileInputStream(uri);

        // ignore dtd validation
        this.digester.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                if (systemId.contains("shops.dtd")) {
                    return new InputSource(new StringReader(""));
                } else {
                    return null;
                }
            }
        });
    }

    public void init(String[] args) throws FileNotFoundException {
        Integer argsLength = args.length;

        if(argsLength > 1)
            init(args[0], Double.parseDouble(args[1]));
        if(argsLength > 2)
            init(args[0], Double.parseDouble(args[1]), args[2]);
        if(argsLength > 3)
            init(args[0], Double.parseDouble(args[1]), args[2], Integer.parseInt(args[3]));
    }

    public void init(String uri, Double price) throws FileNotFoundException {
        privateInit(uri);

        this.digester.push(new Offers(price));
    }

    public void init(String uri, Double price, String out) throws FileNotFoundException {
        privateInit(uri);

        this.pw = new PrintWriter(new File(out));
        this.digester.push(new Offers(price, pw));
    }

    public void init(String uri, Double price, String out, Integer batch) throws FileNotFoundException {
        privateInit(uri);

        this.pw = new PrintWriter(new File(out));
        this.digester.push(new Offers(price, pw, batch));
    }

    public void run() throws IOException, SAXException {
        if(fis != null)
            offers = digester.parse(fis);
    }

    public void clear() {
        if(digester != null)
            digester.clear();

        if(offers != null)
            offers.clear();
    }

    public Boolean isWritable() {
        return pw != null;
    }

    public Offers getOffers() {
        return offers;
    }
}
