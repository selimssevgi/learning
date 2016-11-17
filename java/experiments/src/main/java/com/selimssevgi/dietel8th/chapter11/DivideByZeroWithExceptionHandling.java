package com.selimssevgi.dietel8th.chapter11;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by ssselim on 8/4/16.
 */
public class DivideByZeroWithExceptionHandling {

    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        boolean continueLoop = true;

        do {

            try {
                System.out.print(" Enter a numerator : ");
                int numerator = scan.nextInt();
                System.out.print(" Enter a denomitor : ");
                int denominator = scan.nextInt();

                int result = quotient(numerator, denominator);
                System.out.printf("Result : %d", result);
                continueLoop = false;
            } catch (InputMismatchException ime) {
                System.err.printf("\n Exception : %s \n", ime);
                scan.nextLine(); // discard input so user can try again
                System.out.println("You must enter integers. Try again");
            } catch (ArithmeticException ae) {
                System.err.printf("\n Exception : %s \n", ae);
                System.out.println("Zero is invalid denominator, Try again");
            }

        } while ( continueLoop );
    }

    private static int quotient(int numerator, int denominator) {
        return numerator / denominator;
    }
}
