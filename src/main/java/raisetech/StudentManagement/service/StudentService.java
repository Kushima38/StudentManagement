package raisetech.StudentManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {
  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> findStudentsInTheirThirties(){
    //絞り込み検索で年齢が30代の人のみ抽出
    //抽出したリストをコントローラーに返す
    return repository.search().stream()
        .filter(student -> student.getAge() >= 30 && student.getAge() <= 39)
        .toList();
  }

  public List<StudentsCourses> findJavaCoursesRecords() {
    //絞り込み検索でjavaコースのコース情報のみを抽出する
    //抽出したリストをコントローラーに返す
    return repository.searchByStudentsCourses().stream()
        .filter(StudentsCourses->StudentsCourses.getCourseName().equals("Javaコース"))
        .toList();
  }
}
