public class For_PrimeNumber {
    public static void main(String[] args) {
        int primeCount = 0;
        for (int i = 0; i <= 1000; i++){
            if (isPrime(i)){
                // ternary operator
                System.out.println(i + " is" +(isPrime(i)?"": " NOT") + " a prime number.");
                primeCount++;
                if(primeCount == 3){
                    System.out.println("The first "+ primeCount + " prime numbers between 0 and 1000 were found; exiting for loop.");
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int wholeNumber){
        int primeCounter =0;
        //if statement
        if (wholeNumber <=2 ){
            return (wholeNumber == 2); //returns false, items less than 2 are not equal to 2
        }
        //for loop
        //we do the wholeNumber/2 because if it's divisible by 2 it was already considered
        for(int divisor = 2; divisor < wholeNumber/2; divisor++){
            if(wholeNumber % divisor ==0){
                //boolean return
                return false; //if wholeNumber can be evenly divisible by any number other than itself (above 2), it's not prime
            }
        }
        return true;
    }
}
