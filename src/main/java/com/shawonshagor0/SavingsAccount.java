package com.shawonshagor0;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolderName, String password, int balance) {
        super(accountNumber, accountHolderName, password, balance);
    }



    @Override
    public String getAccountType(){
        return  "Savings Account";
    }

    @Override
    public double maxWithdrawal(){
        return getBalance();
    }
}
