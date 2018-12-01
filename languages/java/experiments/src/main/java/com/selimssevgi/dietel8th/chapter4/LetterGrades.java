package com.selimssevgi.dietel8th.chapter4;

import java.util.Scanner;

/**
 * Created by ssselim on 7/29/16.
 */
// switch statement to count letter grades
public class LetterGrades
{
    public static void main( String[] args )
    {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;
        int total = 0; // sum of the grade
        int gradeCounter = 0;
        int grade = 0;

        Scanner scan = new Scanner( System.in );

        System.out.printf("%s\n%s\n     %s\n    %s\n",
                "Enter the integer grades in range 0-100.",
                "Type the end-of-file indicator to terminate input.",
                "On UNIX/Linux/Mac type CTRL - d then press enter,",
                "On windows type <ctrl> z then press enter.");

        while( scan.hasNext() )
        {
            grade = scan.nextInt();
            total += grade;
            gradeCounter++;

            switch ( grade / 10 )
            {
                case 1-9:
                    System.out.println("in range of 1-9");
                case 9:
                case 10:
                    aCount++;
                    break;
                case 8:
                    bCount++;
                    break;
                case 7:
                    cCount++;
                    break;
                case 6:
                    dCount++;
                    break;
                default:
                    fCount++;
                    break;
            }

        }

        System.out.println("Grade Report:");

        if ( gradeCounter != 0 )
        {
            double average = (double) total / gradeCounter;

            System.out.printf("Total of %d grades entered is %d.\n", gradeCounter, total);

            System.out.printf("Class average is %.2f\n", average);

            System.out.printf( "%s\n%s%d\n%s%d\n%s%d\n%s%d\n%s%d\n",
                    "Number of students who received each grade:",
                    "A: ", aCount, // display number of A grades
                    "B: ", bCount, // display number of B grades
                    "C: ", cCount, // display number of C grades
                    "D: ", dCount, // display number of D grades
                    "F: ", fCount ); // display number of F grades

        }
    }
}
