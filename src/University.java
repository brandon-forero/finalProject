import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Class> Classes;

    public University() {
        this.teachers = new ArrayList<>();;
        this.students = new ArrayList<>();;
        Classes = new ArrayList<>();;
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
        return Classes;
    }

    public void setClasses(List<Class> classes) {
        Classes = classes;
    }
}
