package dev.lpa;

public class VarArgs {
    public static void main(String... args) {
        System.out.println("Hello World");
        String[] splitStrings = "Hello World Again".split(" "); // takes a string, splits string on " "
        printText(splitStrings); //prints one line for each word in splitStrings

        System.out.println("_".repeat(20));
        printText("Hello"); //demonstrating that the String... can accept a simple string

        System.out.println("_".repeat(20));
        printText("Hello","World","Again"); //String... can accept multiple arguments to the method

        System.out.println("_".repeat(20));
        printText(); //demonstrating that the String... can accept a no argument


        String[] sArray = {"first","second","third","fourth", "fifth"};
        System.out.println(String.join(",", sArray)); // joining the elements of the array, using ',' as the joiner

    }

    private static void printText(String... textList){
        for (String t : textList){//for every string element in textList array,
            System.out.println(t); // print out the element
        }
    }
}
