package com.impigier.student.Service;


import com.impigier.student.Model.Entity.StudentEntity;
import com.impigier.student.Repository.StudentRepository;
import com.impigier.student.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> getAllStudent(){

        List<StudentEntity> studentEntityList= studentRepository.findAll();

        if(studentEntityList.size()>0){
            return studentEntityList;
        }else{
            return new ArrayList<StudentEntity>();
        }
    }
    public StudentEntity getStudentByID(Integer id) throws RecordNotFoundException
    {
        Optional<StudentEntity> student = studentRepository.findById(id);

        if(student.isPresent()){
            return student.get();
        }else {
            throw new RecordNotFoundException("No Student record exist for given id");
        }
    }
    public StudentEntity createOrUpdateStudent(StudentEntity Details) throws RecordNotFoundException{
        Optional<StudentEntity> student =studentRepository.findById(Details.getStudentId());
        if(student.isPresent()){
            StudentEntity newDetails = student.get();
            newDetails.setFirstName(Details.getFirstName());
            newDetails.setLastName(Details.getLastName());

            newDetails = studentRepository.save(newDetails);

            return newDetails;
        }else {
            Details = studentRepository.save(Details);
            return Details;
        }
    }
    public void deleteStudentById(Integer id) throws RecordNotFoundException{
        Optional<StudentEntity> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
        }else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
