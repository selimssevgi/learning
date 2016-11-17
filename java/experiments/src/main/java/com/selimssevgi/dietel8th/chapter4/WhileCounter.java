package com.selimssevgi.dietel8th.chapter4;

/**
 * Created by ssselim on 7/29/16.
 */

// Counter-controlled repetition with the while repetition statement.
public class WhileCounter
{
   public static void main( String[] args )
   {
      int counter = 1;

      while ( counter <= 10 )
      {
         System.out.printf("%d ", counter);
         counter++;
      }

      System.out.println();

      counter = 0;
      while ( ++counter <= 10 ) // less readable
      {
         System.out.printf("%d ", counter);
      }
   }
}
