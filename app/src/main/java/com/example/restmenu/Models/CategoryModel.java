package com.example.restmenu.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryModel {
    private String categoryId;
    private String categoryName;
    private boolean hasSubCategory;
    private boolean hasProduct;
    private String categoryImage;
    private int itemCount;
    private boolean expanded;
    @SerializedName("subCategoryList")
    private List<SubcategoryModel> subcategoryList;
    @SerializedName("productList")
    private List<ProductModel> productList;

    public CategoryModel(String categoryId, String categoryName, boolean hasSubCategory, boolean hasProduct, String categoryImage, int itemCount, List<SubcategoryModel> subcategoryList, List<ProductModel> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.hasSubCategory = hasSubCategory;
        this.hasProduct = hasProduct;
        this.categoryImage = categoryImage;
        this.itemCount = itemCount;
        this.subcategoryList = subcategoryList;
        this.productList = productList;
        this.expanded = false;

    }

    public void     setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
    public boolean isExpanded() {
        return expanded;
    }

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

    @Override
    public String toString() {
        return "CategoryModel{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", hasSubCategory=" + hasSubCategory +
                ", hasProduct=" + hasProduct +
                ", categoryImage='" + categoryImage + '\'' +
                ", itemCount=" + itemCount +
                ", expanded=" + expanded +
                ", subcategoryList=" + subcategoryList +
                ", productList=" + productList +
                '}';
    }

    public void setProductList(List<ProductModel> productList) {
        this.productList = productList;
    }


}

