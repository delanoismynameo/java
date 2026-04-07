package Improv;

import java.util.Scanner;
import java.io.File;         
import java.io.FileWriter;     
import java.io.IOException;     
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 

public class Main {
    public static void main(String[] args) {
        Scanner userSelection = new Scanner(System.in);
        RandomKey keyPicker = new RandomKey();
        int menuOption = 0;
        String fileName = "practice_log.txt";

        while (menuOption != 3) { 
            System.out.println("Welcome to the piano improvisation assistant!\nWhat would you like to do? (enter number)");
            System.out.println("1. Random Key\n2. View Practice History\n3. Exit"); 

            if (userSelection.hasNextInt()) {
                menuOption = userSelection.nextInt();
                userSelection.nextLine();
                
                if (menuOption == 1) {
                    String key = keyPicker.getRandomKey();
                    System.out.println("\n  Your key is: " + key);

                    try {
                        FileWriter writer = new FileWriter(fileName, true); 
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        
                        writer.write(now.format(formatter) + " - Practiced: " + key + "\n");
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while saving to the log.");
                        e.printStackTrace(); 
                    }

                    System.out.println("\nPress Enter to return to the menu...");
                    userSelection.nextLine();
                    menuOption = 0;
                    
                } else if (menuOption == 2) {
                   
                    System.out.println("\n--- Practice History ---");
                    try {
                        File logFile = new File(fileName);
                        if (logFile.exists()) {
                            Scanner fileReader = new Scanner(logFile);
                            while (fileReader.hasNextLine()) {
                                System.out.println(fileReader.nextLine());
                            }
                            fileReader.close();
                        } else {
                            System.out.println("No practice history found yet! Generate a key first.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading the log.");
                        e.printStackTrace();
                    }
                    
                    System.out.println("------------------------");
                    System.out.println("Press Enter to return to the menu...");
                    userSelection.nextLine();
                    menuOption = 0;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.\n");
                userSelection.next(); 
            }
        }
        System.out.println("See ya next time!");
        userSelection.close();
    }
}