package com.bnta.grechimomarketplace.models;

import java.util.List;

public class ShoppingCartDTO {

    private List<ProductDTO> shoppingCartProducts;

    private double totalValue;

    private long itemQuantity;

    private String buyerName;

    private long buyerId;

    public ShoppingCartDTO(List<ProductDTO> products, double totalValue, long itemQuantity, String buyerName, long buyerId) {
        this.shoppingCartProducts = products;
        this.totalValue = totalValue;
        this.itemQuantity = itemQuantity;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
    }

    public ShoppingCartDTO() {
    }

    public List<ProductDTO> getShoppingCartProducts() {
        return shoppingCartProducts;
    }

    public void setShoppingCartProducts(List<ProductDTO> shoppingCartProducts) {
        this.shoppingCartProducts = shoppingCartProducts;
    }


//    public double getTotalValue() {
//        return totalValue;
//    }

    public String getTotalValue() {
        return String.format("%.2f", totalValue);
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

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }
}
