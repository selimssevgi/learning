import java.util.Random;
import java.util.Arrays;

public class Sorts {

  public static int[] anArray() {
    return anArray(10);
  }
  public static int[] anArray(int size) {
    Random rand = new Random();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = rand.nextInt() % 100 + 100;
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] anArr = anArray();
    System.out.println(Arrays.toString(anArr));
    insertion(anArr);
    System.out.println(Arrays.toString(anArr));

  }

  public static void insertion(int[] arr) {
    int key = 0;
    int j   = 0;
    for (int i = 1; i < arr.length; i++) {
      key = arr[i];
      j   = i - 1;
      while (j > 0 && arr[j] > key) {
        arr[j+1] = arr[j];
        j = j - 1;
      }
      arr[j] = key;
    }
  }
}
