public class TernaryChallenge {
    public static void main(String[] args) {
        // step 1: create a double variable with a value of 20.00
        double myDoubleTwenty = 20.00d;
        // 2: create a second variable of type double with a value 80.00
        double myDoubleEighty = 80.00d;
        // 3: add both numbers together and multiply by 100.00
        double myValuesTotal = (myDoubleTwenty + myDoubleEighty) * 100.00d;
        System.out.println("MyValuesTotal: " + myValuesTotal);
        // 4: use the remainder operator to figure out the remainder from the resulting product and 40.00 would be
        double myDoubleRemainder = (myValuesTotal % 40.00d);
        System.out.print("myDoubleRemainder: " + myDoubleRemainder);
        // 5: create a bool that assigns the value true if the remainder in step four is 0.00 false otherwise
        boolean zeroBalance = (myDoubleRemainder == 0.00d) ? true : false;
        // 6: output the bool value
        System.out.print("zeroBalance = " + zeroBalance);
        //7: write an if-them statement that displays 'got some remainder' if the bool was not true
        if (!zeroBalance){
            System.out.println("got some remainder");
        }

    }
}
