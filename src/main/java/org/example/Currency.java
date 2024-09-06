package org.example;

import java.util.Scanner;

public class Currency {

    // Predefined exchange rates
    private static final double USD_TO_EUR = 0.92;
    private static final double EUR_TO_USD = 1.0 / USD_TO_EUR; // Inverse of USD to EUR
    private static final double USD_TO_GBP = 0.79;
    private static final double USD_TO_JPY = 147.65;

    public static void main(String[] args) {
        Currency converter = new Currency();
        converter.run();
    }

    // Runs the currency conversion program
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Available conversions:");
        System.out.println("1. USD to EUR");
        System.out.println("2. EUR to USD");
        System.out.println("3. USD to GBP");
        System.out.println("4. USD to JPY");

        System.out.print("Choose the conversion option (1-4): ");
        int option = scanner.nextInt();

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(option, amount);

        if (convertedAmount != -1) {
            System.out.printf("Converted amount: %.2f%n", convertedAmount);
        } else {
            System.out.println("Invalid option selected.");
        }
    }

    // Converts the currency based on the selected option
    public double convertCurrency(int option, double amount) {
        switch (option) {
            case 1: // USD to EUR
                return amount * USD_TO_EUR;
            case 2: // EUR to USD
                return amount * EUR_TO_USD;
            case 3: // USD to GBP
                return amount * USD_TO_GBP;
            case 4: // USD to JPY
                return amount * USD_TO_JPY;
            default:
                return -1; // Invalid option
        }
    }
}

