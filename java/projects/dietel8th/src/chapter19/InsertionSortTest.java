package chapter19;

/**
 * Created by ssselim on 8/7/16.
 */
public class InsertionSortTest {

    public static void main(String[] args) {
        InsertionSort sortArray = new InsertionSort(10);

        System.out.println("Unsorted Array :");
        System.out.println( sortArray );

        sortArray.sort();

        System.out.println("Sorted Array :");
        System.out.println( sortArray );

    }
}
