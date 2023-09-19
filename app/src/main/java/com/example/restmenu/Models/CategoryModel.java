package com.example.restmenu.Models;

import java.util.List;

public class CategoryModel {
    private String categoryId;
    private String categoryName;
    private boolean hasSubCategory;
    private boolean hasProduct;
    private String categoryImage;
    private int itemCount;
    private List<SubcategoryModel> subcategoryList;
    private List<ProductModel> productList;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isHasSubCategory() {
        return hasSubCategory;
    }

    public void setHasSubCategory(boolean hasSubCategory) {
        this.hasSubCategory = hasSubCategory;
    }

    public boolean isHasProduct() {
        return hasProduct;
    }

    public void setHasProduct(boolean hasProduct) {
        this.hasProduct = hasProduct;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<SubcategoryModel> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(List<SubcategoryModel> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }

    public List<ProductModel> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductModel
            > productList) {
        this.productList = productList;
    }
}

