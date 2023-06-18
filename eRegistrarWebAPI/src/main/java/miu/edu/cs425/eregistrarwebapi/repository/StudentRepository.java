package miu.edu.cs425.eregistrarwebapi.repository;


import miu.edu.cs425.eregistrarwebapi.enitity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("select s from Student s where s.studentId = ?1")
    Student getReferenceById(Long studentId);
}
