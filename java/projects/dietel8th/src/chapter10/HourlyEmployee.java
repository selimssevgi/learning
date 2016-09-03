package chapter10;

/**
 * Created by ssselim on 8/4/16.
 */
public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String fname, String lname, String ssn, double wage, double hours) {
        super(fname, lname, ssn);
        setWage( wage );
        setHours( hours );
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = ( wage < 0 ) ? 0.0 : wage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = ( hours > 0 && hours < 168 ) ? hours : 0.0;
    }

    @Override
    public String toString() {
        return String.format( "hourly employee : %s \n %s : %,.2f \n %s : %,.2f",
                super.toString(), "hourly wage", getWage(), "workedHours", getHours());
    }

    @Override
    public double earnings() {
        if ( hours <= 40 ) { // no overtime, 40 hours of work in a week
            return getWage() * getHours();
        } else {
            return 40 * getWage() +
                    ( getHours() - 40 ) * getWage() * 1.5;
        }
    }
}
