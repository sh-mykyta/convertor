package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.ConvertOperations.*;
import static org.example.ConvertOperations.euroToSek;
import static org.example.ConvertOperations.euroToUsd;
import static org.example.ConvertOperations.usdToEuro;

public class ConsoleConverter {
    private static void displayMenu() {
        System.out.println("Currency Convertor App:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to Euro");
        System.out.println("4. Convert Euro to SEK");
        System.out.println("5. Convert Euro to USD");
        System.out.println("6. Convert USD to Euro");
        System.out.println("0. Exit");
        System.out.println("Enter your choice");
    }

    public static void runConverter(){
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        boolean continueConverting = true;

        while (continueConverting) {
            displayMenu();
            String choice = scanner.next();


            if (choice.equals("0")) {
                continueConverting = false;
                break;
            } else if (choice.equals("1") || choice.equals("2") ||
                    choice.equals("3") || choice.equals("4") ||
                    choice.equals("5") || choice.equals("6")){
                System.out.println("Enter the amount");

                try {
                    double num = scanner.nextDouble();

                    if (num < 0) {
                        System.out.println("Amount cannot be negative. Please enter a positive number.");
                        continue;  // возвращаемся к началу while
                    }

                    String operationTime = LocalDateTime.now().format(formatter);

                    switch (choice) {
                        case "1":
                            System.out.println("Result: " + sekToUsd(num) + " USD");
                            break;
                        case "2":
                            System.out.println("Result: " + usdToSek(num) + " SEK");
                            break;
                        case "3":
                            System.out.println("Result: " + sekToEuro(num) + " Euro");
                            break;
                        case "4":
                            System.out.println("Result: " + euroToSek(num) + " SEK");
                            break;
                        case "5":
                            System.out.println("Result: " + euroToUsd(num) + " USD");
                            break;
                        case "6":
                            System.out.println("Result: " + usdToEuro(num) + " Euro");
                            break;
                        default:
                            System.out.println("Invalid answer, try again");
                    }

                    System.out.println("Operation perform at: " + operationTime);

                }catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter numeric values.");
                    scanner.nextLine();
                }

            }else {
                System.out.println("Please try again");
            }

        }

        scanner.close();
        System.out.println("Calculator application ended.");

    }

}
