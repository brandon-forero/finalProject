import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        int lastId = 0;
        int option;
        int teacherType;

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
                    String newStudentName = scan.nextLine();
                    System.out.println("Student age: ");
                    int age = scan.nextInt();

                    Student newStudent = new Student(lastId, newStudentName, age);
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
                    System.out.println("Teacher name: ");
                    scan.nextLine();
                    String newTeacherName = scan.nextLine();
                    System.out.println("Teacher base salary: ");
                    double newTeacherBaseSalary = scan.nextDouble();
                    System.out.println("Which type of teacher do you want to create: ");
                    System.out.println("1. Full time teacher");
                    System.out.println("2. Full time teacher");
                    System.out.println("3. Cancel");
                    teacherType = scan.nextInt();
                    scan.nextLine();
                    if(teacherType == 1){
                        System.out.println("Teacher experience years: ");
                        int newTeacherExperienceYears = scan.nextInt();
                        FullTimeTeacher newTeacher = new FullTimeTeacher(newTeacherName, newTeacherBaseSalary, newTeacherExperienceYears);

                        System.out.println("Full time teacher with the next info was successfully created: ");
                        System.out.println("New teacher name: " + newTeacher.getName());
                        System.out.println("New teacher experience years: " + newTeacher.getExperienceYears());
                        System.out.println("New teacher salary: $" + newTeacher.getSalary());
                    }
                    else if(teacherType == 2){
                        System.out.println("Teacher active hours per week: ");
                        int newTeacherHoursPerWeek = scan.nextInt();
                        PartTimeTeacher newTeacher = new PartTimeTeacher(newTeacherName, newTeacherBaseSalary, newTeacherHoursPerWeek);

                        System.out.println("Part time teacher with the next info was successfully created: ");
                        System.out.println("New teacher name: " + newTeacher.getName());
                        System.out.println("New teacher experience years: " + newTeacher.getHoursPerWeek());
                        System.out.println("New teacher salary: $" + newTeacher.getSalary());

                    }
                    else {
                        System.out.println("wrong option, try again");
                    }
                    pressEnterToContinue();
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
        } while (option != 7);
    }

    public static void pressEnterToContinue() {
        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();
    }
}