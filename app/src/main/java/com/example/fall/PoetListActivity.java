package com.example.fall;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fall.retrofit.ApiClient;
import com.example.fall.retrofit.api_interface.ApiInterface;
import com.example.fall.retrofit.response.Poet;

import java.util.List;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;

public class PoetListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poet_list);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        callApi();
    }

    private void callApi() {
        ApiInterface apiInterface = ApiClient.getClient(this).create(ApiInterface.class);
        apiInterface.getPoetList().enqueue(new Callback<List<Poet>>() {
            @Override
            public void onResponse(Call<List<Poet>> call, retrofit2.Response<List<Poet>> response) {

                recyclerView.setAdapter(new PoetListAdapter(PoetListActivity.this , response.body()));
            }

            @Override
            public void onFailure(Call<List<Poet>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

}