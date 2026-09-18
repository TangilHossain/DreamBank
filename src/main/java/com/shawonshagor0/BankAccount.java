package com.shawonshagor0;

public class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private final String password;
    private int balance;


    public BankAccount(String accountNumber ,String accountHolderName, String password, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;

        System.out.println("Account Created successfully!\n");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public void debit(int amount){

        if(amount <= 0){
            System.out.println("Amount must be positive\n");
            return;
        }
        balance += amount;
        System.out.println(amount + " added to " + this.accountHolderName + "'s account.\n Current balance: " + this.balance + ".\n");

    }

    public void credit(int amount){

        if(amount <= 0){
            System.out.println("Amount must be positive\n");
            return;
        }
        if(amount > balance){
            System.out.println("Amount is greater than balance\n");
            return;
        }

        balance -= amount;


        System.out.println(amount + " deducted to " + this.accountHolderName + "'s account.\n Current balance: " + this.balance + ".\n");
    }


}
