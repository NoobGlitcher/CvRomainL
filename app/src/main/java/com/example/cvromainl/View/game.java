package com.example.cvromainl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.cvromainl.R;

public class game extends AppCompatActivity {

    private Button bChicken, bData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bChicken = findViewById(R.id.Chicken);
        bData = findViewById(R.id.dataGame);

        bChicken.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), chickenGame.class);
            startActivity(intent);
            finish();

        });
        bData.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), dataGame.class);
            startActivity(intent);
            finish();

        });

    }
}