public class MethodOverloadingChallenge2_ConvertToCM {

    public static void main(String[] args){
        System.out.println("5ft, 8in = " +convertToCentimeters(5,8) + "cm");
        System.out.println("68in = " + convertToCentimeters(68) + "cm");
    }

    public static double convertToCentimeters(int heightInInches){
        // formula: 1in = 2.54cm
        return heightInInches * 2.54;
    }

    public static double convertToCentimeters(int heightInFeet, int heightInInches){
        int feetToInches = heightInFeet * 12;
        int totalHeight = feetToInches + heightInInches;
        double result = convertToCentimeters(totalHeight);
        return result;
    }

}
