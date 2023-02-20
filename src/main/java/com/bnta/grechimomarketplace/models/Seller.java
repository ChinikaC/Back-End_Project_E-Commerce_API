package com.bnta.grechimomarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToOne
    private BankCard card;

    @Column
    private String emailAddress;

    @Column
    private String password;

    @OneToMany(mappedBy = "seller")
    @JsonIgnoreProperties({"seller"})
    private List<Product> products;

    public Seller(BankCard card, String name, String emailAddress, String password, List<Product> products) {
        this.card = card;
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.products = products;
    }

    public Seller(){
        
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BankCard getCard() {
        return card;
    }

    public void setCard(BankCard card) {
        this.card = card;
    }
}
