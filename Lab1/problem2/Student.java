package problem2;

public class Student {

    public enum Faculty {
        IS, CS, AAC, ROBOTICS
    }

    public static final String UNIVERSITY = "KBTU";
    public static int totalStudents = 0;

    private final int id;
    private final Faculty faculty;
    private String name;
    private double gpa;

    {
        totalStudents++;
        id = totalStudents;
    }

    public Student(String name, Faculty faculty, double gpa) {
        this.name = name;
        this.faculty = faculty;
        this.gpa = gpa;
    }

    public Student(String name, Faculty faculty) {
        this(name, faculty, 0.0);
    }

    public int getId() {
        return id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void printInfo() {
        System.out.println("Student: " + name + ", ID: " + id + ", Faculty: " + faculty);
    }

    public void printInfo(boolean includeGpa) {
        if (includeGpa) {
            System.out.println("Student: " + name + ", ID: " + id + ", Faculty: " + faculty + ", GPA: " + gpa);
        } else {
            printInfo();
        }
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", Faculty.IS, 3.8);
        Student s2 = new Student("Bob", Faculty.CS);
        Student s3 = new Student("Charlie", Faculty.AAC, 3.5);

        s1.printInfo();
        s2.printInfo(true);
        s3.printInfo(false);

        System.out.println("University: " + UNIVERSITY);
        System.out.println("Total students: " + totalStudents);
        System.out.println("First student ID: " + s1.getId() + ", faculty: " + s1.getFaculty());
    }
}