import java.util.Scanner;

public class Challenge_ReadingUserInput {
    //read 5 valid numbers from the console entered by the user and print the sum of those 5 numbers.
    // check that the entries are valid integers
    public static void main(String[] args) {
        // Use the Scanner class to read input from the console.
        Scanner scannerLocal = new Scanner(System.in);
        double sum = 0;
        int count= 0;

        while(count <5){
            System.out.print("Enter number #" + (count + 1) + " ");
            // check if the user input is an integer with hasNextInt
            if (scannerLocal.hasNextDouble()){
                // set the number = to that int in the entry
                double number = scannerLocal.nextDouble();
                sum += number; // add number ot the sum
                count++; // increment one to the count
            } else{
                System.out.println("Invalid Number");
                scannerLocal.next(); //clear invalid input
            }
        }
        System.out.println("The sum of the numbers: " + sum);
        scannerLocal.close();
    }
}
