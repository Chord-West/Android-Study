package com.example.personalassignment.model;

import java.util.Map;

public class Product {
    private String title;
    private String price;
    private String category;
    private boolean check=false;
    public Product(String title, String price, String category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                '}';
    }


}
