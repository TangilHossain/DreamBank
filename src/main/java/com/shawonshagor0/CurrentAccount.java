package com.shawonshagor0;

public class CurrentAccount extends BankAccount{

    private final int overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolderName, String password, int overdraftLimit, int balance) {
        super(accountNumber, accountHolderName, password, "Current Account",  balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(int amount){
        if(amount > getBalance() + overdraftLimit){
            System.out.println("Insufficient funds!");
            return;
        }
        if(amount < 0){
            System.out.println("Negative amount.");
            return;
        }
        super.withdraw(amount);

    }

    @Override
    public String getAccountType(){
        return "Current Account";
    }
}
