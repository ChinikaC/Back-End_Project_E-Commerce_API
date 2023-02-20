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
  private long accountBalance;

  @OneToOne(mappedBy = "card")
  private Buyer buyer;

  @OneToOne(mappedBy = "card")
  private Seller seller;

  public BankCard(long accountBalance) {
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

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }
}
