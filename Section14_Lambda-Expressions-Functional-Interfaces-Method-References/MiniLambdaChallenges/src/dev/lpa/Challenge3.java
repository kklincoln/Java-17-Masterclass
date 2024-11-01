package dev.lpa;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Challenge3 {
    //write the code to execute this lambda expression's functional method, using 1234567890 as the arg to the method and print result
    public static void main(String[] args) {
        UnaryOperator<String> everySecondChar = source ->{
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++){
                if (i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        //ADDED THIS LINE:
        System.out.println(everySecondChar.apply("1234567890"));



//    CHALLENGE 5:
//    Call the method you created from challenge 4 passing the lambda variable we created earlier and the string 1234567890, then print result
        String result = everySecondCharacter(everySecondChar , "1234567890");
        System.out.println(result);

//        CHALLENGE 6:
//        write a lambda expression that is declared with the Supplier interface. This lambda should return the String, "I Love Java"
//        and assign it to a variable called iLoveJava
        Supplier<String> iLoveJava = () -> "I Love Java!";
        Supplier<String> iLoveJava2 = () -> {return "I Love Java!";};

//        CHALLENGE 7:
//        As with the Function example, the Supplier lambda won't do anything until we use it.
//        remember, lambas represent deferred execution of snippets of code. Use this Supplier to assign a String, "I Love Java"
//        to a variable supplierResult. print that variable to console
        String supplierResult  = iLoveJava.get();
        System.out.println(supplierResult);


    }

    //CHALLENGE 4:
    //write another method on your class called everySecondCharacter. It should accept a Function, or UnaryOperator, as a parameter, as well as a second parameter
    //that lets us pass "1234567890". in other words, don't hard code that String in your method code.
    // the method code should execute the functional method on the first argument, passing it the value of the String passed from the enclosing method
    // it should return the result of the call to the functional method
    public static String everySecondCharacter(Function<String, String> func, String source){
        return func.apply(source);
    }


    //CHALLENGE 6:

}
