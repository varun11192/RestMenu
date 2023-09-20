package com.example.restmenu.Models;

public class ProductModel {

    private String productId;
    private String productName;
    private String productDesc;
    private String productImage;
    private int productPrice;
    private boolean isVeg;
    private boolean inStock;
    private int displayPrice;
    private boolean hasCustomization;
    private boolean hasAddOn;

    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public void setVeg(boolean veg) {
        isVeg = veg;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(int displayPrice) {
        this.displayPrice = displayPrice;
    }

    public boolean isHasCustomization() {
        return hasCustomization;
    }

    public void setHasCustomization(boolean hasCustomization) {
        this.hasCustomization = hasCustomization;
    }

    public boolean isHasAddOn() {
        return hasAddOn;
    }

    public void setHasAddOn(boolean hasAddOn) {
        this.hasAddOn = hasAddOn;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productPrice=" + productPrice +
                ", isVeg=" + isVeg +
                ", inStock=" + inStock +
                ", displayPrice=" + displayPrice +
                ", hasCustomization=" + hasCustomization +
                ", hasAddOn=" + hasAddOn +
                '}';
    }
}
