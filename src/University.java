import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Class> classes;

    public University() {
        this.teachers = new ArrayList<>();;
        this.students = new ArrayList<>();;
        classes = new ArrayList<>();;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }

    public void addClass(Class newClass){
        this.classes.add(newClass);
    }

    public List<Class> getStudentClasses(Student student){
        List<Class> studentClasses = new ArrayList<>();
        for (Class universityClass : classes) {
            if (universityClass.getStudents().contains(student)) {
                studentClasses.add(universityClass);
            }
        }
        return studentClasses;
    }
}
