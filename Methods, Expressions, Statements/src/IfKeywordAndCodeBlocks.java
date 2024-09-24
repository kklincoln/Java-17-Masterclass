public class IfKeywordAndCodeBlocks {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        if (score < 5000 && score > 1000){ // java uses 'else if' not elif
            // this codeblock executes if the statement was true
            System.out.print("This doesn't get evaluated unless the first is false.");
        }
        else if (score < 1000){ // java uses 'else if' not elif
            System.out.print("Your score was less than 1000.");
        }
        else{
            //this codeblock if the statement was false
            System.out.print("Your score was something else.");
        }
    }
}
