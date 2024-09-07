import java.util.ArrayList;
import java.util.Scanner;

class GradeManager {
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
        userInput.nextLine();
        userInput.nextLine();

    }

    public String addStudent(Student student) {
        students.add(student);
        return "There are " + students.size() + " student(s) in the array";

    }

    public void listStudents() {
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        for (Student student : students) {

            System.out.println("Student: " + i + "\nName: " + student.getName() + " \nGrade: " + student.getGrade() + "\n");
            i++; //Increments student ID with 1 integer
        }
        scanner.nextLine();
    }

    public void gradeAverage() {
        Scanner scanner = new Scanner(System.in);
        double gradeTotal = 0;
        double gradeAverage;
        for (Student student : students) {
            gradeTotal = gradeTotal + student.getGrade();

        }
        gradeAverage = gradeTotal / students.size();
        System.out.println("The average grade is " + gradeAverage);
        scanner.nextLine();
    }

    public void displayGradeHigh() {
        Scanner scanner = new Scanner(System.in);
        double highGrade = 0;
        String highGradeName = null;
        for (Student student : students) {
            double grade = student.getGrade();
            if (grade > highGrade) {
                highGrade = grade;
                highGradeName = student.getName();
            }
        }
        System.out.println("The student with the highest grade is " + highGradeName + " with a grade of " + highGrade);
        scanner.nextLine();

    }


    public void displayGradeLow() {
        Scanner scanner = new Scanner(System.in);
        double LowGrade = Double.MAX_VALUE;
        String LowGradeName = null;
        for (Student student : students) {
            double grade = student.getGrade();
            if (grade < LowGrade) {
                LowGrade = grade;
                LowGradeName = student.getName();
            }
        }
        System.out.println("The student with the lowest grade is " + LowGradeName + " with a grade of " + LowGrade);
        scanner.nextLine();

    }
}
