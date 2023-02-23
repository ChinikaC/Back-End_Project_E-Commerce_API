package com.bnta.grechimomarketplace.models;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private Long orderId;
    private String buyerName;

    private Date timestamp;
    private long buyerId;
    private double orderValue;
    private String deliveryAddress;
    private List<ProductDTO> productDTOs;


    public OrderDTO(Long orderId, double orderValue, String deliveryAddress, List<ProductDTO> productDTOs, String buyerName, long buyerId, Date timestamp) {
        this.orderId = orderId;
        this.orderValue = orderValue;
        this.deliveryAddress = deliveryAddress;
        this.productDTOs = productDTOs;
        this.buyerName = buyerName;
        this.buyerId = buyerId;
        this.timestamp = timestamp;
    }

    public OrderDTO() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

//    public long getOrderValue() {
//        return orderValue;
//    }

    public String getOrderValue() {
        return String.format("%.2f", orderValue);
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
