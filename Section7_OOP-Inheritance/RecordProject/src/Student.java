public class Student {
    // a POJO in its simplest form requires a way to populate data, I'll use a constructor
    // Student  // Id, Name, DateOfBirth, ClassList
    private String Id;
    private String Name;
    private String DateOfBirth;
    private String ClassList;

    public Student(String id, String name, String dateOfBirth, String classList) {
        Id = id;
        Name = name;
        DateOfBirth = dateOfBirth;
        ClassList = classList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", ClassList='" + ClassList + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getClassList() {
        return ClassList;
    }

    public void setClassList(String classList) {
        ClassList = classList;
    }
}
