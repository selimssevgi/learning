package com.selimssevgi.dietel8th.chapter11;

/**
 * Created by ssselim on 8/4/16.
 */
public class UsingExceptions {

    public static void main( String[] args ) {

        try {
            throwException();
        } catch ( Exception e ) {
            System.err.println("exception handled in main");
        }

        doesNotThrowException();
    }

    private static void throwException() throws Exception {

        try {
            System.out.println("Exception in the method");
            throw new Exception();
        } catch ( Exception e ) {
            System.err.println("exception handled in throwException");
            throw e;
        } finally {
            System.err.println("finally executed in throwException");
        }

    }

    // demonstrate finally when no exception occurs
    public static void doesNotThrowException() {
        try // try block does not throw an exception
        {
            System.out.println("Method doesNotThrowException");
        } // end try
        catch (Exception exception) // does not execute
        {
            System.err.println(exception);
        } // end catch
        finally // executes regardless of what occurs in try...catch
        {
            System.err.println(
                    "Finally executed in doesNotThrowException");
        } // end finally
        System.out.println("End of method doesNotThrowException");
    }
}
