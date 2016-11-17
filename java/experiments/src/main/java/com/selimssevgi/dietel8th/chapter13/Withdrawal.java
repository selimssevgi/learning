package com.selimssevgi.dietel8th.chapter13;

/**
 * Created by ssselim on 8/5/16.
 */
public class Withdrawal extends Transaction {
    private int amount;
    private Keypad keypad;
    private CashDispenser cashDispenser;


    public Withdrawal(int userAccountNumber , Screen screen,
                      BankDatabase bankDatabase, Keypad keypad,
                      CashDispenser cashDispenser) {
        super( userAccountNumber, screen, bankDatabase );

        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
    }


    @Override
    public void execute() {

    }
}
