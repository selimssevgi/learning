package com.selimssevgi.dietel8th.chapter10;

/**
 * Created by ssselim on 8/4/16.
 */
public class CommissionEmployee extends Employee {
    private double commissionRate;
    private double grossSale;

    public CommissionEmployee(String fname, String lname, String ssn, double commissionRate, double grossSale) {
        super(fname, lname, ssn);
        setCommissionRate( commissionRate );
        setGrossSale( grossSale );
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double cr) {
        this.commissionRate = ( cr > 0.0 && cr < 1.0 ) ? cr : 0.0;
    }

    public double getGrossSale() {
        return grossSale;
    }

    public void setGrossSale(double gs) {
        this.grossSale = ( gs < 0 ) ? 0 : gs;
    }

    @Override
    public String toString() {
        return String.format("commission employee : %s\n %s : %,.2f \n %s : %,.2f",
                super.toString(), "commissionRate", getCommissionRate(), "grosssale", getGrossSale());
    }

    @Override
    public double earnings() {
        return getCommissionRate() * getGrossSale();
    }
}
