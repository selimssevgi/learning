package com.selimssevgi.dietel8th.chapter26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Using an ExecutorService to execute Runnables
 * Created by ssselim on 9/24/16.
 */
public class TaskExecutor {
  public static void main(String[] args) {
    PrintTask task1 = new PrintTask("task1");
    PrintTask task2 = new PrintTask("task2");
    PrintTask task3 = new PrintTask("task3");

    System.out.println("Starting Executor");

    // create ExecutorSErvice to manage threads
    ExecutorService threadExecutor = Executors.newCachedThreadPool();

    // start threads and place in runnable state
    // it may execute in one of the threads in the ES' thread pool
    // or creates a new thread to execute it
    // or in thread that called the execute method
    // execute wait returns immediately
    threadExecutor.execute(task1);
    threadExecutor.execute(task2);
    threadExecutor.execute(task3);

    // shut down worker threads when their tasks complete
    // after shutdown ES doesnt accept any task anymore
    threadExecutor.shutdown();

    System.out.println("Tasks started, main ends.");
  }
}
