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
                if (response.isSuccessful()) {
                    // Data has been fetched successfully
                    YourResponseModel data = response.body();


                    // Log the data
                    Log.d("MainActivity", "Fetched Data: " + data.toString());

                    // Extract category names from the data and set up your RecyclerView
                    List<CategoryModel> categories = data.getCategories();


                    // Initialize and set up your RecyclerView and Adapter here
                    MainCategoryAdapter adapter = new MainCategoryAdapter(MainActivity.this, categories);
                    adapter.setMainCategories(categories);
                    mainCategoryRecyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    // Handle the error here if the response was not successful
                    Log.e("MainActivity", "Failed to fetch data: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<YourResponseModel> call, Throwable t) {
                // Handle the failure here
                Log.e("MainActivity", "API call failed: " + t.getMessage());
            }
        });




//        initData();
//        initRecyclerView();
    }

//    private void initRecyclerView() {
//        MenuAdapter menuAdapter = new MenuAdapter(menuList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(menuAdapter);
//    }

/*    private void initData() {
        menuList = new ArrayList<>();
        menuList.add(new Item("Dish 1", "79"));
        menuList.add(new Item("Dish 3", "79"));
        menuList.add(new Item("Dish 2", "79"));
        menuList.add(new Item("Dish 4", "79"));
        menuList.add(new Item("Dish 5", "79"));
        menuList.add(new Item("Dish 6", "79"));
        menuList.add(new Item("Dish 7", "79"));
        menuList.add(new Item("Dish 8", "79"));
        menuList.add(new Item("Dish 9", "79"));
        menuList.add(new Item("Dish 10", "79"));
        menuList.add(new Item("Dish 11", "79"));
        menuList.add(new Item("Dish 12", "79"));
        menuList.add(new Item("Dish 13", "79"));
        menuList.add(new Item("Dish 14", "79"));
        menuList.add(new Item("Dish 15", "79"));
        menuList.add(new Item("Dish 16", "79"));
        menuList.add(new Item("Dish 17", "79"));
    }*/


}