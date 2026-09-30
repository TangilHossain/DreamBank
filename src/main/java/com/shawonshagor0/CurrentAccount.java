package com.shawonshagor0;

public class CurrentAccount extends BankAccount{

    private final int overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolderName, String password, int overdraftLimit, int balance) {
        super(accountNumber, accountHolderName, password, balance);
        this.overdraftLimit = overdraftLimit;
    }


    @Override
    public String getAccountType(){
        return "Current Account";
    }

    @Override
    public double maxWithdrawal(){
        return getBalance() +  overdraftLimit;
    }
}
