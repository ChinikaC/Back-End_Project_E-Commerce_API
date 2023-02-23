package com.bnta.grechimomarketplace.models;

public class OrderRequest {
    private long buyerId;
    private String deliveryAddress;

    public OrderRequest(long buyerId, String deliveryAddress) {
        this.buyerId = buyerId;
        this.deliveryAddress = deliveryAddress;
    }

    public OrderRequest() {
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
