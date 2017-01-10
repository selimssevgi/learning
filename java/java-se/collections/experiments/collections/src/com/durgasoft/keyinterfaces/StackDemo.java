package com.durgasoft.keyinterfaces;

import java.util.Stack;

/**
 * Created by ssselim on 10/1/16.
 */
public class StackDemo {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    stack.push("Selim");
    stack.push("java");
    stack.push("awesome");
    System.out.println(stack);  // [Selim, java, awesome]
    System.out.println("Offset of 'Selim':" + stack.search("Selim")); // 3
    System.out.println("Offset of 'abc':" + stack.search("abc")); // -1
  }

}
