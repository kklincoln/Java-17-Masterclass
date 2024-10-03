public class StringMethods {
    public static void main(String[] args) {
        /////////////////////////////////////
        // string manipulation methods: perform some kind of cleanup
        String birthDate = "25/11/1982";
        int startingIndex = birthDate.indexOf("1982"); //gets index position of the year
        System.out.println("StartingIndex = " + startingIndex); // prints the starting index from previous step
        System.out.println("Birth Year = " + birthDate.substring(startingIndex)); // prints the starting year
        System.out.println("Month =" + birthDate.substring(3,5)); // prints just the month of DD/MM/YYYY

        String newDate = String.join("/", "25","11","1982"); //join all elements using delimiter
        System.out.println("newDate = " + newDate); // simple add of string literal types

        newDate = "25"; //concats below
        newDate = newDate.concat("/");
        newDate = newDate.concat("11/1982");
        System.out.println("newDate = " + newDate);

        newDate = "25" + "/" + "11/1982";
        System.out.println("newDate = " + newDate);

        //concat chain
        newDate = "25".concat("/").concat("11").concat("/1982");
        System.out.println("newDate = " + newDate);

        //replace texts
        System.out.println(newDate.replace("/","-"));
        System.out.println(newDate.replace("2","00"));
        System.out.println(newDate.replaceFirst("/","-"));
        System.out.println(newDate.replaceAll("/","-"));

        //repeat functions
        System.out.println("ABC\n".repeat(3));
        System.out.println("-".repeat(20));
        System.out.println("ABC\n".repeat(3).indent(8)); //indent can also be set in the negative direction
        System.out.println("-".repeat(20));    }
}
