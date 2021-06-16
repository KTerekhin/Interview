package mvc.controllers;

import mvc.services.StudentService;
import mvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public String studentInfo(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student_info";
    }

    @PostMapping("/add_student")
    public String addStudent(@RequestParam String name, @RequestParam int score) {
//        Long id = 6L;
        Student student = new Student(/*id, */name, score);
        studentService.addStudent(student);
//        id++;
        return "redirect:/students/all";
    }

    @GetMapping("/remove/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/students/all";
    }
}
