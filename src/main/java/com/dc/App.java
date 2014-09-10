package com.dc;

import com.dc.core.Parser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App  {
    public static void main(String[] args) {

        if(args.length < 2) {
            System.out.println("0: Error occurred: check arguments passed.");
            return;
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("core-config.xml");
        Parser parser = (Parser) context.getBean("parser");

        try {
            parser.init(args[0], Double.parseDouble(args[1]));
            parser.run();
            System.out.println(parser.getOffers().getOffersPriceFiltered().toString());
        } catch( Exception exc ) {
            //exc.printStackTrace();
            System.out.println("1: Error occurred: check arguments passed.");
        }
    }
}
