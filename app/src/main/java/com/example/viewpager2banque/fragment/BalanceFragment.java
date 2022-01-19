package com.example.viewpager2banque.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.viewpager2banque.ApplicationData;
import com.example.viewpager2banque.R;
import com.example.viewpager2banque.model.Account;

public class BalanceFragment extends Fragment {
    public TextView result;
    public int sum ;
    public int sumOfDeposit=0;
    public int sumOfWithdrawal=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(BalanceFragment.this.getContext(),"Taille"+ApplicationData.getInstance().myListBankAccount.size(),Toast.LENGTH_SHORT).show();
        Toast.makeText(BalanceFragment.this.getContext(),"Taille"+ApplicationData.getInstance().myListWithdrawal.size(),Toast.LENGTH_SHORT).show();
        sumOfListDeposit();
        sumOfListWithdrawal();
        calculate();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_balance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        result = view.findViewById(R.id.txt_final_balance);
    }

    public int sumOfListDeposit(){
        for(Account account: ApplicationData.getInstance().myListBankAccount) {
            sumOfDeposit += account.getAmountDeposit();
        }
        Toast.makeText(BalanceFragment.this.getContext(),"Total depot:  "+sumOfDeposit,Toast.LENGTH_SHORT).show();
        return sumOfDeposit;
    }

    public int sumOfListWithdrawal(){
        for(Account account:ApplicationData.getInstance().myListWithdrawal){
            sumOfWithdrawal+= account.getAmountWithdrawal();
        }
        Toast.makeText(BalanceFragment.this.getContext(),"Total Retrait:  "+sumOfWithdrawal,Toast.LENGTH_SHORT).show();
        return sumOfWithdrawal;
    }

    public void calculate(){
        if(ApplicationData.getInstance().getOperationDeposit().getAccountTitle().equalsIgnoreCase(ApplicationData.getInstance().operationWithdrawal.getWithdrawalTitle())) {
            sum = (ApplicationData.getInstance().getOperationDeposit().getAmountDeposit()) - (ApplicationData.getInstance().getOperationWithdrawal().getAmountWithdrawal());
            sum= (sumOfDeposit)-(sumOfWithdrawal);
            Toast.makeText(BalanceFragment.this.getContext(), "TOTAL: " + sum, Toast.LENGTH_SHORT).show();
            result.setText(String.valueOf(sum));
        }else{
            result.setText("ERREURE DE DONNEES DE COMPTE");
        }
    }
}
