package com.selimssevgi.dietel8th.chapter17;

import java.io.File;

/**
 * Created by ssselim on 8/5/16.
 */
public class ReadSequentialFileTest {

    public static void main(String[] args) {
        ReadSequentialFile application = new ReadSequentialFile();

        File f = new File("clients.ser");
        System.out.printf(" exits ? %b", f.exists());
        application.openFile();
        application.readRecords();
        application.closeFile();
    }


}
