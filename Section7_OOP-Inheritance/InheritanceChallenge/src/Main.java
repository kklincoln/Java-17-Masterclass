public class Main {
    public static void main(String[] args) {
        //create testcase outputs

        Employee tim = new Employee("Tim", "11/11/1992",
                 "01/01/2020");
        System.out.println(tim);
        // the getAge and collectPAy are inherited functions from parent class: Worker
        System.out.println("Age= " + tim.getAge());
        System.out.println("Pay= " + tim.collectPay());
        System.out.println("_ _ _ _");

        SalariedEmployee steven = new SalariedEmployee("Steven", "08/30/1992", "01/01/2021"
        , 150000);
        System.out.println(steven);
        System.out.println("Steven's paycheck = $" + steven.collectPay());
        steven.retire();
        System.out.println("Steven's pension check = $" + steven.collectPay());
        System.out.println("_ _ _ _");

        HourlyEmployee mary = new HourlyEmployee("Mary", "12/04/1985","12/23/2005", 54);
        System.out.println(mary);
        System.out.println("Mary's weekly paycheck = $" + mary.collectPay());
        System.out.println("Mary's Holiday pay = $" + mary.getDoublePay());
    }
}
