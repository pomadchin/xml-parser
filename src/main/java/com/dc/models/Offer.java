package com.dc.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Offer {
    // default offer fields
    private String id = "";
    private Boolean available = true;
    private String url = "";
    private Double price = 0.0;
    private String currencyId = "RUR";
    private String categoryId = "";
    private Boolean delivery = true;
    private String name = "Yml";
    private String vendor = "";
    private String description = "";
    private List<String> picture = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getPictures() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture.add(picture);
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id='" + id + '\'' +
                ", available=" + available +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", currencyId='" + currencyId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", picture='" + picture + '\'' +
                ", delivery=" + delivery +
                ", name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
