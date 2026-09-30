package com.shawonshagor0;

import com.shawonshagor0.exceptions.InsuffiecientBalanceException;
import com.shawonshagor0.exceptions.NegativeAmountException;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static void loggedIn(Bank bank, BankAccount account, Scanner sc) {

        boolean isLoggedIn = true;
        System.out.println("Welcome to Dream Bank Mr/Mrs" + account.getAccountHolderName());
        while(isLoggedIn){
            System.out.println("""
                    Choose option:\s
                    1. Check Balance
                    2. Deposit
                    3. Withdraw
                    4. Transfer
                    0. Log Out
                    """);
            int inputOption = sc.nextInt();sc.nextLine();
            switch (inputOption) {
                case 1:
                    System.out.println("Current balance is: " + account.getBalance());

                    break;
                case 2:
                    System.out.println("Current balance is " + account.getBalance() + "\nEnter the amount to be debited:");

                    int addBalance = sc.nextInt();
                    account.deposit(addBalance);
                    break;
                case 3:
                    System.out.println("Current balance is " + account.getBalance() + "\nEnter the amount to be withdrawn:");

                    int deductBalance = sc.nextInt();
                    try {
                        account.withdraw(deductBalance);
                    } catch (InsuffiecientBalanceException | NegativeAmountException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter the receiver's account number: ");
                    String destAccountNumber = sc.nextLine();
                    BankAccount destAcc = bank.findAccount(destAccountNumber);
                    if(destAcc == null){
                        System.out.println("Account does not exist!");
                        break;
                    }
                    System.out.print("Enter the amount to be transferred: ");
                    double amount = sc.nextDouble();sc.nextLine();
                    try {
                        account.transfer(destAcc, amount);
                    }catch (Exception e){
                        System.out.println("Transfer failed! " + e.getMessage());
                    }
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
        Scanner sc = new Scanner(System.in);

        System.out.println("=====Welcome to the Dream Bank PLC=====\n");
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
                    bank.createAccount(sc);
                    break;
                case 2:
                    System.out.print("Please enter your account number: ");
                    String inputAccount = sc.nextLine();

                    System.out.print("Please enter your account password: ");
                    String inputPass = sc.nextLine();

                    BankAccount account = bank.findAccount(inputAccount, inputPass);
                    if(account == null){
                        System.out.println("Account not found!");
                    }
                    else{
                        System.out.println("Login successful.\n");
                        loggedIn(bank, account, sc);
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
        sc.close();
    }
}