package com.selimssevgi.effectivejava.randomItems.THC;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ssselim on 9/22/16.
 */
public class Favorites {
  private Map<Class<?>, Object> favorites =
          new HashMap<Class<?>, Object>();

  public <T> void putFavorite(Class<T> type, T instance) {
    if (type == null) {
      throw new NullPointerException("Type is null");
    } else {
      favorites.put(type, instance);
    }
  }

  public <T> T getFavorite(Class<T> type) {
    return type.cast(favorites.get(type));
  }
}
