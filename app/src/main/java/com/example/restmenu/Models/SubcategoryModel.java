package com.example.restmenu.Models;

import java.util.List;

public class SubcategoryModel {
    private String categoryId;
    private String subcategoryId;
    private static String subcategoryName;
    private boolean hasProduct;
    private String categoryImage;
    private int itemCount;
    private List<ProductModel> productList;
    private boolean expanded;

    public SubcategoryModel(String categoryId, String subcategoryId, String subcategoryName, boolean hasProduct, String categoryImage, int itemCount, List<ProductModel> productList, boolean expanded) {
        this.categoryId = categoryId;
        this.subcategoryId = subcategoryId;
        this.subcategoryName = subcategoryName;
        this.hasProduct = hasProduct;
        this.categoryImage = categoryImage;
        this.itemCount = itemCount;
        this.productList = productList;
        this.expanded = expanded;
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

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public static String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
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

    public List<ProductModel> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductModel> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "SubcategoryModel{" +
                "categoryId='" + categoryId + '\'' +
                ", subcategoryId='" + subcategoryId + '\'' +
                ", subcategoryName='" + subcategoryName + '\'' +
                ", hasProduct=" + hasProduct +
                ", categoryImage='" + categoryImage + '\'' +
                ", itemCount=" + itemCount +
                ", productList=" + productList +
                ", expanded=" + expanded +
                '}';
    }
}
