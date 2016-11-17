package com.selimssevgi.dietel8th.chapter10;

/**
 * Created by ssselim on 8/4/16.
 */
public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String fname, String lname, String ssn, double weeklySalary) {
        super(fname, lname, ssn);
        setWeeklySalary( weeklySalary );
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = ( weeklySalary < 0 ) ? 0 : weeklySalary;
    }

    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    @Override
    public String toString() {
        return String.format( " salaried employee : %s \n %s : $%,.2f",
                super.toString(), "weekly salary", getWeeklySalary());
    }
}
