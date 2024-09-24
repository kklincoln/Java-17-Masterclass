public class Switch {
    public static void main(String[] args){
//        int value = 1;
        // replacing previous approaches that were written as if, then, else statements
//        if (value ==1 ){
//           System.out.println("Value was 1.");
//        } else if (value == 2){
//            System.out.println("Value was 2.");
//        } else{
//            System.out.println("Value was not 1 or 2.");
//        }
//        int switchValue = 3;
//        switch(switchValue){
//            case 1:
//                //code for value == x
//                System.out.println("Value was 1");
//                // note: without including the break statements, no more of the case statements will be checked, but each
//                // of the following code statements will be executed regardless, until the codeblock is complete or a break
////                is reached
//                break;
//            case 2:
//                // code for value == y
//                System.out.println("Value was 2");
//                break;
//            case 3: case 4: case 5:
//                System.out.println("Was a 3, a 4, or a 5.");
//                System.out.println("Actually, it was a " + switchValue);
//                break;
//            default:
//                //code for value not equal to x or y
//                System.out.println("Value was not 1, 2, 3, 4, or 5.");
//                break;
//        }
        // ENHANCED SWITCH STATEMENT
        int switchValue = 3;
        switch(switchValue){
            case 1 -> System.out.println("Value was 1");
            case 2 -> System.out.println("Value was 2");
            case 3,4,5 ->{
                System.out.println("Value was a 3, 4, or a 5");
                System.out.println("Actually, it was a " + switchValue);
            }
            default -> System.out.println("Was not a 1, 2, 3, 4, or 5");
        }

        String month = "APRIL";
        System.out.print(month + " is in the " + getQuarter(month) + " quarter.");

    }
    //new method that takes a string as a single parameter and returns a string
    public static String getQuarter(String month){
        return switch (month) {
            // since there are no break statements, it continues through to the first return since it acts as a break statement
            case "JANUARY", "FEBRUARY", "MARCH" -> "1st";
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            default -> {
                String badResponse = month + " is bad";
                yield badResponse; // yield is only required
            }
        };
    }
}
