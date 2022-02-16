package com.Student.Details.Controller;

import com.Student.Details.Model.Entity.Student;
import com.Student.Details.Model.IO.ResponseWrapper;
import com.Student.Details.Model.IO.StudentRequest;
import com.Student.Details.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Mono<ResponseWrapper<Student>> create(@RequestBody StudentRequest detail){
        return Mono.defer(() -> studentService.create(detail))
                .map(student -> new ResponseWrapper<>(true,student));
    }

    @PutMapping(value = "/{id}")
    public Mono<ResponseWrapper<Student>> update(@PathVariable Integer id,
                                                 @RequestBody StudentRequest request){
    return Mono.defer(() -> studentService.update(id,request))
            .map(student -> new ResponseWrapper<>(true,student));
    }

    @GetMapping(value = "/{id}")
    public Mono<ResponseWrapper<Student>> getStudentById(@PathVariable Integer id){
        return Mono.defer(() -> studentService.getStudentById(id))
                .map(student -> new ResponseWrapper<>(true,student));
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<ResponseWrapper<Student>> deleteStudentById(@PathVariable Integer id){
        return Mono.defer(() -> studentService.deleteStudentById(id))
                .map(student -> new ResponseWrapper<>(true,student));
    }

    @GetMapping(value = "/list")
    public Mono<ResponseWrapper<List<Student>>> getStudentList(){
        return studentService.getStudentList().collectList()
                .map(studentResponses -> new ResponseWrapper<>(true,studentResponses));
    }

}