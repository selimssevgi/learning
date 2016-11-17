package com.selimssevgi.dietel8th.chapter17;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by ssselim on 8/5/16.
 */
public class CreateSequentialFile {
    private ObjectOutputStream output;

    public void openFile() {
        try {
            output = new ObjectOutputStream(
                    new FileOutputStream( "clients.ser ") );
        } catch (IOException e) {
            System.err.println("Error opening file.");
            e.printStackTrace();
        }
    }

    public void addRecords() {
        AccountRecordSerializable record;
        int accountNumber = 0;
        String firstName;
        String lastName;
        double balance;

        Scanner input = new Scanner(System.in);

        System.out.printf( "%s\n%s\n%s\n%s\n\n",
                "To terminate input, type the end-of-file indicator ",
                "when you are prompted to enter input.",
                "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
                "On Windows type <ctrl> z then press Enter" );
        System.out.printf( "%s\n%s",
                "Enter account number (> 0), first name, last name and balance.",
                "? " );

        while ( input.hasNext() ) {

            try {
                accountNumber = input.nextInt();
                firstName = input.next();
                lastName = input.next();
                balance = input.nextDouble();

                if ( accountNumber > 0 ) {
                    record = new AccountRecordSerializable(
                            accountNumber, firstName, lastName, balance );

                    output.writeObject( record );
                } else {
                    System.out.println("Account number must be greater than 0");
                }
            } catch (IOException e) {
                System.err.println("error writing to file.");
                e.printStackTrace();
            } catch (NoSuchElementException e) {
                System.err.println("invalid input.Try again.");
                input.nextLine();
            }

            System.out.printf( "%s %s\n%s", "Enter account number (>0),",
                    "first name, last name and balance.", "? " );
        }
    }

    public void closeFile() {
        if ( output != null ) {
            try {
                output.close();
            } catch (IOException e) {
                System.err.println("Error closing file.");
                System.exit( 1 );
            }
        }
    }
}
