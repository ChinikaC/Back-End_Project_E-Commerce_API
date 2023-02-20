package com.bnta.grechimomarketplace.models;

import java.util.List;

public class ShoppingCartDTO {

    private List<Product> products;

    private long totalValue;

    private long itemQuantity;

    public ShoppingCartDTO(List<Product> products, long totalValue, long itemQuantity) {
        this.products = products;
        this.totalValue = totalValue;
        this.itemQuantity = itemQuantity;
    }

    public ShoppingCartDTO() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(long totalValue) {
        this.totalValue = totalValue;
    }

    public long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
