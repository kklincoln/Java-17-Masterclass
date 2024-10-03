public class Main {
    public static void main(String[] args) {
        // pre JDK15 way of handling multi-lines of text:
        String bulletIt = "Print a Bulleted List:\n" +
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";
        System.out.println(bulletIt);

        //new implementation
        String textBlock = """
                Print a Bulleted List:
                        \u2022 First Point
                            \u2022 SubPoint""";
        System.out.println(textBlock);

        int age = 35;
        System.out.printf("Your age is %d\n", age);

        int yearOfBirth = 2024-age;
        System.out.printf("Age = %d, Birth year = %d%n", age,yearOfBirth);

        // two decimal places for the number with the %.2f
        System.out.printf("Your age is %.2f%n", (float) age);

        for (int i = 1; i < 1000000; i *=10){
            System.out.printf("Printing %6d %n", i);
        }

        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

    }
}
