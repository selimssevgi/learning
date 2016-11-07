package com.selimssevgi.effectivejava.randomItems.THC;

/**
 * Created by ssselim on 9/22/16.
 */
public class FavoriteTester {
  public static void main(String[] args) {
    Favorites f = new Favorites();
    f.putFavorite(String.class, "java");
    f.putFavorite(Integer.class, 20);
    f.putFavorite(Class.class, ThreadLocal.class);

    String s = f.getFavorite(String.class);
    int i = f.getFavorite(Integer.class);

    System.out.println(s + ":"  + i);
  }
}
