package com.example.fall;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fall.retrofit.ApiClient;
import com.example.fall.retrofit.api_interface.ApiInterface;
import com.example.fall.retrofit.response.Faal;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ShowFaalActivity extends AppCompatActivity {

    Button btnRefresh;
    TextView textViewTitle;
    TextView textViewLeft;
    TextView textViewRight;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faal);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewLeft = findViewById(R.id.textViewLeft);
        textViewRight = findViewById(R.id.textViewRight);

        btnRefresh = findViewById(R.id.btnRefresh);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            finish();
        });
        btnRefresh.setOnClickListener(v -> {
            callApiFaal();
        });

        callApiFaal();
    }

    private void callApiFaal() {

        ApiInterface apiInterface = ApiClient.getClient(this).create(ApiInterface.class);
        apiInterface.showFaal().enqueue(new Callback<Faal>() {
            @Override
            public void onResponse(Call<Faal> call, Response<Faal> response) {

                StringBuilder stringBuilderLeft = new StringBuilder();
                StringBuilder stringBuilderRight = new StringBuilder();

                assert response.body() != null;
                if (response.body().verses != null)
                    for (int i = 0; i < response.body().verses.size(); i++) {
                        if (response.body().verses.get(i).vOrder % 2 == 0) {
                            stringBuilderLeft.append(response.body().verses.get(i).text);
                        } else {
                            stringBuilderRight.append(response.body().verses.get(i).text);
                        }

                    }
                textViewRight.setText(stringBuilderRight);
                textViewLeft.setText(stringBuilderLeft);
                textViewTitle.setText(response.body().title);
            }

            @Override
            public void onFailure(Call<Faal> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

}