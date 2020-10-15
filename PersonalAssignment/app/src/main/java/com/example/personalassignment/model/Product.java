package com.example.personalassignment.model;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private String title;
    private String price;
    private String category;
    private boolean check=false;
    private String key;
    public Product(){

    }
    public Product(String title, String price, String category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }
    public Product(String title, String price, String category,String key) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.key=key;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("price", price);
        result.put("category", category);
        return result;
    }

}
