package chapter20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ssselim on 8/9/16.
 */
// collection interface demonstrated via ArrayList
public class CollectionTest {

    public static void main(String[] args) {
        String[] colors = { "MAGENTA", "RED", "WHITE", "BLUE", "CYAN" };
        List<String> list = new ArrayList<>();

        for (String color : colors ) {
            list.add( color );
        }

        String[] removeColors = { "RED", "WHITE", "BLUE" };
        List<String> removeList = new ArrayList<>();

        for (String color : removeColors ) {
           removeList.add( color );
        }

        System.out.println(" ArrayList : ");
        // output list contents
        for (int count = 0; count < list.size(); count++) {
            System.out.printf("%s ", list.get( count ));
        }

        removeColors( list, removeList );

        System.out.println(" \n\n ArrayList after calling removeColors : ");

        for ( String color : list )
            System.out.printf("%s ", color );

    }

    private static void removeColors(Collection<String> c1, Collection<String> c2) {
        // get iterator
        Iterator<String> iterator = c1.iterator();

        // loop while collection has items
        while ( iterator.hasNext() ) {
            if ( c2.contains( iterator.next() ) )
                iterator.remove();
        }
    }
}
