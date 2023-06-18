package miu.edu.cs425.eregistrarwebapi.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.edu.cs425.eregistrarwebapi.enitity.Student;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {
    private Long studentId;
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private double cgpa;
    private LocalDate dateOfEnrollment;




public StudentRequest(Student student){
        this.studentId=student.getStudentId();
        this.studentNumber=student.getStudentNumber();
        this.firstName=student.getFirstName();
        this.middleName=student.getMiddleName();
        this.lastName=student.getLastName();
        this.cgpa=student.getCgpa();
        this.dateOfEnrollment=student.getDateOfEnrollment();
    }
public StudentRequest getStudentRequest(){
        return this;}
    public String getName() {
        return firstName;
    }
}
