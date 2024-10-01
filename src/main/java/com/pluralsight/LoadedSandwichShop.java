package com.pluralsight;

import java.util.Scanner;

public class LoadedSandwichShop {
    public static void main(String[] args){
        String sandwichSize = promptUserForSandwichSize();
        String sandwichLoaded = promptUserForSandwichLoaded();

        int userAge = promptUserForAge();

        double userTotal = calculateTotalSandwichPrice(sandwichSize, userAge, sandwichLoaded);
        System.out.println(userTotal);
    }

    //This method is getting sandwich size.
    public static String promptUserForSandwichSize(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the sandwich size:" +
                "\nRegular: price $5.45 " +
                "\nLarge: price $8.95 " +
                "\nEnter sandwich size: "
        );
        String size = scanner.nextLine();
        System.out.println("");
        return size;
    }

    public static String promptUserForSandwichLoaded(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want sandwich loaded (yes/no): ");
        String loaded = scanner.nextLine();
        System.out.println("Regular: $1.00\n" +
                "Large: $1.75");
        System.out.println("");
        return loaded;
    }

    //This method is getting user age.
    public static int promptUserForAge(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("How old are you: ");
        int age = scanner.nextInt();
        System.out.println("");
        return age;
    }

    //This method is calculating sandwich price based on size and discounts.
    public static double calculateTotalSandwichPrice(String sandwichSize, int userAge, String sandwichLoaded){
        //This is getting the sandwich size and assigning it price.
        double regularPrice = 0;
        if(sandwichLoaded.equals("yes")){
            if (sandwichSize.equals("Large") || sandwichSize.equals("large")){
                regularPrice = 8.95 + 1.00;
            }else if (sandwichSize.equals("Regular") || sandwichSize.equals("regular")){
                regularPrice = 5.45 + 1.75;
            }
        } else if(sandwichLoaded.equals("no")){
            if (sandwichSize.equals("Large") || sandwichSize.equals("large")){
                regularPrice = 8.95;
            }else if (sandwichSize.equals("Regular") || sandwichSize.equals("regular")){
                regularPrice = 5.45;
            }
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
