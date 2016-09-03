package chapter10;

/**
 * Created by ssselim on 8/4/16.
 */
public abstract class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    // three argument constructor
    public Employee( String fname, String lname, String ssn )
    {
        firstName = fname;
        lastName = lname;
        socialSecurityNumber = ssn;
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

    @Override
    public String toString()
    {
       return String.format("%s %s\n ssn : %s",
               getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    public abstract double earnings();
}
