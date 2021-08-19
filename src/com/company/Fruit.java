package com.company;

public class Fruit extends Product {

    public Fruit(String name, int price, int amt){
        super(name, price, amt);
    }

    public String toString(){
        return "Product Name: " + name + " Price: " + price + " Amount in Stock: " + amt;
    }
}