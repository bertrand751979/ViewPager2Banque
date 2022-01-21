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
import com.example.viewpager2banque.ApplicationData;
import com.example.viewpager2banque.R;
import com.example.viewpager2banque.model.Account;

public class BalanceFragment extends Fragment {
    public TextView result;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if((ApplicationData.getInstance().getOperationDeposit()!=null)&&(ApplicationData.getInstance().getOperationWithdrawal()!=null)){
            ApplicationData.getInstance().calculate(result);

        }

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
}
