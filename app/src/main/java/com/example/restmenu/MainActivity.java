package com.example.restmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.restmenu.Adapters.MainCategoryAdapter;
import com.example.restmenu.Interfaces.ApiService;
import com.example.restmenu.Models.CategoryModel;
import com.example.restmenu.Models.YourResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Retrofit for making API requests
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://inventory.fablocdn.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of ApiService to define API endpoints
        ApiService apiService = retrofit.create(ApiService.class);

        // Find the RecyclerView in the layout file
        RecyclerView mainCategoryRecyclerView = findViewById(R.id.menuRV);

        // Set up the RecyclerView with a LinearLayoutManager
        mainCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Make an asynchronous API call to fetch data
        Call<YourResponseModel> call = apiService.getCategoryData();

        call.enqueue(new Callback<YourResponseModel>() {
            @Override
            public void onResponse(Call<YourResponseModel> call, Response<YourResponseModel> response) {
                // Log the response code for debugging
                Log.d("response", "Response Code: " + response.code());

                if (response.isSuccessful()) {
                    // Parse the response body into a data object
                    YourResponseModel data = response.body();

                    if (data != null) {
                        // Log the fetched data for debugging
                        Log.d("notnulldata", "Fetched Data:\n" + data.toString());

                        // Extract the categories from the data
                        List<CategoryModel> categories = data.getCategories();

                        // Create an adapter to display the data in the RecyclerView
                        MainCategoryAdapter adapter = new MainCategoryAdapter(MainActivity.this, categories);

                        // Set the adapter on the RecyclerView
                        mainCategoryRecyclerView.setAdapter(adapter);

                        // Notify the adapter that the data set has changed
                        adapter.notifyDataSetChanged();
                    } else {
                        // Log an error message if the response body is null
                        Log.e("nulldata", "Response body is null.");
                    }
                } else {
                    // Log an error message if the API call was not successful
                    Log.e("MainActivity", "Failed to fetch data: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<YourResponseModel> call, Throwable t) {
                // Log an error message if the API call failed
                Log.e("failure", "API call failed: " + t.getMessage());
            }
        });
    }
}
