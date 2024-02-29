package com.example.cvromainl.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvromainl.R;

public class MainActivity extends AppCompatActivity {

    private Button bAnimation, bEshop, bGame, bLoggin, bSiteModificator, bWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAnimation = findViewById(R.id.Animation);
        bEshop = findViewById(R.id.eShop);
        bGame = findViewById(R.id.EscapeGame);
        bLoggin = findViewById(R.id.Loggin);
        bSiteModificator = findViewById(R.id.SiteModificator);
        bWallet = findViewById(R.id.Wallet);





        bAnimation.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), Animation.class);
            startActivity(intent);
            finish();

        });

        bGame.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), game.class);
            startActivity(intent);
            finish();

        });

        bEshop.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), Eshop.class);
            startActivity(intent);
            finish();

        });

        bLoggin.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), loggin.class);
            startActivity(intent);
            finish();

        });

        bSiteModificator.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), siteModificator.class);
            startActivity(intent);
            finish();

        });


        bWallet.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), CheckoutActivity.class);
            startActivity(intent);
            finish();

        });
    }
}