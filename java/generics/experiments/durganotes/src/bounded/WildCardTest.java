package bounded;

import java.util.ArrayList;

/**
 * Created by ssselim on 10/4/16.
 */
public class WildCardTest {
  public static void main(String[] args) {
    ArrayList<String> l = new ArrayList<>();
    ArrayList<?> l2 = new ArrayList<String>();
    ArrayList<?> l3 = new ArrayList<Integer>();
    ArrayList<? extends Number> l4 = new ArrayList<Integer>();
//    ArrayList<? extends Number> l5 = new ArrayList<String>();
    ArrayList<? super String> l6 = new ArrayList<Object>();
//    ArrayList<?> l7 = new ArrayList<?>();
//    ArrayList<?> l8 = new ArrayList<? extends Number>();
  }
}
