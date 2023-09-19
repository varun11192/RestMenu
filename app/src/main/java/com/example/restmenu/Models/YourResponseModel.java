package com.example.restmenu.Models;

import java.util.List;

public class YourResponseModel {
    private List<CategoryModel> categories;

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
