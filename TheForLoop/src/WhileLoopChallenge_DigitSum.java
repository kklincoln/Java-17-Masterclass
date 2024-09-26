public class WhileLoopChallenge_DigitSum {

    //test cases
    public static void main(String[] args) {
        System.out.print("Testing the value for 1234 is " + sumDigits(1234));
        System.out.print("Testing the value for -125 is " + sumDigits(-125));
        System.out.print("Testing the value for 4 is " + sumDigits(4));
        System.out.print("Testing the value for 32123 is " + sumDigits(32123));
    }


    public static int sumDigits(int number) {
        if (number < 0){
            return -1;
        }
        // establish a sum
        int sum = 0;
        // n % 10 to extract the last digit        // n/10 to drop the last digit
        int digit = number % 10;
        while (number > 9) {
            sum += (number %10); //add the last digit of the number to the running total
            number = number /10;  // drop the last digit of the number from the number
            }
        sum += number;
        return sum;
        }
    }

