package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //MANUAL BOXING AND UNBOXING
        // the first two statements attempt to manually box the primitive int 15, to an instance Integer wrapper class
        Integer boxedInt = Integer.valueOf(15); //preferred, but unnecessary since Java does this automatically
        Integer deprecatedBoxing = new Integer(15); //deprecated since JDK 9, do not write this way
        int unboxedInt = boxedInt.intValue(); //unnecessary

        //AUTOMATIC BOXING
        Integer autoBoxed = 15; // assigns 15 to an integer variable
        int autoUnboxed = autoBoxed; // assigns the variable autoboxed to an int variable
        System.out.println(autoBoxed.getClass().getName()); // type java.lang.Integer
//        System.out.println(autoUnboxed.getClass().getName()); //can't use methods on primitive types



        // the autoboxing occurs within the methods below, but since we assign them to the primitive variable, the unboxing is auto
        Double resultBoxed = getDoubleObject();
        double resultUnboxed = getLiteralDoublePrimitive();
        System.out.println(resultBoxed.getClass().getName());


        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;   //autoboxes the primitive integer literal 50 to an instance of an Integer class
        System.out.println(Arrays.toString(wrapperArray)); // [50, null,null,null,null]
        System.out.println(wrapperArray[0].getClass().getName());//java.lang.Integer

        Character[] characterArray = {'a','b','c','d'};
        System.out.println(Arrays.toString(characterArray));// [a, b, c, d]


        //calling the method with the ArrayList, below
        var ourList = getList(2,57,5,3);
        System.out.println(ourList);
    }

    private static ArrayList<Integer> getList(int... varargs){ //called with zero to many int values
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i : varargs){ //for each primitive int within varargs, add it to the ArrayList
            aList.add(i); //declared with an integer wrapper parameter type, not a primitive type. this is another way to autobox
        }
        return aList;
    }

    //few more static methods to demonstrate autoboxing
    // we can also pass boxed or autoboxed values to those methods as well (invoked in Main)
    private static int returnAnInt(Integer i){
        //the return type is int primitive. java unboxes the i argument to retrun the primitive value boxed in the wrapper argument
        return i;
    }
    private static Integer returnAnInteger (int i){
        //returns type java.lang.Integer from an int parameter; in other words, an object is returned
        //the variable i is auto-boxed to an instance of the integer wrapper class and returned without writing specific code
        return i;
    }





    private static double getDoubleObject(){
        //in this code, use the static factory method, Double.valueOf() just to make it clear that we are returning an object of type Double
        return Double.valueOf(100.00);
    }

    private static double getLiteralDoublePrimitive(){
        // return a literal decimal number, because that's a double primitive
        return 100.0;
    }


}
