//First And Last Digit Sum
//Write a method named sumFirstAndLastDigit with one parameter of type int called number.
//The method needs to find the first and the last digit of the parameter number passed to the method, using a loop and return the sum of the first and the last digit of that number.
//If the number is negative then the method needs to return -1 to indicate an invalid value.
public class Challenge_FirstLastDigitSum {
    public class FirstLastDigitSum {
        // write code here
        //The method needs to find the first and the last digit of the parameter number passed to the method
        //, using a loop and return the sum of the first and the last digit of that number.

        public static int sumFirstAndLastDigit(int number){
            //If the number is negative then the method needs to return -1 to indicate an invalid value.
            if (number < 0){
                return -1; //returns invalid value
            }
            // handle zero case specifically
            if (number == 0){
                return 0;
            }
            //get the value for the last digit
            int lastDigit = number % 10; //

            //get the value for the first digit
            while (number >=10){
                number /= 10;
            }
            // the number now only has the digit we want
            int firstDigit = number;
            return firstDigit + lastDigit;

        }

    }
}
