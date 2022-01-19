package com.example.viewpager2banque.model;

import java.io.Serializable;

public class Account implements Serializable {
    private String accountTitle;
    private int amountDeposit;
    private String withdrawalTitle;
    private int amountWithdrawal;
    private int amountBalance;

    public Account(String accountTitle, int amountDeposit, String withdrawalTitle, int amountWithdrawal, int amountBalance) {
        this.accountTitle = accountTitle;
        this.amountDeposit = amountDeposit;
        this.withdrawalTitle = withdrawalTitle;
        this.amountWithdrawal = amountWithdrawal;
        this.amountBalance = amountBalance;
    }

    public Account(){}

    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public int getAmountDeposit() {
        return amountDeposit;
    }

    public void setAmountDeposit(int amountDeposit) {
        this.amountDeposit = amountDeposit;
    }

    public String getWithdrawalTitle() {
        return withdrawalTitle;
    }

    public void setWithdrawalTitle(String withdrawalTitle) {
        this.withdrawalTitle = withdrawalTitle;
    }

    public int getAmountWithdrawal() {
        return amountWithdrawal;
    }

    public void setAmountWithdrawal(int amountWithdrawal) {
        this.amountWithdrawal = amountWithdrawal;
    }

    public int getAmountBalance() {
        return amountBalance;
    }

    public void setAmountBalance(int amountBalance) {
        this.amountBalance = amountBalance;
    }
}
