package com.dc.models;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Offers class
 * stores offers and filtered ids
 */
public class Offers {
    private List<Offer> offers = new ArrayList<Offer>();
    private Double price;
    private PrintWriter pw; // output file writer
    private Integer batch = 80000;

    /*
     * contructor to enter price filter criteria
     */
    public Offers(Double price) {
        this.price = price;
    }

    public Offers(Double price, PrintWriter pw) {
        this.price = price;
        this.pw = pw;
    }

    public Offers(Double price, PrintWriter pw, Integer batch) {
        this.price = price;
        this.pw = pw;
        this.batch = batch;
    }

    public Offers() {

    }

    public List<Offer> getOffers() {
        return Collections.unmodifiableList(offers);
    }

    // if pw not null writes file
    public void addOffer(Offer offer) {
        if(price != null)
            if(offer.getPrice() > price)
                offers.add(offer);

        if(isWritable()) {
            if(offers.size() > 0 && (offers.size() % batch == 0)) {
                pw.write(offers.toString() + "\n");
                offers.clear();
            }
        }
    }

    public Boolean isWritable() {
        return pw != null;
    }

    public void clear() {
        if(isWritable()) {
            if(offers.size() > 0)
                pw.write(offers.toString() + "\n");

            pw.close();
        }

        offers.clear();
    }

    @Override
    public String toString() {
        return "Offers{" +
                "offers=" + offers +
                '}';
    }
}
