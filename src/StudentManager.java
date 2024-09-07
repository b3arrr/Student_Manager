
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {


    public static void main(String[] args) {
        GradeManager studentManager = new GradeManager();
        int userInput = startProgram();
        boolean exit = false;
        while (!exit) {

            switch (userInput) {
                case 1:
                    studentManager.makeStudent();
                    break;
                case 2:
                    studentManager.displayGradeHigh();
                    break;
                case 3:
                    studentManager.displayGradeLow();
                    break;
                case 4:
                    studentManager.gradeAverage();
                    break;
                case 5:
                    studentManager.listStudents();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;

            }
            if (!exit) userInput = startProgram();
        }


    }

  

    public static int startProgram() {
        System.out.println("--Welcome to the student manager program--\nWhat do you wish to do?");
        Scanner userInput = new Scanner(System.in);
        String userString;
        int numberInput = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please select one of the following options:");
            System.out.println("1. Add student to database\n2. See student with highest grade\n3. See student with lowest grade.\n4. See the average grade of the students\n5. List students\n6. Quit application");
            try {
                userString = userInput.nextLine();
                numberInput = Integer.parseInt(userString);
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please use a numeric value between 1-5");

            }


        }
        return numberInput;

    }
}





