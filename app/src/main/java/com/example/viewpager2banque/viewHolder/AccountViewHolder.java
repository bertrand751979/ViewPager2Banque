package com.example.viewpager2banque.viewHolder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2banque.model.Account;
import com.example.viewpager2banque.R;

public class AccountViewHolder extends RecyclerView.ViewHolder {
    private TextView vhAccountNameDeposit;
    private TextView vhAccountAmountDeposit;

    public AccountViewHolder(@NonNull View view) {
        super(view);
        vhAccountNameDeposit = view.findViewById(R.id.raw_deposit_title);
        vhAccountAmountDeposit = view.findViewById(R.id.raw_deposit_amount);
    }

    public TextView getVhAccountNameDeposit() {
        return vhAccountNameDeposit;
    }

    public void setVhAccountNameDeposit(TextView vhAccountNameDeposit) {
        this.vhAccountNameDeposit = vhAccountNameDeposit;
    }

    public TextView getVhAccountAmountDeposit() {
        return vhAccountAmountDeposit;
    }

    public void setVhAccountAmountDeposit(TextView vhAccountAmountDeposit) {
        this.vhAccountAmountDeposit = vhAccountAmountDeposit;
    }

    public void bind(Account account){
        vhAccountNameDeposit.setText(account.getAccountTitle());
        vhAccountAmountDeposit.setText(String.valueOf(account.getAmountDeposit()));
    }
}
