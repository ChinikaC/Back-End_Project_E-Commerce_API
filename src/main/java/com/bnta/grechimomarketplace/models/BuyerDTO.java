package com.bnta.grechimomarketplace.models;

import java.util.List;

public class BuyerDTO {

    private long buyerId;
    private String name;
    private String email;
    private String address;
    private ShoppingCartDTO shoppingCart;
    private List<OrderDTO> orders;

    public BuyerDTO(long buyerId, String name, String email, String address,
                    ShoppingCartDTO shoppingCart, List<OrderDTO> orders) {
        this.buyerId = buyerId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.shoppingCart = shoppingCart;
        this.orders = orders;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShoppingCartDTO getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartDTO shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
