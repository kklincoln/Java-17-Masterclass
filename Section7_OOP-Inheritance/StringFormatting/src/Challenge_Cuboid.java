public class Challenge_Cuboid extends Challenge_Rectangle {
        // write code here
        // The class needs one field (instance variable) with name height of type double.
        private double height;

        // The class needs to have one constructor with three parameters width, length, and height all of type double. It needs to call parent constructor and initialize a height field.
        public Challenge_Cuboid(double width, double length, double height) {
            super(width, length);
            // In case the height parameter is less than 0 it needs to set the height field value to 0.
            this.height = (height < 0) ? 0 : height;
        }

        // Write the following methods (instance methods):
        // Method named getHeight without any parameters, it needs to return the value of height field.
        public double getHeight(){
            return height;
        }
        // Method named getVolume without any parameters, it needs to return the calculated volume. To calculate volume multiply the area with height.
        public double getVolume(){
            return height * getArea();
        }
    }

