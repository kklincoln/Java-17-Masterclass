public class MethodOverloading { //This line would normally be public class main{}
    public static void main(String[] args){
        System.out.println("New score is: " + calculateScore("Tim", 400));
        System.out.println("New score is: " + calculateScore(10));
        }

    public static int calculateScore(String playerName, int score){
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

// overloading the method by establishing different parameters
    public static int calculateScore(int score){
        return calculateScore("Anonymous", score);
    }
    // overloading the method by establishing no parameters
    public static int calculateScore(){
        System.out.println("No player name, no player score.");
        return 0;
    }

}
