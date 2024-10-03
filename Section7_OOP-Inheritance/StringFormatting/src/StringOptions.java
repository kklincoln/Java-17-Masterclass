public class StringOptions {
    public static void main(String[] args) {
        String helloWorld = "Hello" + " World";
        helloWorld.concat(" and Goodbye");

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");

        printInformation(helloWorld);
        printInformation(helloWorldBuilder);

        //demonstrating how StringBuilder returns a StringBuilder reference that's really a self-reference
        // note: A string builder is mutable, meaning it grows and shrink in size, its default memory alloc is 16
        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(17));
        StringBuilder emptyStart32 = new StringBuilder(32);
        emptyStart32.append("a".repeat(17));

        printInformation(emptyStart);
        printInformation(emptyStart32);


        //demonstrating the methods unique to StringBuilder class
        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append(" and Goodbye");

        builderPlus.deleteCharAt(16).insert(16,"g");
        System.out.println(builderPlus);
        builderPlus.replace(16,17,"G"); //replace the char starting at index 16, ending at 17, with "G"
        System.out.println(builderPlus);
        builderPlus.reverse().setLength(7); //reverses all characters and then truncate the string at 7 characters
        System.out.println(builderPlus);

    }


    public static void printInformation(String string){
        System.out.println("String = " + string);
        System.out.println("length = " + string.length());
    }

    public static void printInformation(StringBuilder builder){
        System.out.println("StringBuilder = " + builder);
        System.out.println("length = " + builder.length());
        System.out.println("capacity = " + builder.capacity());
    }
}
