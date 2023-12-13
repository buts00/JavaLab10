import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;

/**
 * This class, Practice, provides functionalities to manage student data in a file.
 */
public class Practice {
    /**
     * Saves student information to a file.
     *
     * @param student The Student object containing information to be saved.
     * @param path    The path to the file where data will be saved.
     * @throws IOException If an I/O error occurs while writing to the file.
     */

    public static void saveStudent(Student student, String path) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(path, true));
        out.println(student.getName() + "," + student.getUniversity() + "," + student.getFaculty() + "," + student.getAverageScore());
        out.close();
    }

    /**
     * Displays information about students stored in a file.
     *
     * @param path The path to the file containing student information.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static void displayStudents(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        int studentNumber = 1;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            if (data.length == 4) {
                String name = data[0];
                String university = data[1];
                String faculty = data[2];
                double averageScore = Double.parseDouble(data[3]);
                System.out.println("------------Information about " + studentNumber + " student-----------" );
                Student curStudent =  new Student(name,university,faculty,averageScore);
                curStudent.printInformation();
                studentNumber++;
            }
        }
        reader.close();
    }


    /**
     * Checks if a file is empty.
     *
     * @param filename The name of the file to be checked.
     * @return True if the file is empty, otherwise false.
     */

    public static boolean isFileEmpty(String filename) {
        File file = new File(filename);
        return (file.length() == 0);
    }

    /**
     * Finds the most successful student based on their average score from the file.
     *
     * @param path The path to the file containing student information.
     * @return The Student object with the highest average score.
     * @throws IOException If an I/O error occurs while reading the file.
     */

    public static Student findMostSuccessfulStudent(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
        Student mostSuccessfulStudent = null;
        double highestScore = Double.MIN_VALUE;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 4) {
                String name = data[0];
                String university = data[1];
                String faculty = data[2];
                double averageScore = Double.parseDouble(data[3]);
                if (averageScore > highestScore) {
                    highestScore = averageScore;
                    mostSuccessfulStudent = new Student(name, university, faculty, averageScore);
                }
            }
        }
        reader.close();
        return mostSuccessfulStudent;
    }

    /**
     * Main method to interact with user inputs and manage student data.
     *
     * @param args Command-line arguments (not used in this context).
     * @throws IOException If an I/O error occurs during file operations.
     */

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "students.txt";


        while (true) {
            System.out.println("Enter one operations:");
            System.out.println("1. Add new student");
            System.out.println("2. Show information about student");
            System.out.println("3. Find the most successful");
            System.out.println("4. Clear data about students");
            System.out.println("5. Exit");

            int x = Integer.parseInt(scanner.nextLine());

            if (x == 1) {
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("University: ");
                String university = scanner.nextLine();

                System.out.print("Faculty: ");
                String faculty = scanner.nextLine();

                System.out.print("AverageScore: ");
                double averageScore = Double.parseDouble(scanner.nextLine());
                Student student = new Student(name, university, faculty, averageScore);
                saveStudent(student,path);
            } else if (x == 2) {
                if (isFileEmpty(path)) {
                    System.out.println("Empty data about students");
                } else {
                    displayStudents(path);
                    System.out.println("----------------");
                }
            } else if (x == 3) {
                if (isFileEmpty(path)) {
                    System.out.println("Empty data about students");
                } else {
                    Student mostSuccessfulStudent = findMostSuccessfulStudent(path);
                    System.out.print("The most successful student is: ");
                    mostSuccessfulStudent.printInformation();
                    System.out.println("----------------");
                }
            } else if (x == 4) {
                System.out.println("All data was deleted");
                PrintWriter writer = new PrintWriter(path);
                writer.close();
            } else if (x==5){
                System.out.println("The end of program");
                break;
            } else {
                System.out.println("Enter correct data");
            }
        }
        scanner.close();
    }
}
