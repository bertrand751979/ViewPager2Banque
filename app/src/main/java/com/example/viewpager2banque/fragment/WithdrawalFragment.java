package com.example.viewpager2banque.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2banque.ApplicationData;
import com.example.viewpager2banque.model.Account;
import com.example.viewpager2banque.R;
import com.example.viewpager2banque.adapter.WithdrawalAdapter;

import java.util.ArrayList;

public class WithdrawalFragment extends Fragment {
    //public ArrayList<Account> myListWithdrawal = new ArrayList<>();
    private RecyclerView recyclerView;
    private WithdrawalAdapter withdrawalAdapter;
    private Button btnAddWithdrawal;
    private EditText editTitleWithdrawal;
    private EditText editAmountWithdrawal;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(ApplicationData.getInstance().getOperationDeposit()!=null){
            ApplicationData.getInstance().getOperationDeposit().getAmountDeposit();
            ApplicationData.getInstance().getOperationDeposit().getAccountTitle();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_withdrawal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  Toast.makeText(WithdrawalFragment.this.getContext(),"Montant du dépot:  "+ ApplicationData.getInstance().getOperationDeposit().getAmountDeposit()
       //         ,Toast.LENGTH_SHORT).show();




        recyclerView = view.findViewById(R.id.recycler_view_withdrawal);
        btnAddWithdrawal = view.findViewById(R.id.btn_add_withdrawal);
        editTitleWithdrawal = view.findViewById(R.id.edit_title_withdrawal);
        editAmountWithdrawal = view.findViewById(R.id.edit_amount_withdrawal);
        btnAddWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWithdrawal();



            }
        });
        setViewItem();
    }

    private void addWithdrawal(){
        Account account = new Account();
        account.setWithdrawalTitle(editTitleWithdrawal.getText().toString());
        account.setAmountWithdrawal(Integer.parseInt(editAmountWithdrawal.getText().toString()));
        ApplicationData.getInstance().myListWithdrawal.add(account);
        withdrawalAdapter.setListWithdrawals(ApplicationData.getInstance().myListWithdrawal);
        withdrawalAdapter.notifyDataSetChanged();
        ApplicationData.getInstance().setOperationWithdrawal(account);
        ApplicationData.getInstance().calculWithdrawal();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        withdrawalAdapter = new WithdrawalAdapter(ApplicationData.getInstance().myListWithdrawal);
        recyclerView.setAdapter(withdrawalAdapter);
    }



}
