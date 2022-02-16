package com.Student.Details.Repository;

import com.Student.Details.Model.Entity.Student;
import com.Student.Details.Model.IO.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<StudentResponse> findStudentList();

}
