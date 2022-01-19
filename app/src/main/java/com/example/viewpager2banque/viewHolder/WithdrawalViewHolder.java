package com.example.viewpager2banque.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2banque.R;
import com.example.viewpager2banque.model.Account;

public class WithdrawalViewHolder extends RecyclerView.ViewHolder {
    private TextView vhAccountNameWithdrawal;
    private TextView vhAccountAmountWithdrawal;


    public WithdrawalViewHolder(@NonNull View view) {
        super(view);
        vhAccountNameWithdrawal = view.findViewById(R.id.raw_withdrawal_title);
        vhAccountAmountWithdrawal = view.findViewById(R.id.raw_withdrawal_amount);

    }

    public TextView getVhAccountNameWithdrawal() {
        return vhAccountNameWithdrawal;
    }

    public void setVhAccountNameWithdrawal(TextView vhAccountNameWithdrawal) {
        this.vhAccountNameWithdrawal = vhAccountNameWithdrawal;
    }

    public TextView getVhAccountAmountWithdrawal() {
        return vhAccountAmountWithdrawal;
    }

    public void setVhAccountAmountWithdrawal(TextView vhAccountAmountWithdrawal) {
        this.vhAccountAmountWithdrawal = vhAccountAmountWithdrawal;
    }
    public void bind(Account account){
        vhAccountNameWithdrawal.setText(account.getWithdrawalTitle());
        vhAccountAmountWithdrawal.setText(String.valueOf(account.getAmountWithdrawal()));
    }
}
