package com.selimssevgi.dietel8th.chapter16;

/**
 * Created by ssselim on 8/5/16.
 */
public class StringBuilderConstructors {

    public static void main(String[] args) {
        StringBuilder buffer1 = new StringBuilder(); // default capacity 16
        StringBuilder buffer2 = new StringBuilder( 10 );
        StringBuilder buffer3 = new StringBuilder( "hello" );

        System.out.printf("buffer1 = \"%s\" \n", buffer1);
        System.out.printf("buffer2 = \"%s\" \n", buffer2);
        System.out.printf("buffer3 = \"%s\" \n", buffer3);

        StringBuilder buffer4 = new StringBuilder("Hello! How are you?");

        System.out.printf(" buffer = '%s', length = %d, capacity = %d",
                buffer4, buffer4.length(), buffer4.capacity());

        buffer4.ensureCapacity( 75 );
        System.out.println("\n New capacity : " + buffer4.capacity());

        buffer4.setLength( 10 );
        System.out.printf(" new length = %d, buffer = '%s'", buffer4.length(), buffer4.toString());

        System.out.println();
        StringBuilder sb = new StringBuilder( "hello there" );
        System.out.printf("buffer = '%s' \n", sb.toString());
        System.out.printf("Character at 0 = '%c',\n character at 4 = '%c'",
                sb.charAt(0), sb.charAt(4) );
        System.out.println();

        char charArray[] = new char[ sb.length() ];
        sb.getChars(0, sb.length(), charArray, 0);

        System.out.println( "The characters are : " );

        for (Character currentChar : charArray ) {
            System.out.printf("%c ", currentChar);
        }

        sb.setCharAt(0, 'H');
        sb.setCharAt(6, 'T');
        System.out.printf("\nbuffer = '%s'\n", sb.toString());

        sb.reverse();
        System.out.printf("\nbuffer.reverse = '%s'\n", sb.toString());


    }
}
