package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Store feliciasFS = new Store(50000);

        while (feliciasFS.isStoreOpen){
            Console.displayOptions(feliciasFS);
        }
        feliciasFS.calculateDailySales();
    }
}