public class AllAboutStrings {
    public static void main(String[] args) {
        printInformation("Testing Prints");
        printInformation(""); //this is the empty string
        printInformation("\t \n"); // this is the blank string

        ////////////////////////////////
        //testing string inspection methods
        String helloWorld = "Hello World!";
        System.out.printf("index of r = %d %n", helloWorld.indexOf("r")); // locate the first instance of r
        System.out.printf("index of world = %d %n", helloWorld.indexOf("world")); // locate a full word

        System.out.printf("index of l = %d %n", helloWorld.indexOf("l")); // first instance
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf("l")); // last instance

        ////////////////////////////////
        //testing string comparison methods
        String helloWorldLower = helloWorld.toLowerCase();
        if (helloWorld.equals(helloWorldLower)) {
            System.out.println("Values match exactly.");
        }if (helloWorld.equalsIgnoreCase(helloWorldLower)) {
            System.out.println("Values match ignoring case.");
        }
        //startswith
        if (helloWorld.startsWith("Hello")){
            System.out.println("String starts with Hello");
        }if (helloWorld.endsWith("world!")){
            System.out.println("String ends with world!");
        }if (helloWorld.contains("World")){
            System.out.println("String contains World!");
        }if(helloWorld.contentEquals("Hello World!")){ // can be used to compare the method builder's value
            System.out.println("Values match exactly!");
        }

        /////////////////////////////////////
        // string manipulation methods: perform some kind of cleanup


    }

    public static void printInformation(String string){
        int length = string.length();
        System.out.printf("Length = %d %n", length);

        if (string.isEmpty()){
            System.out.println("The string is empty!");
            return; //exits the code
        }

        if (string.isBlank()){
            System.out.println("The String is blank!");
            return;
        }
        System.out.printf("First char = %c %n", string.charAt(0));
        System.out.printf("Last char = %c %n", string.charAt(length-1));


    }
}
