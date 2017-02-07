import java.util.*;

public class TestIteratorAdapter {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("Selim");
    list.add("Testing");

    Enumeration<String> enumerator = new IteratorEnumeration<>(list.iterator());

    while (enumerator.hasMoreElements()) {
      System.out.println(enumerator.nextElement());
    }
  }
}
