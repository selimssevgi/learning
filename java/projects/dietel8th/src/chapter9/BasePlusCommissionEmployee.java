package chapter9;

/**
 * Created by ssselim on 8/4/16.
 */
public class BasePlusCommissionEmployee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSale; // gross weekly sale
    private double commissionRate;
    private double baseSalary; // base salary per week

    public BasePlusCommissionEmployee
            (String firstName, String socialSecurityNumber, String lastName,
             double grossSale, double commissionRate, double baseSalary)
    {
        this.firstName = firstName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.lastName = lastName;
        setGrossSale( grossSale );
        setCommissionRate( commissionRate );
        setBaseSalary( baseSalary );
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double getGrossSale() {
        return grossSale;
    }

    public void setGrossSale(double grossSale) {
        this.grossSale = ( grossSale < 0 ) ? 0 : grossSale;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate =
                ( commissionRate > 0.0 && commissionRate < 1.0 ) ? commissionRate : 0.0;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = ( baseSalary < 0 ) ? 0 : baseSalary;
    }

    public double earnings()
    {
        return baseSalary + ( commissionRate * grossSale );
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", grossSale=" + grossSale +
                ", commissionRate=" + commissionRate +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
