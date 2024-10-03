public class WhileLoopChallenge_EvenNumber {

    public static void main(String[] args) {
        int number = 4;
        int finishNumber = 20;
        // record total number of even numbers as well as the odd numbers that are found
        int evenCount = 0;
        int oddCount = 0;


        while (number <= finishNumber){ // runs from numbers 4 to 20
            number++; //auto increment at the start of the loop
             //check if even (restarts loop if odd)
            if (!isEvenNumber(number)){
                oddCount++;
                continue;
            }
            System.out.println("Even number " + number);
            evenCount++;
            if (evenCount >=5){
                break;
            }
        }
        System.out.println("Total odd numbers found: " + oddCount);
        System.out.println("Total even numbers found: " + evenCount);
    }

    public static boolean isEvenNumber(int number){
        if ((number % 2) == 0){
            return true;
        }else{
            return false;
        }
    }
}
