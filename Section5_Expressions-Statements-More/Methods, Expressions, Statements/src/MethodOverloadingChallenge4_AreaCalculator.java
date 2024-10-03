//Area Calculator
//Write a method named area with one double parameter named radius.
//The method needs to return a double value that represents the area of a circle.
//If the parameter radius is negative then return -1.0 to represent an invalid value.
//Write another overloaded method with 2 parameters x and y (both doubles), where x and y represent the sides of a rectangle.
//The method needs to return an area of a rectangle.
//If either or both parameters is/are a negative return -1.0 to indicate an invalid value.
//For formulas and PI value please check the tips below.
//
//Examples of input/output:
//area(5.0); should return 78.53981633974483 or 78.53981
//area(-1);  should return -1 since the parameter is negative
//area(5.0, 4.0); should return 20.0 (5 * 4 = 20)
//area(-1.0, 4.0);  should return -1 since first the parameter is negative

//NOTE: All methods need to be defined as public static ​like we have been doing so far in the course.
//NOTE: Do not add a  main method to solution code.
public class MethodOverloadingChallenge4_AreaCalculator {
        // write code here: area of a circle
        public static double area(double radius) {
            // Check if the radius is negative
            if (radius < 0) {
                return -1.0; // Invalid value
            }
            // Calculate and return the area of the circle
            return Math.PI * radius * radius;
        }

        // second method for area of rectangle
        public static double area(double x, double y) {
            // Check if either x or y is negative
            if (x < 0 || y < 0) {
                return -1.0; // Invalid value
            }
            // Calculate and return the area of the rectangle
            return x * y;
        }
}



