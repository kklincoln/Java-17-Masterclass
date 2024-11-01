package dev.lpa;

import java.util.function.UnaryOperator;

public class Challenge2 {
        public static void main(String[] args) {



        }
    //WRITE THE FOLLOWING METHOD AS A LAMBDA EXPRESSION
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++){
            if (i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }
    //lambda expression should take string and return string.
    UnaryOperator<String> everySecondChar = source -> {
//        variable of Function type assigned to a lambda expression with code block
//            copy and paste the codeblock from the previous method
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++){
            if (i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    };



}

