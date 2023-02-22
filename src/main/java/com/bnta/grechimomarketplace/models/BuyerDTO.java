package com.bnta.grechimomarketplace.models;

import jakarta.persistence.Column;

import java.util.List;

public class BuyerDTO {

    private long id;
    private String name;
    private String email;
    private String address;
    private ShoppingCartDTO shoppingCart;
    private List<OrderDTO> orders;

    public BuyerDTO(long id, String name, String email, String address,
                    ShoppingCartDTO shoppingCart, List<OrderDTO> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.shoppingCart = shoppingCart;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
