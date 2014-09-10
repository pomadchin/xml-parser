package com.dc.core;

import com.dc.models.Offer;
import org.apache.commons.digester3.binder.AbstractRulesModule;

/*
 * Offers parser rules (slow - reflection)
 */
public class OffersModule extends AbstractRulesModule {

    @Override
    protected void configure() {
        forPattern("yml_catalog/shop/offers/offer").createObject().ofType(Offer.class)
                .then().setProperties().then().setNext("addOffer");

        forPattern("yml_catalog/shop/offers/offer/url").setBeanProperty();
        forPattern("yml_catalog/shop/offers/offer/price").setBeanProperty();
        forPattern("yml_catalog/shop/offers/offer/currencyId").setBeanProperty();
        forPattern("yml_catalog/shop/offers/offer/categoryId").setBeanProperty();
        forPattern("yml_catalog/shop/offers/offer/picture").setBeanProperty();
        forPattern("yml_catalog/shop/offers/offer/delivery").setBeanProperty();
        forPattern("yml_catalog/shop/offers/offer/name").setBeanProperty();
        forPattern("yml_catalog/shop/offers/offer/vendor").setBeanProperty();
        forPattern("yml_catalog/shop/offers/offer/description").setBeanProperty();
    }
}
