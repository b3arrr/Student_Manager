
import java.util.ArrayList;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

    GradeManager studentManager = new GradeManager();

    /*studentManager.makeStudent();
    studentManager.makeStudent();

    studentManager.listStudents(); //list all students
    studentManager.gradeAverage(); //prints out the average grade for students
    studentManager.displayGradeHigh(); //prints out the student with the highest grade
    studentManager.displayGradeLow(); //prints out the student with the lowest grade*/

    }
}

class Student {  // Student class with attributes name and grade. This is to be used as object for the grade manager class

    private final String name;

    private final double grade;


    public Student(String name, double grade) {

        this.name = name;

        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

}

class GradeManager
{
    public ArrayList<Student> students;

    public GradeManager() {
        students = new ArrayList<>();
    }
    public void makeStudent() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String name = userInput.nextLine();

        double grade = 0; // Initialize grade
        boolean validInput = false; // Flag for valid input

        // Loop until valid input is received for the grade
        while (!validInput) {
            System.out.print("Enter student's grade: ");
            try {
                grade = userInput.nextDouble(); // Attempt to read the grade
                validInput = true; // If successful, set flag to true
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value for the grade.");
                userInput.nextLine(); // Clear the invalid input
            }
        }

        Student student = new Student(name, grade);
        String output = addStudent(student);
        System.out.println(output);

    }
    public String addStudent(Student student) {
        students.add(student);
        return "There are " + students.size() + " student(s) in the array";

    }
    public void listStudents() {
        int i = 1;
        for (Student student : students) {

            System.out.println("Student: " + i + "\nName: " + student.getName() + " \nGrade: " + student.getGrade() +"\n");
            i++; //Increments student ID with 1 integer
        }
    }
    public void gradeAverage() {

        double gradeTotal = 0;
        double gradeAverage;
        for (Student student : students) {
            gradeTotal = gradeTotal + student.getGrade();

        }
        gradeAverage = gradeTotal / students.size();
        System.out.println("The average grade is " + gradeAverage);
    }

    public void displayGradeHigh () {
        double highGrade = 0;
        String highGradeName = null;
        for (Student student : students) {
            double grade = student.getGrade();
            if(grade > highGrade) {
                highGrade = grade;
                highGradeName = student.getName();
            }
        }
        System.out.println("The student with the highest grade is " + highGradeName +" with a grade of " + highGrade);
    }
    public void displayGradeLow () {
        double LowGrade = Double.MAX_VALUE;
        String LowGradeName = null;
        for (Student student : students) {
            double grade = student.getGrade();
            if(grade < LowGrade) {
                LowGrade = grade;
                LowGradeName = student.getName();
            }
        }
        System.out.println("The student with the lowest grade is " + LowGradeName +" with a grade of " + LowGrade);
    }
}