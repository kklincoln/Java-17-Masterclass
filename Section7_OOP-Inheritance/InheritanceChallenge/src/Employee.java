public class Employee extends Worker {
    //create fields associated with diagram
    private long employeeId;
    private String hireDate;
    private static int employeeNumber = 1;

    // create constructor
    public Employee(String name, String birthDate, String hireDate) {
        //generate the fields from the inheritance
        super(name, birthDate);
        //generate the fields from this class
        this.employeeId = Employee.employeeNumber++;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "hireDate='" + hireDate + '\'' +
                ", employeeId=" + employeeId +
                "} " + super.toString();
    }

    //create methods associated with diagram
    //N/A

}
