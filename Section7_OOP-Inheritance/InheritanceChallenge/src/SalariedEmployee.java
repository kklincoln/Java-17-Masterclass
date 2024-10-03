// A salaried employee is paid based on some percentage of his or her annual salar
//if this person is retired, then the salary may be 100% of this amount, but generally reduced
public class SalariedEmployee extends Employee {
    //create fields associated with diagram
    double annualSalary;
    boolean isRetired;  //defaults to false


    // create constructor with code generator
    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }
    // NOTE: We dont override the toString because we dont want the annual salary to be printed, maintain encapsulation
    //override the getpay from employee, need to take the annual salary by 26 weeks
    @Override
    public double collectPay(){
        double paycheck = annualSalary / 26;
        double adjustedPay = (isRetired) ? 0.9 * paycheck : paycheck;
        return (int) adjustedPay;
    }

    //create methods associated with diagram
    public void retire(){
        terminate("12/12/2025");    // established in the worker class
        this.isRetired = true;
    }

    public boolean isRetired() {
        return isRetired;
    }
}
