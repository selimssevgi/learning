package com.selimssevgi.dietel8th.chapter20;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ssselim on 8/9/16.
 */
// Lists, LinkedList and ListIterators
public class ListTest {

    public static void main(String[] args) {
        String[] colors =
                { "black", "yellow", "green", "blue", "violet", "silver" };

        List<String> list = new LinkedList<>();

        for ( String color : colors ) {
           list.add( color );
        }

        // add colors2 elements to list2
        String[] colors2 =
                { "gold", "white", "brown", "blue", "gray", "silver" };
        List< String > list2 = new LinkedList<>();

        for ( String color : colors2 )
            list2.add( color );

        list.addAll( list2 );
        list2 = null; // let the gc do its work
        printList( list );

        convertToUpperCaseStrings( list );
        printList( list );

        System.out.println("\nDeleting element from 4 to 6...");
        removeItems( list, 4, 6 );
        printList( list );

        printReservedList( list );
    }

    private static void printReservedList(List<String> list) {
        ListIterator<String> iterator = list.listIterator( list.size() );

        System.out.println("\nReserved list: ");

        while ( iterator.hasPrevious() )
            System.out.printf("%s ", iterator.previous());
    }

    private static void removeItems(List<String> list, int start, int end) {
        list.subList( start, end).clear();
    }

    private static void convertToUpperCaseStrings(List<String> list) {
        ListIterator<String> iterator = list.listIterator();

        while ( iterator.hasNext() ) {
            String color = iterator.next();
            iterator.set( color.toUpperCase() );
        }
    }

    private static void printList(List<String> list) {
        System.out.println("\nList: ");

        for ( String item : list ) {
            System.out.printf("%s ", item);
        }

        System.out.println();
    }
}
