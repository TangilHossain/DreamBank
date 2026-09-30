package com.shawonshagor0;

import com.shawonshagor0.exceptions.InsuffiecientBalanceException;
import com.shawonshagor0.exceptions.NegativeAmountException;
import com.shawonshagor0.exceptions.SameAccountException;

import java.util.Objects;

public abstract class BankAccount implements Transferable {
    private final String accountNumber;
    private final String accountHolderName;
    private final String password;
    private double balance;


    public BankAccount(String accountNumber , String accountHolderName, String password, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;

        System.out.println("Account Created successfully!");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean matchPassword(String password) {
        return Objects.equals(password, this.password);
    }

    public void deposit(double amount){

        if(amount <= 0){
            throw new NegativeAmountException("Amount must be positive.");
        }
        balance += amount;
        System.out.println(amount + " added to " + this.accountHolderName + "'s account.\n Current balance: " + this.balance + ".");

    }

    public void withdraw(double amount){
            if(amount <= 0){
                throw new NegativeAmountException("Amount must be positive.");
            }
            if(amount > this.maxWithdrawal()){
                throw new InsuffiecientBalanceException("Insufficient funds!");
            }

        balance -= amount;

        System.out.println(amount + " deducted to " + this.accountHolderName + "'s account.\n Current balance: " + this.balance + ".\n");
    }

    public abstract double maxWithdrawal();

    public abstract String getAccountType();

    @Override
    public void transfer(BankAccount destAcc, double amount){
        if(this == destAcc){
            throw new SameAccountException("Transfer to same account is not possible!");
        }
        this.withdraw(amount);
        destAcc.deposit(amount);
        System.out.println("Transfer successful!");
    }
}
