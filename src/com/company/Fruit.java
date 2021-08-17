package com.company;

public class Fruit extends Product {

    public Fruit(String name, int price, int amt){
        this.name = name;
        this.price = price;
        this.amt = amt;
    }

    public String toString(){
        return "Product Name: " + name + " Price: " + price + " Amount in Stock: " + amt;
    }
}
