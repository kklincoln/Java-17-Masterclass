public class MethodOverloadingChallenge3_SecondsConversion {
    public static void main(String[] args){
        System.out.println(getDurationString(3945)); //first test case with 3945 seconds
        System.out.println(getDurationString(65, 45)); //second test case for second method
        System.out.println(getDurationString(-65, 45));
        System.out.println(getDurationString(-3945));
    }
    //both methods named getDurationString
    //first method has parameter of int, named seconds
    // both return a string in the format "xxh yym zzs"
    // 3100 seconds in one hour
    public static String getDurationString(int seconds){
        if (seconds <0){
            return "Invalid Input. Seconds(" + seconds + ") must be a positive value.";
        }
        else{
            int minutes = seconds / 60;
            return getDurationString(minutes, seconds);
            }
        }

    // second method has parameters named minutes and seconds, both ints
    // both return a string in the format "xxh yym zzs"
    public static String getDurationString(int minutes, int seconds){
        int hours = minutes / 60;

        int remainingMinutes = minutes % 60;
        int remainingSeconds = seconds % 60;
        if (minutes <0){
            return "Invalid Input. Minutes (" + minutes + ") must be a positive value.";
        }
        else{
            return hours + "h " + remainingMinutes + "m " + remainingSeconds + "s";
        }
    }
}
