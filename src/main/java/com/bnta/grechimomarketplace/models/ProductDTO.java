package com.bnta.grechimomarketplace.models;

public class ProductDTO {
    private Long id;
    private String name;
    private long price;
    private String description;
    private String sellerName;

    public ProductDTO(Long id, String name, long price, String description, String sellerName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.sellerName = sellerName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getSellerName() {
        return sellerName;
    }
}

