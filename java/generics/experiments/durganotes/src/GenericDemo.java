/**
 * Created by ssselim on 10/4/16.
 */

public class GenericDemo {
  public static void main(String[] args) {
    Gen<String> g1 = new Gen<>("Durga");
    g1.show();
    System.out.println(g1.getOb());

    Gen<Integer> g2 = new Gen<>(new Integer(10));
    g2.show();
    System.out.println(g2.getOb());

    Gen<Double> g3 = new Gen<>(new Double(10.0));
    g3.show();
    System.out.println(g3.getOb());
  }
}

