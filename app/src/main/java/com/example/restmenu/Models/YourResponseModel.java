package com.example.restmenu.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YourResponseModel {
    @SerializedName("items")
    private List<CategoryModel> categories;

    @Override
    public String toString() {
        return "YourResponseModel{" +
                "categories=" + categories +
                '}';
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryModel> categories) {
        this.categories = categories;
    }

    public YourResponseModel(List<CategoryModel> categories) {
        this.categories = categories;
    }



}
