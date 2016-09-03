/**
 * Created by ssselim on 7/23/16.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = getRandomArr(10);
        printArr(arr);
        insertionSort(arr);
        printArr(arr);
    }

    private static void insertionSort(int[] arr) {
       // get first not sorted element
       // compare this element with sorted elements in backwards
       // if less than sorted element, exchange them

        for (int i=1; i<arr.length; i++) { // first element is sorted
            // arr[i] has to be compared with the sorted part.
            // dont use for loop!!
            // for (int j=i; j>0; j--) {
            int selectedElement = arr[i];
            int tempIndex = i;
            while (tempIndex>0 && arr[tempIndex-1] > selectedElement) {
                arr[tempIndex] = arr[tempIndex-1];
                tempIndex--;
           }
            arr[tempIndex] = selectedElement;
        }
    }

    private static void printArr(int[] arr) {
        for (int x : arr){
           System.out.print(x + " ");
        }
        System.out.println();
    }

    private static int[] getRandomArr(int i) {
        int[] tempArr = new int[i];

        for (int j=0; j<i; j++) {
            tempArr[j] = (int) (Math.random() * 100);
        }

        return tempArr;
    }
}
