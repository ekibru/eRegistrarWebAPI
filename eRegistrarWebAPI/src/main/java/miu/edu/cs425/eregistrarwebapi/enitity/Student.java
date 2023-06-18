package miu.edu.cs425.eregistrarwebapi.enitity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import miu.edu.cs425.eregistrarwebapi.dto.StudentRequest;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="students")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@AllArgsConstructor(staticName = "build")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private double cgpa;
    private LocalDate dateOfEnrollment;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transcript_id")
    @JsonManagedReference
    private Transcript transcript;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Classroom classroom;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Course> courses;
    public Student(){}
    public Student(String studentNumber, String firstName,
                   String middleName, String lastName, double cgpa,
                   LocalDate dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }
    public  static Student build(StudentRequest studentRequest){
        var student = new Student();
        student.setStudentNumber(studentRequest.getStudentNumber());
        student.setFirstName(studentRequest.getFirstName());
        student.setMiddleName(studentRequest.getMiddleName());
        student.setLastName(studentRequest.getLastName());
        student.setCgpa(studentRequest.getCgpa());
        student.setDateOfEnrollment(studentRequest.getDateOfEnrollment());
        return student;
    }
    public static Student build(String name){
        var student = new Student();
        student.setFirstName(name);
        return student;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


}
