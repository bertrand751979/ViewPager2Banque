package com.example.viewpager2banque;

import com.example.viewpager2banque.model.Account;
import java.util.ArrayList;

public class ApplicationData {
    public ArrayList<Account> myListBankAccount = new ArrayList<>();
    public ArrayList<Account> myListWithdrawal = new ArrayList<>();
    public Account balAmount;
    public Account operationDeposit;
    public Account operationWithdrawal;

    private ApplicationData() {
    }

    private static ApplicationData INSTANCE = null;

    public static ApplicationData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationData();
        }
        return INSTANCE;
    }

    public Account getBalAmount() {
        return balAmount;
    }

    public void setBalAmount(Account balAmount) {
        this.balAmount = balAmount;
    }

    public Account getOperationDeposit() {
        return operationDeposit;
    }

    public void setOperationDeposit(Account operationDeposit) {
        this.operationDeposit = operationDeposit;
    }

    public Account getOperationWithdrawal() {
        return operationWithdrawal;
    }

    public void setOperationWithdrawal(Account operationWithdrawal) {
        this.operationWithdrawal = operationWithdrawal;
    }

}