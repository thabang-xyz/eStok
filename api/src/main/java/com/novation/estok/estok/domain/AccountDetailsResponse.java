package com.novation.estok.estok.domain;

import java.math.BigDecimal;
import java.util.List;

public class AccountDetailsResponse {

    private String accountId;
    private String accountType;
    private String accountName;
    private BigDecimal balance;
    private BigDecimal availableBalance;
    private List<String> accountAliases;

    // Getters and Setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public List<String> getAccountAliases() {
        return accountAliases;
    }

    public void setAccountAliases(List<String> accountAliases) {
        this.accountAliases = accountAliases;
    }

    @Override
    public String toString() {
        return "AccountDetailsResponse{" +
                "accountId='" + accountId + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", availableBalance=" + availableBalance +
                ", accountAliases=" + accountAliases +
                '}';
    }
}

