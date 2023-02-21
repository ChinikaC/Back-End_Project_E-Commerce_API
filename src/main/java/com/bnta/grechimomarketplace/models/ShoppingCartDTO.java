package com.bnta.grechimomarketplace.models;

import java.util.List;

public class ShoppingCartDTO {

    private List<ProductDTO> products;

    private long totalValue;

    private long itemQuantity;

    public ShoppingCartDTO(List<ProductDTO> products, long totalValue, long itemQuantity) {
        this.products = products;
        this.totalValue = totalValue;
        this.itemQuantity = itemQuantity;
    }

    public ShoppingCartDTO() {
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
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
