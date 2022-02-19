package com.example.viewpager2banque.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewpager2banque.ApplicationData;
import com.example.viewpager2banque.R;
import com.example.viewpager2banque.model.Account;

public class BalanceFragment extends Fragment {
    public TextView result;
    private BalanceFragmentViewModel viewModelBalance;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelBalance = new ViewModelProvider(this).get(BalanceFragmentViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModelBalance.calculateSum();
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
        setViewResult();
    }

    private void setViewResult(){
        viewModelBalance.calculateSum();
        viewModelBalance.resultLiveData.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer sum) {
                result.setText(String.valueOf(sum));
            }
        });
        viewModelBalance.calculateSum();
    }
}
