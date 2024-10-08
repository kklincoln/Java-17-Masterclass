package dev.lpa;

import java.util.Arrays;

public class Challenge_ReverseArray {
    public static void main(String[] args) {
        // in the main method call, call the reverse method and print the array before and after the method is called
        int[] originalArray = {1, 2, 3, 4, 5}; // Example array
        // Print the original array
        System.out.println("Original Array: " + Arrays.toString(originalArray));

        // Call the reverse method
        int[] reversedArray = reverseArray(originalArray);
        //print the reversed array
        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));

    }

    public static int[] reverseArray(int[] array){
        //write a method that takes an int array as param
        //to reverse the array, you have to swap the elements so that the first element is swapped with the last and so on
        int[] reversedArray = new int[array.length];
        int j = array.length - 1;

        for (int i = 0; i < array.length; i++){
            reversedArray[j] = array[i];
            j--; // subtract one from j so it goes toward the beginning
        }
        return reversedArray;
    }

}
