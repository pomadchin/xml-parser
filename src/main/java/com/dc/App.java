package com.dc;

import com.dc.core.Parser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App  {

    /*
     * arg[0] - yml file
     * arg[1] - price to filter
     * arg[2] - output file (free mem to handle huge yml) (optional)
     * arg[3] - batch size for output file (optional)
     */

    public static void main(String[] args) {

        Integer argsLength = args.length;

        if(argsLength < 2) {
            System.out.println("0: Error occurred: check arguments passed.");
            return;
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("core-config.xml");
        Parser parser = (Parser) context.getBean("parser");

        try {
            if(argsLength > 1)
                parser.init(args[0], Double.parseDouble(args[1]));
            if(argsLength > 2)
                parser.init(args[0], Double.parseDouble(args[1]), args[2]);
            if(argsLength > 3)
                parser.init(args[0], Double.parseDouble(args[1]), args[2], Integer.parseInt(args[3]));

            parser.run();
            System.out.println("Yml path: " + args[0]);
            if(!parser.isWritable()) {
                System.out.println("Offer ids with price > " + args[1] + ":");
                System.out.println(parser.getOffers().getOffersPriceFiltered().toString());
            } else {
                System.out.println("OfferIds path: " + args[2]);
            }
        } catch( Exception exc ) {
            exc.printStackTrace();
            System.out.println("1: Error occurred: check arguments passed.");
        } finally {
            parser.clear();
        }
    }
}
