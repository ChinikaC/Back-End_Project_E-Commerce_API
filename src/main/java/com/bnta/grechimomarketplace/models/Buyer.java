package com.bnta.grechimomarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String emailAddress;

    @Column
    private String password;

    @OneToOne
    private BankCard card;

    @OneToMany(mappedBy = "buyer")
    @JsonIgnoreProperties({"buyer"})
    private List<Order> orders;

    public Buyer(String name, String emailAddress, String password, BankCard card, List<Order> orders) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.card = card;
        this.orders = orders;
    }
    
    public Buyer(){
        
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public BankCard getCard() {
        return card;
    }

    public void setCard(BankCard card) {
        this.card = card;
    }
}
