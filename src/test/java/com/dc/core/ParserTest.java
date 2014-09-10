package com.dc.core;

import com.dc.models.Offers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserTest {
    private static Parser parser = null;

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        parser = new Parser();
        parser.init("xml/yml.xml", 80500.00);
    }

    @Test
    public void testRun() throws IOException, SAXException {
        parser.run();

        Offers offers = parser.getOffers();
        Assert.assertNotNull("Offers were not created.", offers);

        List<String> ids = new ArrayList<String>();
        ids.add("2397");
        ids.add("2396");
        ids.add("2630");
        ids.add("2631");

        Assert.assertEquals("Incorrect filtered result", ids, offers.getOffersPriceFiltered());

        System.out.println(parser.getOffers().getOffersPriceFiltered().toString());

        parser.clear();
    }
}