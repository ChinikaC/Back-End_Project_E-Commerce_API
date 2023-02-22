package com.bnta.grechimomarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String password;
    
    @ManyToMany
    @JoinTable(name = "buyers_products",
            joinColumns = @JoinColumn(name = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonIgnoreProperties({"orders","buyers"})
    private List<Product> cart;

    @OneToOne
    private BankCard card;

    @OneToMany(mappedBy = "buyer")
    @JsonIgnoreProperties({"buyer"})
    private List<Order> orders;

    public Buyer(String name, String email, String address, String password, BankCard card) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.cart = new ArrayList<>();
        this.card = card;
        this.orders = new ArrayList<>();
    }

    public Buyer() {
        this.cart = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void emptyCart() {
        cart.clear();
    }

    public long getCartTotalValue() {
        long totalValue = 0l;
        if (!cart.isEmpty()) {
            for (Product product : cart) {
                totalValue += product.getPrice();
            }
            return totalValue;
        } else return 0l;
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

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public void addToCart(Product product) {
        this.cart.add(product);
    }

    public List<OrderDTO> getBuyerOrderDTOs() {
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            orderDTOs.add(new OrderDTO(order.getId(),order.getOrderValue(),order.getAddress(),order.getOrderProductDTOs(),order.getBuyer().getName(), order.getBuyer().getId()));
        }
        return orderDTOs;
    }

    public List<ProductDTO> getBuyerCartDTOs() {
        List<ProductDTO> cartProductDTOs = new ArrayList<>();
        for (Product product : cart) {
            cartProductDTOs.add(new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getSeller().getName(), product.getSeller().getId()));
        }
        return cartProductDTOs;
    }

    public ShoppingCartDTO getBuyerShoppingCartDTO() {
        return new ShoppingCartDTO(this.getBuyerCartDTOs(),this.getCartTotalValue(),this.getCart().size());
    }


}
