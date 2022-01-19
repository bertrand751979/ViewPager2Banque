package com.example.viewpager2banque.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpager2banque.fragment.WithdrawalFragment;
import com.example.viewpager2banque.fragment.BalanceFragment;
import com.example.viewpager2banque.fragment.DepositFragment;

public class MainAdapter extends FragmentStateAdapter {
    public MainAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            Fragment fragment = new DepositFragment();
            return fragment;
        }else  if(position==1){
            Fragment fragment = new WithdrawalFragment();
            return fragment;
        } else {
            Fragment fragment = new BalanceFragment();
            return fragment;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
