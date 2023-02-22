package com.bnta.grechimomarketplace.models;

import java.util.List;

public class SellerDTO {

    private long id;
    private String name;
    private String email;
    private String address;
    private List<ProductDTO> productDTOs;

    public SellerDTO(long id, String name, String email, String address, List<ProductDTO> productDTOs) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.productDTOs = productDTOs;
    }

    public SellerDTO() {
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

    public List<ProductDTO> getProductDTOs() {
        return productDTOs;
    }

    public void setProductDTOs(List<ProductDTO> products) {
        this.productDTOs = products;
    }
}
