package com.company;

public class Meat extends Product{

    public Meat(String name, int price, int amt){
        super(name, price, amt);
    }

    public String toString(){
        return "Product Name: " + name + " Price: " + price + " Amount in Stock: " + amt;
    }
}