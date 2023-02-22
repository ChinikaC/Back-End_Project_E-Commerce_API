package com.bnta.grechimomarketplace.models;

public class ProductDTO {
    private Long productId;
    private String name;
    private long price;
    private String description;
    private String sellerName;
    private long sellerId;
    private long stockLevel;

    public ProductDTO(Long productId, String name, long price, String description, String sellerName, long sellerId, long stockLevel) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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

