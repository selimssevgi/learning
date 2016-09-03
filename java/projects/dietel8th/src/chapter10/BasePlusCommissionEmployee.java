package chapter10;

/**
 * Created by ssselim on 8/4/16.
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee
            (String fn, String ln, String ssn, double gs, double cr, double baseSalary)
    {
        super(fn, ln, ssn, gs, cr);
        setBaseSalary( baseSalary );
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = ( baseSalary < 0 ) ? 0 : baseSalary;
    }

    @Override
    public String toString() {
        return String.format("basepluscommission employee : %s\n %s : %,.2f",
                super.toString(), "baseSalary", getBaseSalary());
    }

    @Override
    public double earnings() {
        return super.earnings() + getBaseSalary();
    }
}
