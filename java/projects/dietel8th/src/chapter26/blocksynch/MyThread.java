package chapter26.blocksynch;

/**
 * Created by ssselim on 9/28/16.
 */
public class MyThread extends Thread{
  Display d;
  String name;

  MyThread(Display d, String name) {
    this.d = d;
    this.name = name;
  }

  @Override
  public void run() {
    d.wish(name);
  }
}
