// an hourly emp is paid by the hours worked and the hourly rate they agreed to work for
// an hourly employee may also get double pay if they work over a certain number of hours

public class HourlyEmployee extends Employee{
    //create fields associated with diagram
    private double hourlyPayRate;

    // create constructor
    public HourlyEmployee(String name, String birthDate, String hireDate,
                          double hourlyPayRate) {
        super(name, birthDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public double collectPay(){
        return 40 * hourlyPayRate; // assumed working 40hr weeks, override the collectPay method in Worker.
    }

    //create methods associated with diagram
    public double getDoublePay(){
        return 2 * collectPay();
    }

}
