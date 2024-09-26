public class Challenge_Customer {
    public static void main(String[] args) {
        Customer customer = new Customer("Tim" ,1000, "Tim@Gmail.com");
        System.out.println("Calling the empty constructor, number 1");
        System.out.println(customer.getName());
        System.out.println(customer.getCreditLimit());
        System.out.println(customer.getEmailAddress());

        Customer customer2 = new Customer();
        System.out.println(customer2.getName());
        System.out.println(customer2.getCreditLimit());
        System.out.println(customer2.getEmailAddress());

        Customer customer3 = new Customer("David Jones","DavidJ@gmail.com");
        System.out.println(customer.getName());
        System.out.println(customer.getCreditLimit());
        System.out.println(customer.getEmailAddress());


    }
}
