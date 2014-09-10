package com.dc.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Offers class
 * stores offers and filtered ids
 */
public class Offers {
    private List<Offer> offers = new ArrayList<Offer>();
    private List<String> offersPriceFiltered = new ArrayList<String>();
    private Double price;

    /*
     * contructor to enter price filter criteria
     */
    public Offers(Double price) {
        this.price = price;
    }

    public Offers() {

    }

    public List<Offer> getOffers() {
        return Collections.unmodifiableList(offers);
    }

    // TODO: mem free here (~send transaction, clean digester)
    public void addOffer(Offer offer) {
        offers.add(offer);
        if(price != null)
            if(offer.getPrice() > price)
                offersPriceFiltered.add(offer.getId());

    }

    public List<String> getOffersPriceFiltered() {
        return Collections.unmodifiableList(offersPriceFiltered);
    }

    @Override
    public String toString() {
        return "Offers{" +
                "offers=" + offers +
                ", offersPriceFiltered=" + offersPriceFiltered +
                ", price=" + price +
                '}';
    }
}
