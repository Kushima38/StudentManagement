package raisetech.StudentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.date.Student;
import raisetech.StudentManagement.date.StudentsCourses;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/studentList")
  public List<Student> getStudentList() {
    return service.findStudentsInTheirThirties();
  }

  @GetMapping("/studentsCoursesList")
  public List<StudentsCourses> getStudentsCoursesList() {
    return service.findJavaCoursesRecords();
  }
}
