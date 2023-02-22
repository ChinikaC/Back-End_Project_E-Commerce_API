package com.bnta.grechimomarketplace.models;

import java.util.List;

public class OrderDTO {
    private Long orderId;
    private String buyerName;
    private long buyerId;
    private long orderValue;
    private String deliveryAddress;
    private List<ProductDTO> productDTOs;

    public OrderDTO(Long orderId, long orderValue, String deliveryAddress, List<ProductDTO> productDTOs, String buyerName, long buyerId) {
        this.orderId = orderId;
        this.orderValue = orderValue;
        this.deliveryAddress = deliveryAddress;
        this.productDTOs = productDTOs;
        this.buyerName = buyerName;
        this.buyerId = buyerId;
    }

    public OrderDTO() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public long getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(long orderValue) {
        this.orderValue = orderValue;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public List<ProductDTO> getProductDTOs() {
        return productDTOs;
    }

    public void setProductDTOs(List<ProductDTO> productDTOs) {
        this.productDTOs = productDTOs;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }
}
