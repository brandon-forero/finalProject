import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        int lastId = 0;
        int option;

        do {
            System.out.println("\nWelcome to the university system\nSelect an option:");
            System.out.println("1. Print all teachers");
            System.out.println("2. Print all classes");
            System.out.println("3. Create a new student");
            System.out.println("4. Create a new class");
            System.out.println("5. Create a new teacher");
            System.out.println("6. List all classes for an student");
            System.out.println("7. Exit");
            System.out.print("Option: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.println("selected: 1");
                    break;
                case 2:
                    System.out.println("selected: 2");
                    break;
                case 3:
                    System.out.println("Creating a new student...");
                    System.out.println("Student name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.println("Student age: ");
                    int age = scan.nextInt();

                    Student newStudent = new Student(lastId, name, age);
                    lastId++;
                    System.out.println("Student with the next info was successfully created: ");
                    System.out.println("New student id: " + newStudent.getId());
                    System.out.println("New student name: " + newStudent.getName());
                    System.out.println("New student age: " + newStudent.getAge());
                    pressEnterToContinue();
                    break;
                case 4:
                    System.out.println("selected: 4");
                    break;
                case 5:
                    System.out.println("Creating a new teacher...");
                    break;
                case 6:
                    System.out.println("selected: 6");
                    break;
                case 7:
                    System.out.println("Bye Bye :)");
                    break;
                default:
                    System.out.println("Invalid option :(, Try again");
                    break;
            }
        } while (option != 6);
    }

    public static void pressEnterToContinue() {
        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();
    }
}