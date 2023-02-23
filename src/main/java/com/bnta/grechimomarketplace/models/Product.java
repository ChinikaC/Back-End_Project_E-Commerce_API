package com.bnta.grechimomarketplace.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonIgnoreProperties({"products"})
    private Seller seller;

    @Column
    private boolean listed;

    @Column
    private boolean fulfilled;

    @Column
    private long stock;

    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private List<Order> orders;

    public Product(String name, double price, String description, Seller seller, long stock, boolean listed, boolean fulfilled) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.seller = seller;
        this.listed = listed;
        this.fulfilled = fulfilled;
        this.stock = stock;
    }

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public void decrementStock() {
        stock -= 1;
    }
}
