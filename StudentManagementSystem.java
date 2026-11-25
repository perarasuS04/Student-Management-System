import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the console-based Student Management System.
 * Stores Student objects in memory using an ArrayList and provides
 * a menu-driven interface using Scanner.
 */
public class StudentManagementSystem {

    // ArrayList to store all Student objects during the program run
    private static final ArrayList<Student> students = new ArrayList<>();

    // Scanner to read user input from the keyboard
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("==========================================");
        System.out.println("   Welcome to Student Management System   ");
        System.out.println("==========================================");

        // Keep showing the menu until the user chooses to exit
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice (1-6): ");

            // Handle the user's menu selection using switch-case
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }

        // Close the Scanner when the program finishes
        scanner.close();
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student Details");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    /**
     * Prompts the user for student details, validates them, and adds a new Student.
     */
    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        int id = readPositiveInt("Enter Student ID (positive number): ");

        // Prevent duplicate student IDs
        if (findStudentById(id) != null) {
            System.out.println("Error: A student with ID " + id + " already exists.");
            return;
        }

        String name = readNonEmptyString("Enter Student Name: ");
        int age = readValidAge("Enter Student Age (5-120): ");
        String course = readNonEmptyString("Enter Student Course: ");

        // Create a new Student object using the constructor and add it to the ArrayList
        Student newStudent = new Student(id, name, age, course);
        students.add(newStudent);

        System.out.println("Student added successfully!");
    }

    /**
     * Displays all students currently stored in the ArrayList.
     */
    private static void viewAllStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        // Loop through every Student object in the list and print it
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Searches for a student by ID and displays their details if found.
     */
    private static void searchStudentById() {
        System.out.println("\n--- Search Student ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        int id = readPositiveInt("Enter Student ID to search: ");
        Student student = findStudentById(id);

        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("No student found with ID " + id + ".");
        }
    }

    /**
     * Finds a student by ID and updates their name, age, and course.
     */
    private static void updateStudent() {
        System.out.println("\n--- Update Student ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        int id = readPositiveInt("Enter Student ID to update: ");
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("No student found with ID " + id + ".");
            return;
        }

        System.out.println("Current details: " + student);

        String newName = readNonEmptyString("Enter new Name: ");
        int newAge = readValidAge("Enter new Age (5-120): ");
        String newCourse = readNonEmptyString("Enter new Course: ");

        // Update the existing Student object using its setter methods
        student.setName(newName);
        student.setAge(newAge);
        student.setCourse(newCourse);

        System.out.println("Student details updated successfully!");
    }

    /**
     * Finds a student by ID and removes them from the ArrayList.
     */
    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        int id = readPositiveInt("Enter Student ID to delete: ");
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("No student found with ID " + id + ".");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully!");
    }

    /**
     * Helper method that searches the ArrayList for a student with the given ID.
     *
     * @param id Student ID to look for
     * @return Matching Student object, or null if not found
     */
    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Reads a valid integer from the user, looping until valid input is given.
     * Uses nextLine() so leftover newline characters do not skip future inputs.
     */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid whole number.");
            }
        }
    }

    /**
     * Reads a positive integer (greater than 0) from the user.
     */
    private static int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Invalid input. Please enter a number greater than 0.");
        }
    }

    /**
     * Reads a valid student age between 5 and 120.
     */
    private static int readValidAge(String prompt) {
        while (true) {
            int age = readInt(prompt);
            if (age >= 5 && age <= 120) {
                return age;
            }
            System.out.println("Invalid age. Please enter an age between 5 and 120.");
        }
    }

    /**
     * Reads a non-empty text string from the user.
     */
    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Invalid input. This field cannot be empty.");
        }
    }
}
