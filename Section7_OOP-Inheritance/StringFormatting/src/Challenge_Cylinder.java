public class Challenge_Cylinder extends Challenge_Circle {
        // write code here
        // 2. Write a class with the name Cylinder that extends Circle class. The class needs one field (instance variable) with name height of type double.
        private double height;

        // The class needs to have one constructor with two parameters radius and height both of type double. It needs to call parent constructor and initialize a height field
        public Challenge_Cylinder(double radius, double height){
            super(radius);
            // In case the height parameter is less than 0 it needs to set the height field value to 0.
            this.height = height < 0 ? 0 : height;

        }

        // Write the following methods (instance methods):
        // Method named getHeight without any parameters, it needs to return the value of height field.
        public double getHeight() {
            return height;
        }
        // Method named getVolume without any parameters, it needs to return the calculated volume. To calculate volume multiply the area with height.
        public double getVolume() {
            return height * getArea();
        }

    }
