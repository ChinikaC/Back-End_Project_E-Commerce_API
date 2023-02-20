package com.bnta.grechimomarketplace.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@Entity(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long order_value;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @JsonIgnoreProperties({"orders"})
    private Buyer buyer;

//    @ManyToMany(fetch = FetchType.EAGER) // fetch type added to resolve issue on line 80 of FlightController
//    @JoinTable(name = "flights_passengers", // specifies the name of the linking table that will be used to store the associations between the two entities
//            joinColumns = @JoinColumn(name = "flight_id"),
//            inverseJoinColumns = @JoinColumn(name = "passenger_id"))
//    @JsonIgnoreProperties("flights")
    
    @ManyToMany
    @JoinTable(name = "orders_products",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonIgnoreProperties("orders")
    private List<Product> products;

    public Order(Buyer buyer, String address) {
        this.buyer = buyer;
        this.address = address;
    }

    public Order(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrder_value() {
        return order_value;
    }

    public void setOrder_value(long order_value) {
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
}
