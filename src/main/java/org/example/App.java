/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Asad merouani
 */
package org.example;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        Item totalItems[];
        float subTotal;
        float tax;
        float total;

        totalItems = app.getItemsPrice(scanner);

        subTotal = processItems(totalItems);

        tax = addSalesTax(subTotal);

        total = subTotal + tax;
        displayResults(total, tax);
    }

    private static void displayResults(float total, float tax) {
        System.out.printf("Tax: $%.2f\nTotal: $%.2f", tax, total);
    }

    private static float addSalesTax(float subTotal) {
        final float tax = 0.055f;
        return subTotal * tax;
    }

    private static float processItems(Item[] totalItems) {
        float subtotal = 0;

        for (int i = 0; i < 3; i++) {
            subtotal += totalItems[i].getPrice() * totalItems[i].getQuantity();


        }
        return subtotal;
    }

    private Item[] getItemsPrice(Scanner scanner) {
        float price;
        int quqntity;
        Item item[] = new Item[3];


        for (int i = 0; i < 3; i++) {
            System.out.printf("Enter the price of item %d: \n", i + 1);
            price = Float.parseFloat(scanner.nextLine());

            System.out.printf("Enter the quantity of item %d: \n", i + 1);
            quqntity = Integer.parseInt(scanner.nextLine());

            item[i] = new Item(price, quqntity);
        }
        return item;
    }
}
