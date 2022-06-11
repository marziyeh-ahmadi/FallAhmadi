package com.example.fall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonFaal = findViewById(R.id.buttonFaal);
        Button buttonPoetList = findViewById(R.id.buttonPoetList);

        buttonFaal.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FaaIPreActivity.class);
            startActivity(intent);
        });

        buttonPoetList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PoetListActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

}