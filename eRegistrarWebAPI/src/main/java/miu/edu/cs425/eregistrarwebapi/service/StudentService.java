package miu.edu.cs425.eregistrarwebapi.service;


import miu.edu.cs425.eregistrarwebapi.dto.StudentRequest;
import miu.edu.cs425.eregistrarwebapi.enitity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();
    Student getStudentById( Long studentId);

    Student registerStudent(Student student);
    Student registerStudent(StudentRequest student);


    Student updateStudent(StudentRequest student);

    void deleteStudentById(Long studentId);
}