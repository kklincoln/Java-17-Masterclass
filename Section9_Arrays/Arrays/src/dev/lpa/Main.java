package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //creating an array; note that this array will be comprised of int elements and a max length of 10
        int[] myIntArray = new int[10];

        // accessing the elements within the array
        myIntArray[5] = 50; //saves 50 to element 6, since array indexes start at 0

        //create an array containing doubles, set the fourth element = 10.33
        double[] myDoubleArray = new double[5];
        myDoubleArray[3]= 10.33;
        System.out.println(myDoubleArray[3]);

        // creating an anonymous int array:
        int[] anonArrayInitializer = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("first = " + anonArrayInitializer[0]);
        int arrayLength = anonArrayInitializer.length;
        System.out.println("length of array = " + arrayLength);

        // new array, this is the array initializer without using the anonymous array
        int[] newArray;
//        newArray = new int[] {5,4,3,2,1};
        newArray = new int[5]; // this initializes the five elements as 0 since this is an int array
        // create a for loop to assign values to the blank array established above
        for (int i = 0; i < newArray.length; i++){
            newArray[i] = newArray.length - i;
        }
        // print out each element in the array using a for loop
        for (int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }
//        create a new array using the for each loop (enhanced for loop)
        System.out.println();
        for (int element : newArray){ //for each int element (within) newArray
            System.out.print(element + " ");
        }
        //blank line
        System.out.println();
        //System.out.println(newArray); //prints out the java class object name, begins with [I meaning primitive int array
        //helper class that lets us print this way:
        System.out.println(Arrays.toString(newArray));


//        if we created an object instance and wanted to validate if the object had an instanceof int[]
        Object objectVariable = newArray;

        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        objectArray[2] = newArray;
    }
}
