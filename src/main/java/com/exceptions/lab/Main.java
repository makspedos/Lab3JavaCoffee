package com.exceptions.lab;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new ClassCoffyShop(10, new ArrayList<>());

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("You are able to interact with Coffee Shop");
        System.out.println("Our commands: buyCoffee, buyCoffeeIfPresent, giveFeedback, readFeedbacks, coffeeAmount, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "buycoffee":
                    try {
                        coffeeShop.buyCoffee();
                        System.out.println("You have successfully bought a coffee!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "buycoffeeifpresent":
                    boolean success = coffeeShop.buyCoffeeIfPresent();
                    if (success) {
                        System.out.println("You have successfully bought a coffee!");
                    } else {
                        System.out.println("Sorry, no coffee available.");
                    }
                    break;

                case "givefeedback":
                    System.out.print("Enter your feedback: ");
                    String feedback = scanner.nextLine();
                    try {
                        coffeeShop.giveFeedback(feedback);
                        System.out.println("Feedback submitted!");
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "readfeedbacks":
                    List<String> feedbacks = coffeeShop.readFeedbacks();
                    System.out.println("Feedbacks:");
                    for (String f : feedbacks) {
                        System.out.println("- " + f);
                    }
                    break;

                case "coffeeamount":
                    int amount = coffeeShop.coffeeAmount();
                    System.out.println("Coffee available: " + amount);
                    break;

                case "exit":
                    System.out.println("Exiting the Coffee Shop application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Available commands: buyCoffee, buyCoffeeIfPresent, giveFeedback, readFeedbacks, coffeeAmount, exit");
            }
        }
    }
}