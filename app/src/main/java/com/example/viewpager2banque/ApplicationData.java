package com.example.viewpager2banque;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viewpager2banque.fragment.DepositFragment;
import com.example.viewpager2banque.fragment.WithdrawalFragment;
import com.example.viewpager2banque.model.Account;
import java.util.ArrayList;

public class ApplicationData {
    public ArrayList<Account> myListBankAccount = new ArrayList<>();
    public ArrayList<Account> myListWithdrawal = new ArrayList<>();
    public Account balAmount;
    public Account operationDeposit;
    public Account operationWithdrawal;
    public int sum ;
    public int sumOfDeposit=0;
    public int sumOfWithdrawal=0;


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


      public int sumOfListDeposit(){
        for(Account account: ApplicationData.getInstance().myListBankAccount) {
            sumOfDeposit = sumOfDeposit+account.getAmountDeposit();
            Log.d("T D", String.valueOf(sumOfDeposit));
        }
        return sumOfDeposit;
    }

    public int sumOfListWithdrawal(){
        for(Account account:ApplicationData.getInstance().myListWithdrawal){
            sumOfWithdrawal+= account.getAmountWithdrawal();
            Log.d("T W", String.valueOf(sumOfWithdrawal));

        }
        return sumOfWithdrawal;
    }

    public void thecalculate(TextView rest){
        if(ApplicationData.getInstance().getOperationDeposit().getAccountTitle().equalsIgnoreCase(ApplicationData.getInstance().operationWithdrawal.getWithdrawalTitle())) {
            sum = (ApplicationData.getInstance().getOperationDeposit().getAmountDeposit()) - (ApplicationData.getInstance().getOperationWithdrawal().getAmountWithdrawal());
            sum= (sumOfDeposit)-(sumOfWithdrawal);
            rest.setText(String.valueOf(sum));
            Log.d("T ", String.valueOf(sum));

        }else{
            rest.setText("ERREURE DE DONNEES DE COMPTE");
        }
    }


    public int calculDeposit(){
        int sommeDeposit=0;
        for(Account account1 : ApplicationData.getInstance().myListBankAccount) {
            sommeDeposit = sommeDeposit + account1.getAmountDeposit();
        }
        return sommeDeposit;
    }

    public int calculWithdrawal(){
        int sommeWithdrawal=0;
        for(Account account1 : ApplicationData.getInstance().myListWithdrawal) {
            sommeWithdrawal = sommeWithdrawal + account1.getAmountWithdrawal();
        }
        return sommeWithdrawal;
    }

    public void calculate(TextView theResult){
        int sum=0;
        if(ApplicationData.getInstance().getOperationDeposit().getAccountTitle().equalsIgnoreCase(ApplicationData.getInstance().operationWithdrawal.getWithdrawalTitle())) {
            sum= (ApplicationData.getInstance().calculDeposit())-(ApplicationData.getInstance().calculWithdrawal());
            theResult.setText(String.valueOf(sum));
            Log.d("T ", String.valueOf(sum));

        }else{
            theResult.setText("ERREURE DE DONNEES DE COMPTE");
        }
    }

}