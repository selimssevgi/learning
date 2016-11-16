package com.selimssevgi.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ssselim on 11/15/16.
 */
public class TaskSorter {
  public static void main(String[] args) {
    List<Task> tasks = new ArrayList<>();
    tasks.add(new Task(1, "Run away from killer rabbit", 4));
    tasks.add(new Task(2, "Answer the bridgekeeper", 2));
    tasks.add(new Task(3, "defeat the black Knight", 1));
    tasks.add(new Task(4, "give a shrubbery to knights", 4));
    tasks.add(new Task(5, "what kind of todo list is this", 3));

    tasks.forEach(System.out::println);

    Collections.sort(tasks);
    System.out.println("After sorting:");
    tasks.forEach(System.out::println);

    System.out.println(Thread.currentThread().getName());
    Thread.currentThread().setName("name");
    System.out.println(Thread.currentThread().getName());
  }
}
