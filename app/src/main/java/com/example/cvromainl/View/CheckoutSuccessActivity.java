package com.example.cvromainl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cvromainl.R;
import com.example.cvromainl.databinding.ActivityCheckoutSuccessBinding;

public class CheckoutSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_success);
        ActivityCheckoutSuccessBinding layoutBinding = ActivityCheckoutSuccessBinding.inflate(getLayoutInflater());
        setContentView(layoutBinding.getRoot());
    }
}