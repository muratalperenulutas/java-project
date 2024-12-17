package org.project.models;

import org.project.interfaces.Identifiable;

public class Product implements Identifiable {
    public Integer id;
    public String name;
    public String description;
    public String sellerId;
    public String imageUrl;
    public Double price;

    public Product(Integer id, String name, String description, String sellerId, String imageUrl, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sellerId = sellerId;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
