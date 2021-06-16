package mvc.services;

import mvc.model.Student;
import mvc.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getStudents();
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
