public class For_Sum3and5Challenge {

    public static void main(String[] args) {
        int countOfMatches = 0;
        int totalOfMatches = 0;

        for (int i = 1; i <= 1000; i++){
            String numbers = "";
            if ((i % 3 == 0) && (i % 5 == 0)){
                countOfMatches++;
                totalOfMatches += i;
                System.out.println("Found a match: " + i);
            }
            if (countOfMatches == 5){
                break;
            }
        }
        System.out.println("Sum of numbers = " + totalOfMatches);
    }
}
