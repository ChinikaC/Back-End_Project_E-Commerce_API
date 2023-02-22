package com.bnta.grechimomarketplace.models;

import java.util.List;

public class OrderDTO {
    private Long id;
    private long orderValue;
    private String sellerName;
    private String deliveryAddress;
    private List<ProductDTO> productDTOs;

    public OrderDTO(Long id, long orderValue, String deliveryAddress, List<ProductDTO> productDTOs) {
        this.id = id;
        this.orderValue = orderValue;
        this.deliveryAddress = deliveryAddress;
        this.productDTOs = productDTOs;
    }

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(long orderValue) {
        this.orderValue = orderValue;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
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
}
