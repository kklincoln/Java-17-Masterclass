package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Challenge_MinimumElement {
    public static void main(String[] args) {
// in the main method:  call the method readIntegers to get the array of integers from the user, and print these out
// using a method found in java.util.Arrays.
    int[] userArray = readIntegers();
//next: call the findMin method passing the array, returned from the call to readIntegers method
    int returnedMin = findMin(userArray);
//print the minimum element in the array, returned from the findMin method; omit validation, assume user enters only numbers
    System.out.println("The user array provided: " + Arrays.toString(userArray) + " has a minimum value: " + returnedMin);
    }

//write a method called readIntegers that reads a comma delimited list of numbers entered by the user from console,
//then returns an array containing the numbers that were entered.
    public static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in); //create a new scanner to allow for user input
        System.out.println("Enter a comma-delimited list of integers: "); // prompt user for integers

        //read the entire line of input
        String userInput = scanner.nextLine();
        //split the input by commas and trim whitespace, stored in a new array of strings
        String[] stringNumbers = userInput.split(",");

        //create an array to hold the numbers of length that is the same as the String array
        int[] numbers = new int[stringNumbers.length];

        // convert string to int
        for (int i = 0; i < stringNumbers.length; i ++){
            numbers[i] = Integer.parseInt(stringNumbers[i].trim()); // parse string at each index, trim & convert
        }
    return numbers;
    }


// next, write a method: findMin that takes the array as an argument and returns the minimum value found in that array.
    public static int findMin(int[] numArray){
        int min = numArray[0];
        for (int i = 0; i < numArray.length; i++){
            if(numArray[i] < min){
                min = numArray[i];
            }
        }
        return min;
    }

}
