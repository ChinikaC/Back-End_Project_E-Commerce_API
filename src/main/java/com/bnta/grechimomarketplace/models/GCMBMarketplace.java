package com.bnta.grechimomarketplace.models;
import jakarta.persistence.*;


@Entity(name = "marketplaces")
public class GCMBMarketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double balance;
    
    @Column
    private String address;

    public GCMBMarketplace(double balance, String address) {
        this.balance = balance;
        this.address = address;
    }

    public GCMBMarketplace() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
