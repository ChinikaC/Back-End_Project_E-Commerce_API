package com.bnta.grechimomarketplace.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


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

    public Order(long id, long order_value, String address, Buyer buyer) {
        this.id = id;
        this.order_value = order_value;
        this.address = address;
        this.buyer = buyer;
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
}
