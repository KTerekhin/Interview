package mvc.repositories;

import mvc.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> students;
    private Long maxId;

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    @PostConstruct
    public void init() {
        this.students = new ArrayList<>();
        this.students.add(new Student(1L, "Bob", 80));
        this.students.add(new Student(2L, "Jack", 70));
        this.students.add(new Student(3L, "Harry", 75));
        this.students.add(new Student(4L, "Wayne", 90));
        this.students.add(new Student(5L, "Ryan", 85));
        this.maxId = (long) students.size();
    }

    public void addStudent(Student student) {
        maxId++;
        student.setId(maxId);
        students.add(student);
    }

    public Student getStudentById(Long studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        throw new IllegalArgumentException(String.format("Студента с таким идентификатором не существует [id = %d]", studentId));
    }

    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }
}
