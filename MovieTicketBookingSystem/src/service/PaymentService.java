package service;

import java.util.Scanner;

import interfaces.PaymentOperations;

public class PaymentService implements PaymentOperations {

    Scanner sc = new Scanner(System.in);

    // Card Payment
    @Override
    public double cardPayment(double amount) {

        System.out.println("\n========== CARD PAYMENT ==========");

        System.out.print("Enter Card Number : ");
        String cardNumber = sc.next();

        System.out.print("Enter Card Holder Name : ");
        sc.nextLine();
        String holderName = sc.nextLine();

        System.out.print("Enter Expiry Date (MM/YY) : ");
        String expiry = sc.next();

        System.out.print("Enter CVV : ");
        String cvv = sc.next();

        System.out.println("\nProcessing Card Payment...");

        System.out.println("--------------------------------");
        System.out.println("Payment Successful.");
        System.out.println("Amount Paid : ₹" + amount);
        System.out.println("Payment Mode : Card");
        System.out.println("--------------------------------");

        return amount;
    }

    // UPI Payment
    @Override
    public double upiPayment(double amount) {

        System.out.println("\n========== UPI PAYMENT ==========");

        System.out.print("Enter UPI ID : ");
        String upiId = sc.next();

        System.out.println("\nProcessing UPI Payment...");

        System.out.println("--------------------------------");
        System.out.println("Payment Successful.");
        System.out.println("Amount Paid : ₹" + amount);
        System.out.println("Payment Mode : UPI");
        System.out.println("--------------------------------");

        return amount;
    }

    // Wallet Payment
    @Override
    public double walletPayment(double amount) {

        System.out.println("\n========== WALLET PAYMENT ==========");

        System.out.print("Enter Wallet Number : ");
        String walletNumber = sc.next();

        System.out.println("\nProcessing Wallet Payment...");

        System.out.println("--------------------------------");
        System.out.println("Payment Successful.");
        System.out.println("Amount Paid : ₹" + amount);
        System.out.println("Payment Mode : Wallet");
        System.out.println("--------------------------------");

        return amount;
    }

}