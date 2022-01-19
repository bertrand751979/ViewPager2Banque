package com.example.viewpager2banque;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.viewpager2banque.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    public static String KEY_DEPOSIT_LIST="keyDepositList";
    public static String KEY_WITHDRAWAL_LIST="keyWithdrawalList";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayFragment();
    }
    private void displayFragment(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, new MainFragment()).commit();
    }

}