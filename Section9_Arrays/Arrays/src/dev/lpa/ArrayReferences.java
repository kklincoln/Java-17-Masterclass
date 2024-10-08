package dev.lpa;

import java.util.Arrays;

public class ArrayReferences {

    public static void main(String[] args) {
        int[] myIntArray = new int[5]; //this array has 5 elements and a reference, myIntArray
        int[] anotherArray = myIntArray; // we are declaring another reference to the SAME array in memory

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));
//both of these examples for modification update both arrays, since these elements are pointing to the same array in memory
        //this is to make note of the consideration that if we pass arrays into a method, it's advisable to do so with Arrays.copyOf
        anotherArray[0]  = 1;
        modifyArray(myIntArray);

        System.out.println("after change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after change anotherArray = " + Arrays.toString(anotherArray));
    }


    private static void modifyArray(int[] array){
        array[1] = 2;
    }
}
