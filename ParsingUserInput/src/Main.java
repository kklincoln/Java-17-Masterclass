import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int currentYear = 2024;
        //establish test cases
        // wrap the statement in a try block, because System.console() creates an error in intelliJ
        try {
            System.out.println(getInputFromConsole(currentYear));
        } catch(NullPointerException e){    // this error catch is dependent upon whatever error occurs in processing
            System.out.println(getInputFromScanner(currentYear));
        }
    }



    // creating code for parsing user input. system.console doesn't work in intellij ide, but can use terminal: java src/Main.java
    public static String getInputFromConsole(int currentYear){
        String name = System.console().readLine("Hi, what's your name? ");
        System.out.println("Hello, " +name + ". Thanks for processing these lines.");

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);
        return "So you are " + age + " years old!";
    }

    // creating code for parsing user input with the scanner class
    public static String getInputFromScanner(int currentYear){
        // Class classlowercamel = new type(from)
        Scanner scannerLocal = new Scanner(System.in);

//        String name = System.console().readLine("Hi, what's your name? ");
        System.out.println("Hi, What is your name? ");
        String name = scannerLocal.nextLine();
        System.out.println("Hello, " +name + ". Thanks for processing these lines.");

//        String dateOfBirth = System.console().readLine("What year were you born? ");
        System.out.print("What year were you born? ");

        //establish an age validation check process
        boolean validDOB = false;
        int age = 0;

        do{
            System.out.println("Enter a year of birth >= " +
                    (currentYear - 125) + " and <= " + (currentYear));
            try {
                age = checkData(currentYear, scannerLocal.nextLine());
                validDOB = age < 0 ? false : true;
            } catch(NumberFormatException badUserData){
                System.out.println("Characters not allowed! Try again.");
            }

        } while(!validDOB); // keeps looping through the age request prompt until validDOB is true
        return "So you are " + age + " years old!";
    }

        public static int checkData(int currentYear, String dateOfBirth){

        // establish variable for the current year as a string
            int dob = Integer.parseInt(dateOfBirth);
            int minimumYear = currentYear - 125; // user is probably not older than 125 years old

            //if the user enters some value that is out of reasonable range:
            if ((dob < minimumYear) || (dob > currentYear)){
                return -1;
            }
            return (currentYear - dob);


        }



}

            // commenting out the example of how these features work
//        String userDateOfBirth = "1999";//
//        //creating a wrapper class for doing the transformation
//        int dateOfBirth = Integer.parseInt(userDateOfBirth);
//        System.out.println("Age = " + (currentYear - dateOfBirth)); // pass in the variable with the wrapper class applied
//
//        //creating a wrapper class for doing the transformation with a partial year, double value
//        String usersAgeWithPartialYear = "22.5";
//        double ageWithPartialYear = Double.parseDouble(usersAgeWithPartialYear);
//        System.out.println("Age = " + ageWithPartialYear);
