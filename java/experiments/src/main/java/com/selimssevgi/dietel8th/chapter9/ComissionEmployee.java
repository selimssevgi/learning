package com.selimssevgi.dietel8th.chapter9;

/**
 * Created by ssselim on 8/4/16.
 */

// represent an employee paid a percentage of gross sale
public class ComissionEmployee extends Object{
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSale; // gross weekly sale
    private double commissionRate;

    public ComissionEmployee
            (String fn, String ln, String ssn, double gs, double cr) {
        firstName = fn;
        lastName = ln;
        socialSecurityNumber = ssn;
        setGrossSale(gs);
        setCommissionRate(cr);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", socialSecurityNumber='" + getSocialSecurityNumber() + '\'' +
                ", grossSale=" + getGrossSale() +
                ", commissionRate=" + getCommissionRate() +
                '}';
    }

    public double earnings()
    {
        return getCommissionRate() * getGrossSale();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public double getGrossSale() {
        return grossSale;
    }

    public void setGrossSale(double gs) {
        grossSale = ( gs < 0.0 ) ? 0.0 : gs;
    }

    public void setCommissionRate(double cr) {
        commissionRate = ( cr > 0.0 && cr < 1.0 ) ? cr : 0.0;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
