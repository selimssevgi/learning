package com.selimssevgi.effectivejava2nd.methods.item42;

public class VarArgs {
  /**
   * The WRONG way to require one or more arguments
   * explicit check for at least one element
   * ugly for loop
   * runtime error
   * explicit check for at least one element
   */
  static int min(int... args) {
    if (args.length == 0)
      throw new IllegalArgumentException("Too few arguments");

    int min = args[0];
    for (int i = 0; i < args.length; i++) {
      if (args[i] < min) {
        min = args[i];
      }
    }

    return min;
  }

  int minBetter(int firstArg, int... remainingArgs) {
    int min = firstArg;
    for (int arg : remainingArgs) {
      if (arg < min) {
        min = arg;
      }
    }

    return min;
  }

  static int sum(int... args) {
    int sum = 0;
    for (int arg : args) {
      sum += arg;
    }
    return sum;
  }
}
