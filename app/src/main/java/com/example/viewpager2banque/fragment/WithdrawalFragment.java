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
import com.example.viewpager2banque.R;
import com.example.viewpager2banque.adapter.WithdrawalAdapter;
import java.util.ArrayList;

public class WithdrawalFragment extends Fragment {
    private RecyclerView recyclerView;
    private WithdrawalAdapter withdrawalAdapter;
    private Button btnAddWithdrawal;
    private EditText editTitleWithdrawal;
    private EditText editAmountWithdrawal;
    private WithdrawalFragmentViewModel viewModelwithdrawal;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelwithdrawal = new ViewModelProvider(this).get(WithdrawalFragmentViewModel.class);
        if(ApplicationData.getInstance().getOperationDeposit()!=null){
            ApplicationData.getInstance().getOperationDeposit().getAmountDeposit();
            ApplicationData.getInstance().getOperationDeposit().getAccountTitle();
        }
        if(ApplicationData.getInstance().getOperationWithdrawal()==null){
            Toast.makeText(WithdrawalFragment.this.getContext(), "vide", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //withdrawalAdapter.setListWithdrawals(ApplicationData.getInstance().myListWithdrawal);

        viewModelwithdrawal.toPostWithdrawalList();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_withdrawal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_withdrawal);
        btnAddWithdrawal = view.findViewById(R.id.btn_add_withdrawal);
        editTitleWithdrawal = view.findViewById(R.id.edit_title_withdrawal);
        editAmountWithdrawal = view.findViewById(R.id.edit_amount_withdrawal);
        btnAddWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            viewModelwithdrawal.toAddWithdrawal(editTitleWithdrawal.getText().toString(), Integer.parseInt(editAmountWithdrawal.getText().toString()));
                withdrawalAdapter.setListWithdrawals(ApplicationData.getInstance().myListWithdrawal);
                ApplicationData.getInstance().calculWithdrawal();
            }
        });
        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        viewModelwithdrawal.toPostWithdrawalList();
        withdrawalAdapter = new WithdrawalAdapter();
        recyclerView.setAdapter(withdrawalAdapter);
        viewModelwithdrawal.liveDataWithdrawal.observe(getViewLifecycleOwner(), new Observer<ArrayList<Account>>() {
            @Override
            public void onChanged(ArrayList<Account> accounts) {
                withdrawalAdapter.setListWithdrawals(ApplicationData.getInstance().getMyListWithdrawal());
            }
        });
        viewModelwithdrawal.toPostWithdrawalList();
    }
}
