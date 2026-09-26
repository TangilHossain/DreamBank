package com.shawonshagor0;

public class SavingsAccount extends BankAccount {
    private final double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double interestRate, String password, int balance) {
        super(accountNumber, accountHolderName, password, "Savings Account", balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest(){
        return interestRate/100 *  getBalance();
    }

    @Override
    public void withdraw(int amount) {
        if(amount > getBalance()){
            System.out.println("Insufficient funds!");
            return;
        }
        if(amount < 0){
            System.out.println("Negative amount is not allowed!");
            return;
        }
        super.withdraw(amount);
    }

    @Override
    public String getAccountType(){
        return  "Savings Account";
    }
}
