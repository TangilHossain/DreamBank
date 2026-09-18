package com.shawonshagor0;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    ArrayList<BankAccount> accounts = new ArrayList<>();

    public void createAccount(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Input account Name: ");
        String name = sc.nextLine();

        System.out.println("Input new Password: ");
        String password = sc.nextLine();

        System.out.println("Input initial balance: ");
        int balance;
        try{
            balance = sc.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long accountNumber = new Random().nextLong(1_000_000_000L, 9_000_000_000L);

        BankAccount account = new BankAccount(String.valueOf(accountNumber), name, password, balance);
        accounts.add(account);
        System.out.println("Account creation successful!\n Account number: " + accountNumber);
    }

    public BankAccount findAccount(String accNumber, String password){
        for(BankAccount account : accounts){
            if(Objects.equals(account.getAccountNumber(), accNumber)){
                if(Objects.equals(account.getPassword(), password)){
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
            System.out.println(account.getAccountNumber() + "|" + account.getAccountHolderName() + "|" + account.getBalance() + "\n");
        }
    }
}
