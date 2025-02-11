package dev.lpa;

public class Student {

    ///note: when we use the final modifier, we need to intialize the fields
    private final String name;
    private final StringBuilder studentNotes;

    ///GENERATE CONSTRUCTOR
    public Student(String name, StringBuilder studentNotes) {
        this.name = name;
        this.studentNotes = studentNotes;
    }
    ///GENERATE GETTERS
    public String getName() {
        return name;
    }

    public StringBuilder getStudentNotes() {
        return studentNotes;
    }
    ///TOSTRING
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNotes=" + studentNotes +
                '}';
    }
}
