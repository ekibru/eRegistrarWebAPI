package miu.edu.cs425.eregistrarwebapi.controller;


import miu.edu.cs425.eregistrarwebapi.dto.StudentRequest;
import miu.edu.cs425.eregistrarwebapi.enitity.Student;
import miu.edu.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "api/student")
@RequestMapping(value = { "/api/student" })
public class StudentController {
    @Autowired
    private StudentService studentService;
    //to display the list of students
    @GetMapping(value = { "/list" })
    public ResponseEntity<List<Student>> displayHomePage() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

// to display student by id
    @GetMapping(value = { "/get/{studentId}" })
    public ResponseEntity<Student> getStudentById(@PathVariable  Long studentId){
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    // to add new student to database
    @PostMapping(value = "/rt" , produces = "application/json; charset=UTF-8")
    public ResponseEntity<Student> registerStudent(@RequestBody StudentRequest student) {
        Student registeredStudent = studentService.registerStudent(student);
        return new ResponseEntity<>(registeredStudent, HttpStatus.CREATED);
    }

    // to update student
    @PutMapping(value = "/update/{studentId}" , produces = "application/json; charset=UTF-8")
    public ResponseEntity<Student> updateStudent( @RequestBody StudentRequest student) {
        Student updatedStudent = studentService.updateStudent(student.getStudentRequest());
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
// to delet student by id
    @DeleteMapping(value = "/delete/{studentId}" , produces = "application/json; charset=UTF-8")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
