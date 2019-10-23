package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //This program takes the information regarding the user's loan (amount, rate, and term)
        //and calculates the total balance owed to the bank as well as the minimum monthly payment

        Scanner keyboard = new Scanner(System.in);
        double loanAmount = 0;
        double interest = 0;
        double monthlyPayment = 0;
        double balance = 0;
        int term;

        //prompts user for loan information
        System.out.printf("Enter the loan amount: ");
        loanAmount = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        interest = keyboard.nextDouble();

        System.out.printf("Enter the term (years) for the loan payment: ");
        term = keyboard.nextInt();

        System.out.printf("\n======================================\n");
        keyboard.close();

        //calls on the processSomething method to calculate the total balance owed to the bank
        //as well as the minimum monthly payment
        monthlyPayment = processSomething(loanAmount, interest, term);
        balance = -(monthlyPayment *(term*12));
        System.out.format("%-30s$%-+10.2f%n", "Balance owed to bank: ", balance);
        System.out.format("%-30s$%-+10.2f%n", "Minimum monthly payment: ", monthlyPayment);
    }

    // this method takes the information the user input and assigns calculations to them
    public static double processSomething(double loanAmount, double interest, int term) {

        // calculates the monthly payment
        double rate = (interest/ 100) / 12;
        double base = (1 + rate);
        double months = term* 12;
        double result = 0.0;
        result = ((rate * loanAmount) / (1 - Math.pow(base, -months)));

        return result;
    }
}
