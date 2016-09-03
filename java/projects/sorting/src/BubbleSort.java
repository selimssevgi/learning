/**
 * Created by ssselim on 7/23/16.
 */

/**
 * Also known as Exchange Sort
 *
 * Compare each element with the next one
 * until there is no exchanging
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 20, 35, 60, 8, 15, 3, 42, 29 };
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    private static void bubbleSort(int[] arr) {
        // compare each element with the next one
        // if selected one is greater than the next one, exchange them
        // the greatest element will be moved to the end of the array
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
