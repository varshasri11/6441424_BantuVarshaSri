import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");

        System.out.print("Enter student ID to retrieve name: ");
        int id = sc.nextInt();

        String name = studentMap.get(id);
        if (name != null) {
            System.out.println("Student Name: " + name);
        } else {
            System.out.println("Student ID not found.");
        }
    }
}
