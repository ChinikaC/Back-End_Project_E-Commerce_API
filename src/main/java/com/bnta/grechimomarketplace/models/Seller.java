package com.bnta.grechimomarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long balance;

    @Column
    private String name;

    @Column
    private String emailAddress;

    @Column
    private String password;

    @OneToMany(mappedBy = "seller_id")
    @JsonIgnoreProperties({"seller_id"})
    private List<Product> products;

    public Seller(long id, long balance, String name, String emailAddress, String password, List<Product> products) {
        this.id = id;
        this.balance = balance;
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

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
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
}
