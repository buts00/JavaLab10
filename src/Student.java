/**
 * The Student class represents a student with basic information.
 */
public class Student {

    private String name;
    private String university;
    private String faculty;
    private double averageScore;

    /**
     * Constructor to create a Student object with provided details.
     *
     * @param name          The name of the student.
     * @param university    The university the student attends.
     * @param faculty       The faculty the student is enrolled in.
     * @param averageScore  The average score of the student.
     */
    public Student(String name, String university, String faculty, double averageScore) {
        this.name = name;
        this.university = university;
        this.faculty = faculty;
        this.averageScore = averageScore;
    }

    /**
     * Retrieves the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     *
     * @param name The name to be set for the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the university the student attends.
     *
     * @return The name of the university.
     */
    public String getUniversity() {
        return university;
    }

    /**
     * Sets the university for the student.
     *
     * @param university The university to be set for the student.
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * Retrieves the faculty the student is enrolled in.
     *
     * @return The name of the faculty.
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * Sets the faculty for the student.
     *
     * @param faculty The faculty to be set for the student.
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * Retrieves the average score of the student.
     *
     * @return The average score of the student.
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * Sets the average score for the student.
     *
     * @param averageScore The average score to be set for the student.
     */
    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * Prints information about the student.
     */
    public void printInformation() {
        System.out.println("Student's name: " + getName());
        System.out.println("University: " + getUniversity());
        System.out.println("Faculty of: " + getFaculty());
        System.out.println("Student's average score: " + getAverageScore());
    }
}
