package com.pluralsight;

import java.util.Scanner;

//This code is calculating sandwich price
public class SandwichShop {
    public static void main(String[] args) {
        String sandwichSize = promptUserForSandwichSize();

        int userAge = promptUserForAge();

        double userTotal = calculateTotalSandwichPrice(sandwichSize, userAge);
        System.out.println(userTotal);
    }

    //This function is getting sandwich size.
    public static String promptUserForSandwichSize(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the sandwich size:");
        System.out.println("Regular: price $5.45");
        System.out.println("Large: price $8.95");
        System.out.print("Enter sandwich size: ");
        String size = scanner.nextLine();
        return size;
    }

    //This function is getting user age.
    public static int promptUserForAge(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("How old are you: ");
        int age = scanner.nextInt();
        return age;
    }

    //This function is calculating sandwich price based on size and discounts.
    public static double calculateTotalSandwichPrice(String sandwichSize, int userAge){
        //This is getting the sandwich size and assigning it price.
        double regularPrice = 0;
        if (sandwichSize.equals("Large") || sandwichSize.equals("large")){
            regularPrice = 8.95;
        }else if (sandwichSize.equals("Regular") || sandwichSize.equals("regular")){
            regularPrice = 5.45;
        }

        //This is calculating sandwich price after applying the discount.
        double sandwichNewPrice = regularPrice;
        if(userAge <= 17){
            sandwichNewPrice = sandwichNewPrice * 0.90;
        }else if(userAge >= 65){
            sandwichNewPrice = sandwichNewPrice * 0.80;
        }
        return sandwichNewPrice;
    }
}