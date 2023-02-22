package com.bnta.grechimomarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
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
    private String email;

    @Column
    private String address;

    @Column
    private String password;

    @OneToMany(mappedBy = "seller")
    @JsonIgnoreProperties({"seller"})
    private List<Product> products;

    public Seller(String name, BankCard card, String email, String address, String password,
                  List<Product> products) {
        this.name = name;
        this.card = card;
        this.email = email;
        this.address = address;
        this.password = password;
        this.products = products;
    }

    public Seller() {
        this.products = new ArrayList<>();
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

    @JsonIgnore
    public List<ProductDTO> getSellerProductDTOs(){
        List<ProductDTO> productDTOs = new ArrayList<>();
        for(Product product : products){
            productDTOs.add(new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getDescription(),
                    product.getSeller().getName(), product.getSeller().getId(), product.getStock()));
        }
        return productDTOs;
    }
}
