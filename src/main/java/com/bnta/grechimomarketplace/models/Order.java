package com.bnta.grechimomarketplace.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double order_value;

    @Column
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @JsonIgnoreProperties({"orders"})
    private Buyer buyer;

    @ManyToMany
    @JoinTable(name = "orders_products",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonIgnoreProperties("orders")
    private List<Product> products;

    public Order(Buyer buyer, String address) {
        this.buyer = buyer;
        this.address = address;
        this.products = new ArrayList<>();
        this.timestamp = new Date();
    }

    public Order(){
        this.products = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getOrder_value() {
        return order_value;
    }

    public void setOrder_value(double order_value) {
        this.order_value = order_value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getOrderValue() {
        double orderValue = 0;
        if (products != null) {
            for (Product product : products) {
                orderValue += product.getPrice();
            }
        }
        return orderValue;
    }

    public List<ProductDTO> getOrderProductDTOs() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(new ProductDTO(product.getId(),product.getName(),product.getPrice(),product.getDescription(),product.getSeller().getName(), product.getSeller().getId(), product.getStock()));
        }
        return productDTOs;
    }

    public void updateOrderValue() {
        double orderValue = 0;
        if (products != null) {
            for (Product product : products) {
                orderValue += product.getPrice();
            }
        }
        this.order_value = orderValue;
    }



}
