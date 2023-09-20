package com.example.restmenu.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubcatResponseModel {
    @SerializedName("subCategoryList") // This should match the key in your JSON response
    private List<SubcategoryModel> subcategories;

    @Override
    public String toString() {
        return "SubcategoryResponseModel{" +
                "subcategories=" + subcategories +
                '}';
    }

    public List<SubcategoryModel> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryModel> subcategories) {
        this.subcategories = subcategories;
    }

    public SubcatResponseModel(List<SubcategoryModel> subcategories) {
        this.subcategories = subcategories;
    }
}
