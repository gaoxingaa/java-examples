package org.example;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: principal amount, annual interest rate, and number of years
        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (as a percentage): ");
        double interestRate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Convert interest rate from percentage to decimal
        interestRate /= 100;

        // Calculate income (simple interest formula)
        double income = principal * interestRate * years;

        // Output the income
        System.out.println("The income after " + years + " years is: " + income);

        scanner.close();
    }
}
