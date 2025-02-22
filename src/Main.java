import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int option;

        do {
            System.out.println("\nWelcome to the university system\nSelect an option:");
            System.out.println("1. Print all teachers");
            System.out.println("2. Print all classes");
            System.out.println("3. Create a new student");
            System.out.println("4. Create a new class");
            System.out.println("5. List all classes for an student");
            System.out.println("6. Exit");
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
                    System.out.println("selected: 3");
                    break;
                case 4:
                    System.out.println("selected: 4");
                    break;
                case 5:
                    System.out.println("selected: 5");
                    break;
                case 6:
                    System.out.println("Bye Bye :)");
                    break;
                default:
                    System.out.println("Invalid option :(, Try again");
                    break;
            }
        } while (option != 6);
    }
}