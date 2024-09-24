public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Kiernan 3!");

        boolean isAlien = false;
        if (isAlien == true){
    // code block to establish a group of statements, otherwise the if statement only considers the immediate code line following
            System.out.println("It's an alien!");
            System.out.println("And I am scared of aliens!");
        }
        int topScore = 81;
        if (topScore < 100 ) {
            System.out.println("You got the high score!");
        }
        int secondTopScore = 81;
        if ((topScore > secondTopScore) && (topScore < 100)){
            System.out.print("Greater than the second top score and less than 100.");
        }

        if ((topScore > 90) || (secondTopScore <=90)){
            System.out.println("Either or both of the conditions are true");
        }

        int newValue = 50;
        if (newValue == 50){ // when you use the one = sign, then it's an assignemnt, you must use two if you want to compare
            System.out.println("this corrected an error.");
        }

        boolean isCar = false;
        if (!isCar){
            System.out.println("This is not supposed to happen. Assignment operator instead of == operator");
        }

        // ternary operator: Tests if operand1 is true, if so then returns operand2, otherwise returns operand3
        String makeOfCar = "Volkswagen";
        // test? if true: if false
        // isDomestic = (makeOfCar == "Volkswagen")? true : false
        boolean isDomestic = makeOfCar == "Volkswagen" ? true : false;

        if (isDomestic){
            System.out.println("The test passed, return the second operand");
        }



        }
    }

