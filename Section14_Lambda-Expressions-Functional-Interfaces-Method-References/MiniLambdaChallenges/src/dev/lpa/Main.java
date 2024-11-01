package dev.lpa;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
        public static void main(String[] args) {
// write the following anon class that you can see as a lambda expression.
             Consumer<String> printWords = new Consumer<String>(){
                 @Override
                 public void accept(String sentence){
                     String[] parts = sentence.split(" ");
                     for (String part : parts){
                         System.out.println(part);
                     }    }
             };
        // LAMBDA EXPRESSION
            Consumer<String> printWordsLambda = sentence -> {
                String[] parts = sentence.split(" ");
                for (String part : parts){
                    System.out.println(part);
                }
            };
            //EXECUTE BOTH METHODS
            printWords.accept("Let's split this up into an array");
            printWordsLambda.accept("Let's split this up into an array");

            //make the Lambda a bit more concise
            Consumer<String> printWordsForEach = sentence -> {
                String[] parts = sentence.split(" ");
                Arrays.asList(parts).forEach(s -> System.out.println(s)); // this is a nested lambda expresion, another consumer, passed to the forEach method
            };
            printWordsForEach.accept("Let's split this up into an array");

            // make this very concise to the knowledge we've gathered thus far.
            Consumer<String> printWordsConcise = sentence -> {
                Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
                };
            printWordsConcise.accept("Let's split this up into an array");


///////////////////////////////////////////////////////////////////////




        }

}
