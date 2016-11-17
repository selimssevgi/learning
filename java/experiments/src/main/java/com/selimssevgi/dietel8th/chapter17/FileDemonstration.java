package com.selimssevgi.dietel8th.chapter17;

import java.io.File;
import java.util.Scanner;

/**
 * Created by ssselim on 8/5/16.
 */
public class FileDemonstration {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print(" Enter file or directory name : ");
        analyzePath( input.nextLine() );
    }

    private static void analyzePath(String path) {

        File name = new File(path);

        if ( name.exists() ) {

            System.out.printf("\n%s exits. \n", name.getName() );
            System.out.printf("\nis a file : %b", name.isFile() );
            System.out.printf("\nis a directory : %b", name.isDirectory() );
            System.out.printf("\nis absolute : %b", name.isAbsolute() );
            System.out.printf("\nlastModified : %s", name.lastModified() );
            System.out.printf("\nlength : %s", name.length() );
            System.out.printf("\npath : %s", name.getPath() );
            System.out.printf("\nabsolute path : %s", name.getAbsolutePath() );
            System.out.printf("\nparent : %s", name.getParent() );

            if ( name.isDirectory() ) {
                String[] directories = name.list();

                System.out.printf("\nDirectory content : \n");

                for (String currentDirectory : directories ) {
                    System.out.println( currentDirectory );
                }
            }
        } else {
            System.err.println(path + " doesnt exist.");
        }
    }
}
