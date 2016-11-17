package com.selimssevgi.dietel8th.chapter13;

/**
 * Created by ssselim on 8/5/16.
 */
public class BankDatabase {
    private Account[] accounts;

    public BankDatabase() {
        accounts = new Account[ 2 ];
        accounts[ 0 ] =  new Account( 12345, 54321, 1000.0, 1200.0 );
        accounts[ 1 ] =  new Account( 98765, 56789, 200.0, 200.0 );
    }

    private Account getAccount( int accountnumber ) {
        for ( Account currentAccount : accounts ) {
            if ( currentAccount.getAccountNumber() == accountnumber ) {
                return currentAccount;
            }
        }

        return null;
    }

    public boolean authenticateUser( int userAccountNumber, int userPIN ) {
        Account userAccount = getAccount( userAccountNumber );

        if ( userAccount != null ) {
            return userAccount.validatePIN( userPIN );
        } else {
            return false;
        }
    }

    public double getAvailableBalance( int userAccountNumber ) {
        return getAccount( userAccountNumber ).getAvailableBalance();
    }

    public double getTotalBalance( int userAccountNumber ) {
        return getAccount( userAccountNumber ).getTotalBalance();
    }

    public void credit( int userAccountNumber, double amount ) {
        getAccount( userAccountNumber ).credit( amount );
    }

    public void debit( int userAccountNumber, double amount ) {
        getAccount( userAccountNumber ).debit( amount );
    }
}
