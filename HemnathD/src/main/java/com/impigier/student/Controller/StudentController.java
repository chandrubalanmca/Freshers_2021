package com.impigier.student.Controller;

import com.impigier.student.Model.Entity.StudentEntity;
import com.impigier.student.Service.StudentService;
import com.impigier.student.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentdetails")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudent(){
        List<StudentEntity> list = studentService.getAllStudent();

        return new ResponseEntity<List<StudentEntity>>(list,new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") Integer id)throws RecordNotFoundException{

        StudentEntity Details = studentService.getStudentByID(id);

        return new ResponseEntity<StudentEntity>(Details, new HttpHeaders(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StudentEntity> createOrUpdateStudent(StudentEntity student)throws RecordNotFoundException{
        StudentEntity updated = studentService.createOrUpdateStudent(student);
        return new ResponseEntity<StudentEntity>(updated,new HttpHeaders(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteStudentById(@PathVariable("id") Integer id)throws RecordNotFoundException{
        studentService.deleteStudentById(id);
        return HttpStatus.FORBIDDEN;
    }

}
