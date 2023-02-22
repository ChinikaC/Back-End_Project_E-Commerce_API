package com.bnta.grechimomarketplace.models;

import java.util.List;

public class ShoppingCartDTO {

    private List<ProductDTO> shoppingCartProducts;

    private long totalValue;

    private long itemQuantity;

    public ShoppingCartDTO(List<ProductDTO> products, long totalValue, long itemQuantity) {
        this.shoppingCartProducts = products;
        this.totalValue = totalValue;
        this.itemQuantity = itemQuantity;
    }

    public ShoppingCartDTO() {
    }

    public List<ProductDTO> getShoppingCartProducts() {
        return shoppingCartProducts;
    }

    public void setShoppingCartProducts(List<ProductDTO> shoppingCartProducts) {
        this.shoppingCartProducts = shoppingCartProducts;
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
