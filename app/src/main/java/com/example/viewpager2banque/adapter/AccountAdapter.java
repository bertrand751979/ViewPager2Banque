package com.example.viewpager2banque.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2banque.model.Account;
import com.example.viewpager2banque.R;
import com.example.viewpager2banque.viewHolder.AccountViewHolder;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<AccountViewHolder> {
    private ArrayList<Account>listAccounts;

    public AccountAdapter() {
    }

    public void setListAccounts(ArrayList<Account> listAccounts) {
        this.listAccounts = listAccounts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_deposit,parent,false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        holder.bind(listAccounts.get(position));
    }

    @Override
    public int getItemCount() {
        return listAccounts.size();
    }
}
