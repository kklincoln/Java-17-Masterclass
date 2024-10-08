package dev.lpa;

import java.util.Arrays;

public class MultipleArrays {
    public static void main(String[] args) {

//this creates a 2D array with 4 elements.  each element in the outer array gets assigned a nested array with 4 elements
        int[][] array2 = new int[4][4];
        System.out.println(Arrays.toString(array2));
        System.out.println("array2.length = " + array2.length);

        //print each element in the array inidividually for each int[] (within) array2,
        for (int[] outer : array2){
            System.out.println(Arrays.toString(outer)); //loop through the outer array and each element is an array of 4 ints
        }
        System.out.println("_".repeat(20)); //codebreak for visibility in console

        //print each element using nested for loop, as will probably be seen later
        for (int i = 0; i < array2.length; i++){
            var innerArray = array2[i]; //assigning the current index of array2 to the var innerArray
            for (int j = 0; j < innerArray.length; j++){
//                System.out.println(array2[i][j] + " "); // print out the element at [row][col]
                array2[i][j] = (i * 10) + (j + 1); // insert values = row index * 10 + column position
            }
//            System.out.println(); //space to take us to the next row
        }


//        // printing the array using an enhanced for-loop (foreach)
//        for (var outer : array2){//for each outer var element within array2
//            for (var element : outer) {//for each var element within the outer array
//                System.out.print(element + " ");
//            }
//            System.out.println(); //new line
//        }

        // simplest way to print the array using deepToString
        System.out.println(Arrays.deepToString(array2));

        //demonstrating that we can change the dimensions of the array and not be restricted to the same length for all
        array2[1] = new int[] {10,10,30};
        System.out.println(Arrays.deepToString(array2));
        System.out.println("_".repeat(20)); //codebreak for visibility in console

        Object[] anyArray = new Object[3]; //new object array of 3 elements
        System.out.println(Arrays.toString(anyArray)); // returns three null elements

        // creating a two dimensional array, with equal dimensions; within the first element of the outer array
        anyArray[0] = new String[] {"a","b","c"};
        System.out.println(Arrays.deepToString(anyArray));

        // creating a two-dimensional array as a multidimensional array, with verying dimensions
        // ;within the second element of the outer array
        anyArray[1] = new String[][] {
                {"1","2"},
                {"3","4","5"},
                {"6","7","8","9"}
        };
        System.out.println(Arrays.deepToString(anyArray));

        //creating a three-dimensional array
        anyArray[2] = new int[2][2][2];
        System.out.println(Arrays.deepToString(anyArray));
        System.out.println("_".repeat(20)); //codebreak for visibility in console


        //print using a foreach loop for readability
         for (Object element : anyArray){
            System.out.println("element type = " + element.getClass().getSimpleName()); //print classname of each element in array
            System.out.println("Element toString() " + element); // print toString representation of each element
            System.out.println(Arrays.deepToString((Object[]) element)); //print each element in the multiD array, cast as object

         }
    }
}
