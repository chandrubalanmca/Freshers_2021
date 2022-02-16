package com.Student.Details.Service;

import com.Student.Details.Model.Entity.Student;
import com.Student.Details.Model.IO.StudentRequest;
import com.Student.Details.Model.IO.StudentResponse;
import com.Student.Details.Model.Mapper.StudentMapper;
import com.Student.Details.Repository.StudentRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Objects;

@Validated
@Log4j2
@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    public Mono<Student> create(StudentRequest detail){
        log.debug("Student Detail Request :" +detail);
        return Mono.just(studentMapper.fromStudent(detail))
                .flatMap(student ->Mono.fromCallable(()-> saveStudent(student)));
    }

    public Student saveStudent(Student student){
    Student studentDetail = null;
    try{
        studentDetail = studentRepo.save(student);
    }catch (DataIntegrityViolationException e){
        log.debug("Exception: " + e.getMessage());
    }
    return studentDetail;
    }

    public Mono<Student> update(Integer id,@Validated StudentRequest request){
    log.debug("Request Student id : " + id );
    return Mono.fromCallable(() -> studentRepo.findById(id).orElse(null))
            .map(student -> addStudent(student,request))
            .flatMap(student -> Mono.fromCallable(() -> saveStudent(student)));
    }

    public Student addStudent(Student student, StudentRequest request){
    return Student.builder()
            .id(student.getId())
            .name(request.getName())
            .number(request.getNumber())
            .subject(request.getSubject()).build();
    }

    public Mono<Student> getStudentById(Integer id){
        log.debug("Get Student by Id : " + id);
        return Mono.just(Objects.requireNonNull(studentRepo.findById(id).orElse(null)));
    }

    public Mono<Student> deleteStudentById(Integer id){
        log.debug("Delete By Id : " + id);
        return Mono.just(studentRepo.deleteById(id));
    }

    public Flux<Student>getStudentList(){
        log.debug("Get list of Student");
        return Flux.fromIterable(studentRepo.findAll());
    }
}