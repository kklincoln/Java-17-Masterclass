public class Main extends Object {
    public static void main(String[] args) {
        //every class inherits from Object, and that includes the main class. (Java.lang.Object)
        Student max = new Student("Max", 21);
        System.out.println(max);

        PrimarySchoolStudent jimmy = new PrimarySchoolStudent("Jimmy", 8,"Carol");
        System.out.println(jimmy);
    }
}

//create a new class
class Student{
    private String name;
    private int age;

    //create constructors associated with the class
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    //in order to override the toString method on Object, we use the below. the toString on Object outputs "student@hashcode"
    @Override
    public String toString() {
        return name + " is " + age + " years old.";
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
    }
}

class PrimarySchoolStudent extends Student{
    // add fields
    private String parentName;

    //add constructor: superFields, fields
    PrimarySchoolStudent(String name, int age, String parentName){
        super(name,age);
        this.parentName=parentName;
    }
    // add toString override
    @Override
    public String toString() {
        return parentName + "'s child, " + super.toString(); // this doesn't call Object.toString it now calls Student.toString
    }
    // add methods
}
