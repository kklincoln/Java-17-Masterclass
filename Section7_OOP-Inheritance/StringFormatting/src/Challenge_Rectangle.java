public class Challenge_Rectangle {
        // write code here
        // 1. Write a class with the name Rectangle. The class needs two fields (instance variable) with name width and length both of type double.
        private double width;
        private double length;

        // The class needs to have one constructor with parameters width and length both of type double and it needs to initialize the fields.
        public Challenge_Rectangle(double width, double length){
            // In case the width parameter is less than 0 it needs to set the width field value to 0.
            this.width = (width < 0) ? 0 : width;
            // In case the length parameter is less than 0 it needs to set the length field value to 0.
            this.length = (length < 0) ? 0 : length;

        }

        // Write the following methods (instance methods):
        // Method named getWidth without any parameters, it needs to return the value of width field.
        public double getWidth(){
            return width;
        }
        // Method named getLength without any parameters, it needs to return the value of length field.
        public double getLength(){
            return length;
        }
        // Method named getArea without any parameters, it needs to return the calculated area (width * length).
        public double getArea(){
            return (width * length);
        }

    }
