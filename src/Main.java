import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        int option;
        int teacherType;
        University university = new University();
        initUniversity(university);

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
                    System.out.println("Teachers: ");
                    for(int i = 0; i < university.getTeachers().size(); i++){
                        Teacher teacher = university.getTeachers().get(i);
                        System.out.println(i + ". \n name: " + teacher.getName() + ", salary: $" + teacher.getSalary());
                    }
                    pressEnterToContinue();
                    break;
                case 2:
                    System.out.println("Classes: ");
                    for(int i = 0; i < university.getClasses().size(); i++){
                        Class currentClass = university.getClasses().get(i);
                        System.out.println(i + ". " + currentClass.getName());
                    }
                    System.out.println(university.getClasses().size() + ". Return to menu");
                    System.out.println("Select a class for see more info ");
                    int selectedClass = scan.nextInt();

                    if(selectedClass < university.getClasses().size()){
                        System.out.println("Class information: ");
                        System.out.println("Name: " + university.getClasses().get(selectedClass).getName());
                        System.out.println("Classroom: " + university.getClasses().get(selectedClass).getClassRoom());
                        System.out.println("Teacher: " + university.getClasses().get(selectedClass).getTeacher().getName());
                        System.out.println("Students: ");
                        for(Student student : university.getClasses().get(selectedClass).getStudents()){
                            System.out.println(student.getId() + ". " + student.getName());
                        }
                        pressEnterToContinue();
                        break;
                    }
                    else if(selectedClass == university.getClasses().size()){
                        System.out.println("Returning to menu.. ");
                        pressEnterToContinue();
                        break;
                    }

                    else {
                        System.out.println("Wrong option :(, returning to menu.. ");
                        pressEnterToContinue();
                        break;
                    }

                case 3:
                    System.out.println("Creating a new student...");
                    System.out.println("Student name: ");
                    scan.nextLine();
                    String newStudentName = scan.nextLine();
                    System.out.println("Student age: ");
                    int age = scan.nextInt();

                    Student newStudent = new Student(university.getStudents().size(), newStudentName, age);
                    university.addStudent(newStudent);

                    System.out.println("Classes list: ");
                    for(int i = 0; i < university.getClasses().size(); i++){
                        System.out.println(i + ". " + university.getClasses().get(i).getName());
                    }
                    System.out.println("Select a class for the student: ");
                    int studentClass = scan.nextInt();
                    university.getClasses().get(studentClass).addStudent(newStudent);
                    System.out.println("Student with the next info was successfully created: ");
                    System.out.println("New student id: " + newStudent.getId());
                    System.out.println("New student name: " + newStudent.getName());
                    System.out.println("New student age: " + newStudent.getAge());
                    pressEnterToContinue();
                    break;
                case 4:
                    System.out.println("Class name: ");
                    scan.nextLine();
                    String newClassName = scan.nextLine();
                    System.out.println("Classroom name: ");
                    String newClassroom = scan.nextLine();
                    System.out.println("Select teacher for the class: ");
                    for(int i = 0; i < university.getTeachers().size(); i++){
                        Teacher teacher = university.getTeachers().get(i);
                        System.out.println(i + ". " + teacher.getName());
                    }
                    int classTeacher = scan.nextInt();
                    if (classTeacher < 0 || classTeacher > university.getTeachers().size()){
                        System.out.println("invalid option :(, try again");
                    }else{
                        Teacher newClassTeacher = university.getTeachers().get(classTeacher);
                        Class newClass = new Class(newClassName, newClassroom, newClassTeacher);
                        ArrayList<Student> allStudents = new ArrayList<>(university.getStudents());
                        int selectedStudent = 0;

                        while (selectedStudent != university.getStudents().size()){
                            System.out.println("Select an student for the class");
                            allStudents.removeAll(newClass.getStudents());
                            for(Student student : allStudents) {
                                System.out.println(student.getId() + ". " + student.getName());
                            }
                            System.out.println(university.getStudents().size() + ". Finish register");

                            selectedStudent = scan.nextInt();
                            if(selectedStudent >= 0 && selectedStudent < university.getStudents().size()){
                                if (allStudents.contains(university.getStudents().get(selectedStudent)) && !newClass.getStudents().contains(university.getStudents().get(selectedStudent))){
                                    newClass.addStudent(university.getStudents().get(selectedStudent));
                                    System.out.println("Student " + university.getStudents().get(selectedStudent).getName() + " Added to the " + newClass.getName() + " class" );
                                    pressEnterToContinue();
                                }else{
                                    System.out.println("Invalid option :(, try again");
                                    pressEnterToContinue();
                                }

                            }else if (selectedStudent == university.getStudents().size()){
                                System.out.println("Returning to menu...");
                                pressEnterToContinue();
                            }
                            else {
                                System.out.println("Invalid option :(, try again");

                            }

                        }

                        university.addClass(newClass);
                        System.out.println("Class with the next info was successfully created: ");
                        System.out.println("Class name: " + newClass.getName());
                        System.out.println("Classroom: " + newClass.getClassRoom());
                        System.out.println("Class Teacher: " + newClass.getTeacher().getName());
                    }


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
                        university.addTeacher(newTeacher);
                        System.out.println("Full time teacher with the next info was successfully created: ");
                        System.out.println("New teacher name: " + newTeacher.getName());
                        System.out.println("New teacher experience years: " + newTeacher.getExperienceYears());
                        System.out.println("New teacher salary: $" + newTeacher.getSalary());
                    }
                    else if(teacherType == 2){
                        System.out.println("Teacher active hours per week: ");
                        int newTeacherHoursPerWeek = scan.nextInt();
                        PartTimeTeacher newTeacher = new PartTimeTeacher(newTeacherName, newTeacherBaseSalary, newTeacherHoursPerWeek);
                        university.addTeacher(newTeacher);
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
                    System.out.println("Select an student to see his classes: ");
                    for(Student student : university.getStudents()){
                        System.out.println(student.getId() + ". " + student.getName());
                    }
                    Student student = university.getStudents().get(scan.nextInt());
                    List<Class> studentClasses = university.getStudentClasses(student);
                    for (int i = 0; i < studentClasses.size(); i++){
                        System.out.println(i + ". " + studentClasses.get(i).getName());
                    }

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

    public static void initUniversity(University university) {
        String[] studentsNames = {"Brandon", "Maicol", "David", "Gabrielle", "Copito", "Sebastian"};
        int exampleAge = 18;
        for(String name : studentsNames){
            Student newStudent = new Student(university.getStudents().size(), name, exampleAge);
            university.addStudent(newStudent);
            exampleAge++;
        }

        String[] teachersNames = {"Alice", "Bob", "Charlie", "Diana"};
        int exampleHours = 10;
        int exampleYears = 2;
        for(int i = 0; i < teachersNames.length; i++){
            if(i < 2){
                PartTimeTeacher newTeacher = new PartTimeTeacher(teachersNames[i], 10000, exampleHours);
                university.addTeacher(newTeacher);
                exampleHours++;
            }else{
                FullTimeTeacher newTeacher = new FullTimeTeacher(teachersNames[i], 10000, exampleYears);
                university.addTeacher(newTeacher);
                exampleYears++;
            }

        }

        String[] classes = {"Spanish", "Mathematics", "Physics", "Music"};
        String[] classrooms = {"401", "402"};
        for(int i = 0; i < classes.length; i++){
            if(i < 2){
                Class newClass = new Class(classes[i], classrooms[0], university.getTeachers().get(i));
                newClass.addStudent(university.getStudents().get(i));
                newClass.addStudent(university.getStudents().get(4));
                university.addClass(newClass);
            }else{
                Class newClass = new Class(classes[i], classrooms[1], university.getTeachers().get(i));
                newClass.addStudent(university.getStudents().get(i));
                newClass.addStudent(university.getStudents().get(5));
                university.addClass(newClass);
            }

        }


    }
}