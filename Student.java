/**
 * Represents a single student with basic details.
 * This class acts as a blueprint (model) for creating Student objects.
 */
public class Student {

    // Private fields keep the data safe inside the class (encapsulation)
    private final int id;
    private String name;
    private int age;
    private String course;

    /**
     * Constructor to create a new Student object with all required details.
     *
     * @param id     Unique ID of the student
     * @param name   Full name of the student
     * @param age    Age of the student
     * @param course Course the student is enrolled in
     */
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getter methods allow other classes to read the private fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    // Setter methods allow other classes to update modifiable fields
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Returns a readable text format of the Student object when printed.
     */
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Course: " + course;
    }
}
