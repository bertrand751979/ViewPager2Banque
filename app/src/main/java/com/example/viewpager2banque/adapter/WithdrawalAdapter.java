package com.example.viewpager2banque.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2banque.R;
import com.example.viewpager2banque.model.Account;
import com.example.viewpager2banque.viewHolder.WithdrawalViewHolder;

import java.util.ArrayList;

public class WithdrawalAdapter extends RecyclerView.Adapter<WithdrawalViewHolder> {
    private ArrayList<Account>listWithdrawals;

    public WithdrawalAdapter(ArrayList<Account> listWithdrawals) {
        this.listWithdrawals = listWithdrawals;
    }

    public void setListWithdrawals(ArrayList<Account> listWithdrawals) {
        this.listWithdrawals = listWithdrawals;
    }

    @NonNull
    @Override
    public WithdrawalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_withdrawal,parent,false);
        return new WithdrawalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WithdrawalViewHolder holder, int position) {
        holder.bind(listWithdrawals.get(position));
    }

    @Override
    public int getItemCount() {
        return listWithdrawals.size();
    }
}
