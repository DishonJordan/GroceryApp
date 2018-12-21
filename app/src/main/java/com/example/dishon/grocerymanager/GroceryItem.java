package com.example.dishon.grocerymanager;

import java.util.Date;

public class GroceryItem {
    private String name;
    private String upc;
    private Date expiration_date;
    private int quantity;
    private double price;
    private boolean selected;

    public  GroceryItem(String n, int q){
        name = n;
        quantity = q;
        selected = false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void incrementQuantity(int num){
        quantity += num;

    }

    public void decrementQuantity(int num){
        if(num <= quantity){
            quantity -= num;
        }
        else
            System.out.println("Quantity must be positive");

    }

    public boolean isExpired(){
        Date today = new Date(System.currentTimeMillis());

        if(expiration_date.compareTo(today) == 0){
            return true;
        } else
            return false;

    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
