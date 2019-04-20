package com.selimssevgi.dietel8th.chapter13;

/**
 * Created by ssselim on 8/5/16.
 */
public class Account {
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;

    public Account(int theAccountNumber, int thePin,
        double theAvailableBalance, double theTotalBalance)
    {
        accountNumber = theAccountNumber;
        pin = thePin;
        availableBalance = theAvailableBalance;
        totalBalance = theTotalBalance;
    }

    public boolean validatePIN( int userPin ) {
        return userPin == pin;
    }

    public void credit( double amount ) {
        totalBalance += amount;
    }

    public void debit( double amount ) {
        availableBalance -= amount;
        totalBalance -= amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getTotalBalance() {
        return totalBalance;
    }
}
