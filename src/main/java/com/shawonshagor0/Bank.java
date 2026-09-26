package com.shawonshagor0;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    private final ArrayList<BankAccount> accounts = new ArrayList<>();

    public void createAccount(Scanner sc) {


        System.out.println("""
                We offer two types of account:
                1. Current Account
                2. Savings Account""");
        System.out.print("Select account type: ");

        int accountType = sc.nextInt();sc.nextLine();

        System.out.println("Input account Name: ");
        String name = sc.nextLine();

        System.out.println("Input new Password: ");
        String password = sc.nextLine();

        System.out.println("Input initial balance: ");
        int balance;
        try{
            balance = sc.nextInt();sc.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long accountNumber = new Random().nextLong(1_000_000_000L, 9_000_000_000L);

        BankAccount account;
        if(accountType == 1){
            System.out.print("Enter overdraft limit: ");
            int overdraftLimit = sc.nextInt();
            account = new CurrentAccount(String.valueOf(accountNumber), name, password, overdraftLimit, balance);
        }
        else if(accountType == 2){
            System.out.print("Enter interest Rate: ");
            int interestRate = sc.nextInt();
            account = new SavingsAccount(String.valueOf(accountNumber), name, interestRate, password, balance);
        }
        else{
            System.out.println("Invalid account type");
            return;
        }
        accounts.add(account);
        System.out.println("Account creation successful!\n Account number: " + accountNumber);
    }

    public BankAccount findAccount(String accNumber, String password){
        for(BankAccount account : accounts){
            if(Objects.equals(account.getAccountNumber(), accNumber)){
                if(account.matchPassword(password)){
                    return account;
                }
                else{
                    System.out.println("Wrong Password!");
                }
            }
        }
        return null;
    }
    public void displayAllAccount(){
        for(BankAccount account: accounts){
            System.out.println(account.getAccountNumber() + " | " +account.getAccountType() + " | " + account.getAccountHolderName() + " | " + account.getBalance());
        }
    }
}
