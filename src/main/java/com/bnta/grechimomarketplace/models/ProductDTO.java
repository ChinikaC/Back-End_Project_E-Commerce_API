package com.bnta.grechimomarketplace.models;

public class ProductDTO {
    private Long productId;
    private String name;
    private long price;
    private String description;
    private String sellerName;
    private long sellerId;

    public ProductDTO(Long productId, String name, long price, String description, String sellerName, long sellerId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.sellerName = sellerName;
        this.sellerId = sellerId;
    }

    public ProductDTO() {
    }

    public Long getProductId() {
        return productId;
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

