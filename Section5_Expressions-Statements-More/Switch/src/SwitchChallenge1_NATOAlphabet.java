public class SwitchChallenge1_NATOAlphabet {
    public static void main(String[] args){
        // a= Able, b= Baker, c=Charlie, d=Dog, e=easy
        char charValue = 'A';
        switch (charValue){
            case 'A':
                System.out.print("A is able");
                break;
            case 'B':
                System.out.print("B is baker");
                break;
            case 'C':
                System.out.print("C is charlie");
                break;
            case 'D':
                System.out.print("D is dog");
                break;
            case 'E':
                System.out.print("E is easy");
                break;
            default:
                System.out.println("Letter " + charValue + " was not found in the switch");
        }
    }
}
