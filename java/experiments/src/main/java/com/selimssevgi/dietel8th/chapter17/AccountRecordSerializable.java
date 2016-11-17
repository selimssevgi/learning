package com.selimssevgi.dietel8th.chapter17;

import java.io.Serializable;

/**
 * Created by ssselim on 8/5/16.
 */
public class AccountRecordSerializable implements Serializable {
    private int account;
    private String firstName;
    private String lastName;
    private double balance;

    public AccountRecordSerializable() {
        this( 0, "", "", 0.0 );
    }

    public AccountRecordSerializable(int account, String lastName, String firstName, double balance) {
        setAccount( account );
        setFirstName( firstName );
        setLastName( lastName );
        setBalance( balance );
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
