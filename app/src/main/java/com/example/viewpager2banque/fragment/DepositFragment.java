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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2banque.ApplicationData;
import com.example.viewpager2banque.model.Account;
import com.example.viewpager2banque.adapter.AccountAdapter;
import com.example.viewpager2banque.R;

import java.util.ArrayList;

public class DepositFragment extends Fragment {
    private RecyclerView recyclerView;
    private AccountAdapter accountAdapter;
    private Button btnAddDeposit;
    private EditText editTitleDeposit;
    private EditText editAmountDeposit;
    private DepositFragmentViewModel viewModelDeposit;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelDeposit = new ViewModelProvider(this).get(DepositFragmentViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        accountAdapter.setListAccounts(ApplicationData.getInstance().myListBankAccount);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_deposit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_deposit);
        btnAddDeposit = view.findViewById(R.id.btn_add_deposit);
        editTitleDeposit = view.findViewById(R.id.edit_title_deposit);
        editAmountDeposit = view.findViewById(R.id.edit_amount_deposit);
        btnAddDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            viewModelDeposit.toAddAccount(editTitleDeposit.getText().toString(),Integer.parseInt(editAmountDeposit.getText().toString()));
                Toast.makeText(DepositFragment.this.getContext(), "Nbre Compte"+ApplicationData.getInstance().myListBankAccount.size(), Toast.LENGTH_SHORT).show();
                    ApplicationData.getInstance().calculDeposit();

            }
        });
        setViewItem();
    }

   /* private void addBankAccount(){
        if(editTitleDeposit.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(DepositFragment.this.getContext(), "Veuillez sair un compte", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editAmountDeposit.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(DepositFragment.this.getContext(), "Veuillez sair un montant", Toast.LENGTH_SHORT).show();
            return;
        }
        Account account = new Account();
        account.setAccountTitle(editTitleDeposit.getText().toString());
        account.setAmountDeposit(Integer.parseInt(editAmountDeposit.getText().toString()));
        ApplicationData.getInstance().myListBankAccount.add(account);
        accountAdapter.setListAccounts(ApplicationData.getInstance().myListBankAccount);
        accountAdapter.notifyDataSetChanged();
        ApplicationData.getInstance().setOperationDeposit(account);
        Toast.makeText(DepositFragment.this.getContext(),"Ajouté"+account.getAmountDeposit(),Toast.LENGTH_SHORT).show();
        ApplicationData.getInstance().calculDeposit();
    }*/

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        viewModelDeposit.toPostMyListAccount();
        accountAdapter = new AccountAdapter();
        recyclerView.setAdapter(accountAdapter);
        viewModelDeposit.accountLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<Account>>() {
            @Override
            public void onChanged(ArrayList<Account> accounts) {
            accountAdapter.setListAccounts(ApplicationData.getInstance().myListBankAccount);
            }
        });
        viewModelDeposit.toPostMyListAccount();
    }
}
