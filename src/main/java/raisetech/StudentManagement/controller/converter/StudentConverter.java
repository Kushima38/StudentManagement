package raisetech.StudentManagement.controller.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;

@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentsCourses> studentsCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();
    for (Student student : students) {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);
      List<StudentsCourses> convertStudentCourses = new ArrayList<>();
      for (StudentsCourses studentsCourse : studentsCourses) {
        if (student.getId().equals(studentsCourse.getStudentId())) {
          convertStudentCourses.add(studentsCourse);
        }
      }
      studentDetail.setStudentsCourses(convertStudentCourses);
      studentDetails.add(studentDetail);
    }
    return studentDetails;
  }
}
