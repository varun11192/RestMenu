package com.example.restmenu;

import com.example.restmenu.Models.CategoryModel;
import com.example.restmenu.Models.YourResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v1/menu/full/2e00aba32138") // The API endpoint URL for fetching data
    Call<YourResponseModel> getCategoryData(); // Replace YourResponseModel with your data model
}

