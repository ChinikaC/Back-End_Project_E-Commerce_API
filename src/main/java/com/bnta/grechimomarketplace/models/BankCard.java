package com.bnta.grechimomarketplace.models;

import jakarta.persistence.*;

@Entity (name = "bank_cards")
public class BankCard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String accountName;

  @Column
  private double accountBalance;

  @OneToOne(mappedBy = "card")
  private Buyer buyer;

  @OneToOne(mappedBy = "card")
  private Seller seller;

  public BankCard(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BankCard() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void addMoney(double money) {
      this.accountBalance += money;
    }

    public void reduceMoney(double money) {
      this.accountBalance -= money;
    }
}
