package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Challenge_ReverseSortArray {
    public static void main(String[] args) {
        int[] unsortedArray = getRandomArray(10);
        int[] sortedArray = sortArray(unsortedArray);
//        int[] reversedArray = reverseArray(sortedArray);

        System.out.println(Arrays.toString(unsortedArray) + ": Unsorted array"); // print random int array
        System.out.println(Arrays.toString(sortedArray) + ": Array sorted descending"); // print array that was sorted

    }

    public static int[] getRandomArray(int len){ //only argument is the length of the array
        //create an array of randomly generated integers
        //need random import
        Random random = new Random();
        int[] randInt = new int[len]; // create the new integer array of the length provided
        int[] reverseRandInt = new int[len];

        for (int i = 0; i < len; i++){
            randInt[i] = random.nextInt(1000); // random number up to 100 non inclusive
        }
       return randInt;
    }

    public static int[] sortArray(int[] arr) {
        int[] sortedArray = Arrays.copyOf(arr, arr.length);

        boolean flag = true;
        int temp;
        while (flag) {
            flag = false; // while the flag is false so the loop exits
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {  // if first element is less than the second, swap the elements
                    temp = sortedArray[i];  // placeholder to store the lesser value
                    sortedArray[i] = sortedArray[i + 1]; // replace the previous slot with the greater value
                    sortedArray[i + 1] = temp; // set the previous i+1 slot = the placeholder
                    flag = true;
                    System.out.println("------>" + Arrays.toString(sortedArray));
                }
            }
            System.out.println("-->" + Arrays.toString(sortedArray));
        }
        return sortedArray;
    }

}