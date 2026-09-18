package com.shawonshagor0;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static void loggedIn(BankAccount account) {
        Scanner sc = new Scanner(System.in);

        boolean isLoggedIn = true;
        while(isLoggedIn){
            System.out.println("""
                    Choose option:\s
                    1. Check Balance
                    2. Debit
                    3. Credit
                    0. Log Out
                    """);
            int inputOption = sc.nextInt();
            switch (inputOption) {
                case 1:
                    System.out.println("Current balance is: " + account.getBalance());

                    break;
                case 2:
                    System.out.println("Current balance is " + account.getBalance() + "\nEnter the amount to be debited:");

                    int addBalance = sc.nextInt();
                    account.debit(addBalance);
                    break;
                case 3:
                    System.out.println("Current balance is " + account.getBalance() + "\nEnter the amount to be deducted:");

                    int deductBalance = sc.nextInt();
                    account.credit(deductBalance);
                    break;
                case 0:
                    System.out.println("""
                            Thanks for banking with us.\s
                            =====Dream Bank PLC.=====
                            """);
                    isLoggedIn = false;
                    break;
                default:
                    System.out.println("Try again!\n");
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("=====Welcome to the Dream Bank PLC=====\n");
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();


        boolean toExit = false;
        while(!toExit){
//            clearScreen();

            System.out.println("""
                    Choose option:\s
                    1. Create your DreamBank Account
                    2. Login to your DreamBank Account
                    3. Show all accounts
                    0. Exit
                    """);

            int input = sc.nextInt();sc.nextLine();
            switch (input){
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    System.out.print("Please enter your account number: ");
                    String inputAccount = sc.nextLine();

                    System.out.println("Please enter your account password: ");
                    String inputPass = sc.nextLine();

                    BankAccount account = bank.findAccount(inputAccount, inputPass);
                    if(account == null){
                        System.out.println("Account not found!");
                    }
                    else{
                        System.out.println("Login successful.\n");
                        loggedIn(account);
                    }
                    break;
                case 3:
                    bank.displayAllAccount();
                    break;
                case 0:
                    System.out.println("""
                            Thanks for banking with us.\s
                            =====Dream Bank PLC.=====
                            """);
                    toExit = true;
                    break;
                default:
                    System.out.println("Try again!");


            }

        }
    }
}