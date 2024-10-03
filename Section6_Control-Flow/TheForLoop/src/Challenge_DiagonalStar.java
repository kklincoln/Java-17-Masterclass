//Diagonal Star
//Write a method named printSquareStar with one parameter of type int named number.
////If number is < 5, the method should print "Invalid Value".
//The method should print diagonals to generate a rectangular pattern composed of stars (*). This should be accomplished by using loops (see examples below).
public class Challenge_DiagonalStar {


    public static void printSquareStar(int number) {
        // Check for invalid values
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }

        // Loop through each row
        for (int row = 0; row < number; row++) {
            // Loop through each column
            for (int col = 0; col < number; col++) {
                // Check the conditions for printing stars
                if (row == 0 || row == number - 1 ||
                        col == 0 || col == number - 1 ||
                        row == col ||
                        col == number - row - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            // Move to the next line after finishing the current row
            System.out.println();
        }
    }

}