public class Main {
    public static void main(String[] args) {
        // say we want to read data out of a database that has a table of student records
        // Student  // Id, Name, DateOfBirth, ClassList

        //create a loop to establish five new student records
        for (int i =1; i <=5; i++){
            LPAStudent s = new LPAStudent("S92300" + i,
                //name
                    switch(i){
                        case 1 -> "Mary";
                        case 2 -> "Madison";
                        case 3 -> "Brandon";
                        case 4 -> "Jessie";
                        case 5 -> "Tim";
                        default -> "Anonymous";
                    },
                //date of birth
                    "11/05/1985",
                //class list
                    "Java Masterclass");
            System.out.println(s);
        }

        // create two students: one with the Student.Java POJO and one with the LPAStudent.java record
        Student pojoStudent = new Student("S923006","Ann",
                "05/11/1985","Java Masterclass");
        LPAStudent recordStudent = new LPAStudent("S923007", "Bill",
                "05/11/1985", "Java Masterclass");
        // note: the records built with the POJO class Student.java have quotation marks due to the toString method and uses {}
        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        // set a new classlist for both students
        pojoStudent.setClassList(pojoStudent.getClassList() + ", Java OCP Exam 829");
        recordStudent.classList();

        // note: the record type allows you to call the name in an object.attribute notation formation rather than a 'getName()' format
        System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());
    }
}
