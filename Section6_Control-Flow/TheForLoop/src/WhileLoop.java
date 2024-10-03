public class WhileLoop {
    public static void main(String[] args) {
//        //for loop approach
//        for (int i = 1; i <= 5; i++){
//            System.out.println(i);
//        }
//        // while loop approach
//        int j = 1;
////        while (j <= 5){ //approach 1
////        while(true){ //approach 2
//        boolean isReady = false; // approach 3
//        do {
//            if (j >5){
//                break; //stops loop
//            }
//            System.out.println(j);
//            j++;
//            isReady = (j>0); //sets isReady = true
//        } while (isReady);

        //new while loop using continue
        int number = 0;
        while (number <50){
            number += 5;
            // adding code to skip numbers that are divisible by twenty five: skips 25 and 50
            if (number % 25 == 0){
                continue;
            }
            System.out.println(number + "_");
        }
    }
}
