import java.util.Objects;

public class Student {
    private String name;
    private String address;
    private double GPA;

    // Constructor
    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }
}