public class Challenge_Circle {
        // The class needs one field (instance variable) with name radius of type double.
        private double radius;

        //The class needs to have one constructor with parameter radius of type double and it needs to initialize the fields.
        public Challenge_Circle(double radius) {
            //In case the radius parameter is less than 0 it needs to set the radius field value to 0.
            this.radius = radius < 0 ? 0 : radius;
        }

        // Write the following methods (instance methods):
// Method named getRadius without any parameters, it needs to return the value of radius field.
        public double getRadius() {
            return radius;
        }

        // Method named getArea without any parameters, it needs to return the calculated area (radius * radius * PI). For PI use Math.PI constant.
        public double getArea() {
            return radius * radius * Math.PI;
        }
}
