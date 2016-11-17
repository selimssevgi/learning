package com.selimssevgi.dietel8th.chapter9;

/**
 * Created by ssselim on 8/4/16.
 */
public class BasePlusCommissionEmployee2 extends ComissionEmployee
{
    private double baseSalary;

    public BasePlusCommissionEmployee2(String fn, String ln, String ssn, double gs, double cr, double baseSalary) {
        super(fn, ln, ssn, gs, cr);
        setBaseSalary( baseSalary );
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = ( baseSalary < 0 ) ? 0.0 : baseSalary;
    }

    @Override
    public String toString() {
        return super.toString() + "baseSalary='" + getBaseSalary() + "'\n";
    }

    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }
}
