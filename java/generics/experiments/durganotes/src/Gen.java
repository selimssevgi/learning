/**
 * Created by ssselim on 10/4/16.
 */
public class Gen<T> {
  T ob;

  public Gen(T ob) {
    this.ob = ob;
  }

  public T getOb() {
    return ob;
  }

  public void show() {
    System.out.println("The type of ob is: " +
            ob.getClass().getName());
  }
}
