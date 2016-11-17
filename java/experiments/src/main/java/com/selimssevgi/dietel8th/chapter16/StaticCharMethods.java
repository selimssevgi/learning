package com.selimssevgi.dietel8th.chapter16;

import java.util.Scanner;

/**
 * Created by ssselim on 8/5/16.
 */
public class StaticCharMethods {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a character : ");
        char c = scan.next().charAt(0);

        System.out.printf("is defined : %b\n", Character.isDefined( c ));
        System.out.printf("is digit : %b\n", Character.isDigit( c ));
        System.out.printf("is letter : %b\n", Character.isLetter( c ));
        System.out.printf("is letter or digit : %b\n", Character.isLetterOrDigit( c ));
        System.out.printf("is lowercase : %b\n", Character.isLowerCase( c ));
        System.out.printf("is uppercase : %b\n", Character.isUpperCase( c ));
        System.out.printf("to uppercase : %c\n", Character.toUpperCase( c ));
        System.out.printf("to lowercase : %c\n", Character.toLowerCase( c ));
    }
}
