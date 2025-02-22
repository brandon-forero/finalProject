import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private String ClassRoom;
    private List<Student> students;
    private Teacher teacher;

    public Class(String name, String classRoom, Teacher teacher) {
        this.name = name;
        ClassRoom = classRoom;
        this.students = new ArrayList<>();;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassRoom() {
        return ClassRoom;
    }

    public void setClassRoom(String classRoom) {
        ClassRoom = classRoom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
