package com.dc;

import com.dc.core.Parser;

public class App 
{
    public static void main(String[] args) {

        if(args.length < 2) {
            System.out.println("0: Error occurred: check arguments passed.");
            return;
        }

        try {
            Parser parser = new Parser(args[0], Double.parseDouble(args[1]));
            parser.run();
            System.out.println(parser.getOffers().getOffersPriceFiltered().toString());
        } catch( Exception exc ) {
            //exc.printStackTrace();
            System.out.println("1: Error occurred: check arguments passed.");
        }
    }
}
