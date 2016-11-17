package com.selimssevgi.dietel8th.chapter8;

/**
 * Created by ssselim on 8/4/16.
 */

// declaring an enum type with constructor and explicit instance fields
// and accessors for these fields
public enum Book {
    // declare the constant of enum type
    JHTP("Java How to Program", "2010"),
    CHTP("C How to Program", "2007");

    // instance fields
    private final String title;
    private final String copyrightYear;

    // enum constructor
    Book( String t, String y)
    {
        title = t;
        copyrightYear = y;
    }

    public String getTitle()
    {
        return title;
    }

    public String getCopyrightYear()
    {
        return copyrightYear;
    }
}
