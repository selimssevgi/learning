package chapter17;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by ssselim on 8/5/16.
 */
public class ReadSequentialFile {
    private ObjectInputStream input;

    public void openFile() {

        try {
            input = new ObjectInputStream(
                    new FileInputStream( "clients.ser" ) );
        } catch (IOException e) {
            System.err.println("Error opening file.");
        }
    }

    public void readRecords() {
        AccountRecordSerializable record;

        System.out.printf( "%-10s%-12s%-12s%10s\n", "Account",
                "First Name", "Last Name", "Balance" );

        try {

            while (true) {
                record = (AccountRecordSerializable) input.readObject();

                System.out.printf( "%-10d%-12s%-12s%10.2f\n",
                        record.getAccount(), record.getFirstName(),
                        record.getLastName(), record.getBalance() );
            }
        } catch (EOFException e) {
            return; // end of file reached
        } catch (ClassNotFoundException e) {
            System.err.println("Unable to create object");
        } catch (IOException e) {
            System.err.println("Error during read from file.");
        }
    }


    public void closeFile() {
        if ( input != null ) {
            try {
                input.close();
            } catch (IOException e) {
                System.err.println("error closing file");
                System.exit( 1 );
            }
        }
    }
}
