package com.bnta.grechimomarketplace.models;

import java.text.DecimalFormat;

public class ProductDTO {
    private Long productId;
    private String name;
    private double price;
    private String description;
    private String sellerName;
    private long sellerId;
    private long stockLevel;

    public ProductDTO(Long productId, String name, double price, String description, String sellerName, long sellerId, long stockLevel) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.sellerName = sellerName;
        this.sellerId = sellerId;
        this.stockLevel = stockLevel;
    }

    public ProductDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public double getPrice() {
//        return price;
//    }

    public String getPrice() {
        return String.format("%.2f", price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(long stockLevel) {
        this.stockLevel = stockLevel;
    }
}

