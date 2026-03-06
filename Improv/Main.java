package Improv;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userSelection = new Scanner(System.in);
        RandomKey keyPicker = new RandomKey();
        int menuOption = 0;
        while (menuOption != 2) {
            System.out.println("Welcome to the piano improvization assistant!\nWhat would you like to do? (enter number");
            System.out.println("1. Random Key\n2. Exit");

            if (userSelection.hasNextInt()) {
                menuOption = userSelection.nextInt();
                userSelection.nextLine();
                
                if (menuOption == 1) {
                    String key = keyPicker.getRandomKey();
                    System.out.println("\n  Your key is: " + key);

                    System.out.println("\nPress Enter to return to the menu...");
                    userSelection.nextLine();
                    // set menuOption back to zero to keep the key loop alive
                    menuOption= 0;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.\n");
                userSelection.next(); // Clear the invalid input
            }
        }
        System.out.println("See ya next time!");
        userSelection.close();
    }
}
