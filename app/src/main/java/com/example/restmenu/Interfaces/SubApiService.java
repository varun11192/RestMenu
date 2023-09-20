package com.example.restmenu.Interfaces;

import com.example.restmenu.Models.SubcatResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SubApiService {
    @GET("v1/menu/full/2e00aba32138")
    Call<SubcatResponseModel> getSubcategories();
}

