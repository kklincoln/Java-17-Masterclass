package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class UsingArrays {
    public static void main(String[] args) {
        //call the method that generates the random array and print it
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray) + " prints the array that called the getRandomArray method");
        Arrays.sort(firstArray); // sort the array, sorts in place
        System.out.println(Arrays.toString(firstArray) + " sorted the array into natural order");

//        Arrays.fill() method demonstration
        int[] secondArray = new int[10]; //generate a new array with 10 elements, defaults to 0 values
        System.out.println(Arrays.toString(secondArray) + " creates a new empty array with default 0");
        Arrays.fill(secondArray,5);//fills the empty arrays with whatever value you pass through
        System.out.println(Arrays.toString(secondArray) + "fills the empty array with whatver value you pass as argument");

//        generate a third array to apply the modifications to, rather than the original array
        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray,thirdArray.length);
        System.out.println(Arrays.toString(fourthArray)+ "4th Array is a copy of 3rd");
        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray) + "3rd array not impacted by sort function");
        System.out.println(Arrays.toString(fourthArray) + "4th array has been sorted");

        //generating a new copy array that only takes a smaller amount e.g. first x of the array
        int [] smallerArray = Arrays.copyOf(thirdArray, 4);
        System.out.println(Arrays.toString(smallerArray) + "using a newLength from the copyOf method takes an array segment");

        int [] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray) + " using a newLength from the copyOf method" +
                ", extra elements filled with default 0");

        //TESTING SEQUENTIAL AND INTERVAL SEARCHING
        //Interval searching: Binary Search (note: array needs to be sorted)
        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if (Arrays.binarySearch(sArray,"Ralph") >=0){
            System.out.println("Found Ralph in the array." );
        };

        // testing if values in array are equal
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5};
        if(Arrays.equals(s1,s2)){
            System.out.println("The Arrays are equal");
        }else{
            System.out.println("The Arrays are not equal");
        }
    }



    //create a method that will return an array of random integers, using length of the array as the only argument
    private static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];


        //assign a random number to each element in the array
        for (int i = 0; i < len; i++){
            newInt[i] = random.nextInt(100);
        }
        //return the array
        return newInt;
    }

}

