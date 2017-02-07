import java.util.Iterator;
import java.util.Enumeration;

public class IteratorEnumeration<E> implements Enumeration<E> {
  Iterator<E> it;

  public IteratorEnumeration(Iterator<E> iterator) {
    it = iterator;
  }

  public E nextElement() { return it.next(); }

  public boolean hasMoreElements() { return it.hasNext(); }

}
