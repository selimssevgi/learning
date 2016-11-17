package com.selimssevgi.dietel8th.chapter8;

/**
 * Created by ssselim on 8/4/16.
 */
public class Time1 {
    private int hour;   // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    // ensure that the data remains consistent by setting invalid value to zero
    public void setTime( int h, int m, int s )
    {
        hour   = ( h < 0 || h > 23 ) ? 0 : h;
        minute = ( m < 0 || m > 59 ) ? 0 : m;
        second = ( s < 0 || s > 59 ) ? 0 : s;
    }

    // convert in universal time ( HH:MM:SS)
    public String toUniversalString()
    {
        return String.format( "%02d:%02d:%02d", hour, minute, second );
    }

    // convert in standart time ( H:MM:SS AM or PM)
    public String toString()
    {
        return String.format( "%d:%02d:%02d %s",
                (hour == 0 || hour == 12 ? 12 : (hour % 12)),
                minute, second,
                (hour < 12 ? "AM" : "PM") );
    }
}
