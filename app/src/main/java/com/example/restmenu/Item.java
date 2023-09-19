package com.example.restmenu;

public class Item {

    private String dishName;
    private String price;
    private boolean expanded;

    public Item(String dishName, String price) {
        this.dishName = dishName;
        this.price = price;

        this.expanded = false;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public boolean isExpanded() {
        return expanded;
    }

    public void     setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + dishName + '\'' +
                ", rating='" + price + '\'' +
                ", expanded=" + expanded +
                '}';
    }
}
