package miu.edu.cs425.eregistrarwebapi.service;


import miu.edu.cs425.eregistrarwebapi.dto.StudentRequest;
import miu.edu.cs425.eregistrarwebapi.enitity.Student;
import miu.edu.cs425.eregistrarwebapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById( Long studentId){
        return studentRepository.getReferenceById(studentId);
    }

    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student registerStudent(StudentRequest student) {
        var student1 = Student.build(student.getStudentRequest());
        return studentRepository.save(student1);
    }

    @Override
    public Student updateStudent( StudentRequest student) {
        var student1 = Student.build(student.getStudentRequest());
        return studentRepository.save(student1);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

}
