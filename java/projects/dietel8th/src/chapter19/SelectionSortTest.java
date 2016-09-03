package chapter19;

/**
 * Created by ssselim on 8/7/16.
 */
public class SelectionSortTest {
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort(10);

        System.out.println("Unsorted array :");
        System.out.println( ss );

        ss.sort();

        System.out.println("Sorted array :");
        System.out.println( ss );
    }
}
