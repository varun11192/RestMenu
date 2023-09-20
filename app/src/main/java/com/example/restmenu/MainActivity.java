package com.example.restmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.restmenu.Adapters.MainCategoryAdapter;
import com.example.restmenu.Models.CategoryModel;
import com.example.restmenu.Models.YourResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Item> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://inventory.fablocdn.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        RecyclerView mainCategoryRecyclerView = findViewById(R.id.menuRV);
        mainCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<YourResponseModel> call = apiService.getCategoryData();

        call.enqueue(new Callback<YourResponseModel>() {
            @Override
            public void onResponse(Call<YourResponseModel> call, Response<YourResponseModel> response) {
                Log.d("response", "Response Code: " + response.code());

                if (response.isSuccessful()) {
                    YourResponseModel data = response.body();

                    if (data != null) {
                        Log.d("notnulldata", "Fetched Data:\n" + data.toString()); // Log the response data
                        // Handle successful response
                        List<CategoryModel> categories = data.getCategories();

                        MainCategoryAdapter adapter = new MainCategoryAdapter(MainActivity.this, categories);
                        mainCategoryRecyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.e("nulldata", "Response body is null.");
                    }



                } else {
                    Log.e("MainActivity", "Failed to fetch data: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<YourResponseModel> call, Throwable t) {
                Log.e("failure", "API call failed: " + t.getMessage());
            }
        });


    }




}