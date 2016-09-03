package chapter8;

// class declaration with overloaded constructors
public class Time2 {
    private int hour;   // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    // initialize each variable with zero, object starts in a consistent state
    public Time2()
    {
        this(0, 0, 0);
    }

    public Time2( int h )
    {
       this( h, 0, 0);
    }

    public Time2( int h, int m )
    {
        this( h, m, 0 );
    }

    public Time2(int h, int m, int s) {
        setTime( h, m, s );
    }

    public Time2(Time2 time2) {
        this(time2.getHour(), time2.getMinute(), time2.getSecond());
    }

    private void setTime(int h, int m, int s) {
        setHour(h);
        setMinute(m);
        setSecond(s);
    }

    // convert in universal time ( HH:MM:SS)
    public String toUniversalString()
    {
        return String.format( "%02d:%02d:%02d", getHour(), getMinute(), getSecond() );
    }

    // convert in standart time ( H:MM:SS AM or PM)
    public String toString()
    {
        return String.format( "%d:%02d:%02d %s",
                (getHour() == 0 || getHour() == 12 ? 12 : (getHour() % 12)),
                getMinute(), getSecond(),
                (getHour() < 12 ? "AM" : "PM") );
    }
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int s) {
        second = (s < 0 || s > 59) ? 0 : s;
    }

    public void setMinute(int m) {
        minute = (m < 0 || m > 59) ? 0 : m;
    }

    public void setHour(int h) {
        hour = (h < 0 || h > 23) ? 0 : h;
    }
}
