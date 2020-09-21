package LessonBD;

public class Driver {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Driver(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Driver" + "\n" + id + " " + firstName + " " + lastName + " " + age;
    }
}
