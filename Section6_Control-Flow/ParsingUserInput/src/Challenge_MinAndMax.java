import java.util.Scanner;

public class Challenge_MinAndMax {

    public static void main(String[] args) {
        // establish a new scanner to track user input
        Scanner scannerLocal = new Scanner(System.in);
        //initialize minimum to the maximum possible
        double min = Double.MAX_VALUE;
        //initialize max to the minimum possible
        double max = Double.MIN_VALUE;
        // To track if any valid numbers were entered
        boolean hasNumbers = false;


        while (true){
            // prompts user to enter a number or any character to quit
            System.out.println("Enter a number; alternatively, enter a character to quit");
            String input = scannerLocal.nextLine();
            // validates if user entered data is really a number; int or double allowed
            try{
                double number = Double.parseDouble(input);
                //update min and max
                if (number < min){
                    min = number;
                }
                if (number > max){
                    max = number;
                }
                // update hasNumbers to reflect valid numbers entered
                hasNumbers = true;
            }catch (NumberFormatException nfe){
                // if not a number, quit the loop
                System.out.println("Exiting the program");
                break;
            }
        }

        if (hasNumbers){
            //display the min and max number that has been entered
            System.out.println("The minimum number entered was: " + min);
            System.out.println("The maximum number entered was: " + max);
        }else{
            System.out.println("No valid numbers were entered.");
        }
    }

}
