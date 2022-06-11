package com.example.fall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class FaaIPreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faal_pre);
        Button buttonFaal = findViewById(R.id.buttonFaal);
        buttonFaal.setOnClickListener(v -> {
            Intent intent = new Intent(FaaIPreActivity.this, ShowFaalActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

}