package com.selimssevgi.dietel8th.chapter13;

/**
 * Created by ssselim on 8/5/16.
 */
public class Screen {

    public void displayMessage( String message ) {
        System.out.print( message );
    }

    public void displayMessageLine( String message ) {
        System.out.println( message );
    }

    public void displayDollarAmount( double amount ) {
        System.out.printf("$%,.2f", amount);
    }
}
