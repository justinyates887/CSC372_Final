import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student data. Type 'done' when finished.");

        while (true) {
            System.out.print("Enter name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            double GPA = 0.0;
            while (true) {
                System.out.print("Enter GPA: ");
                String gpaInput = scanner.nextLine();
                try {
                    GPA = Double.parseDouble(gpaInput);
                    if (GPA >= 0.0 && GPA <= 4.0) {
                        break;
                    } else {
                        System.out.println("GPA must be between 0.0 and 4.0. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid GPA. Please enter a numeric value between 0.0 and 4.0.");
                }
            }

            studentList.add(new Student(name, address, GPA));
        }

        // Sort the list by name
        Collections.sort(studentList, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_data.txt"))) {
            for (Student student : studentList) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data has been written to student_data.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        scanner.close();
    }
}