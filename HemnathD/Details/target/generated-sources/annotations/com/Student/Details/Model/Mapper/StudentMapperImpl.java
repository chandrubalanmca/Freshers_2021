package com.Student.Details.Model.Mapper;

import com.Student.Details.Model.Entity.Student;
import com.Student.Details.Model.IO.StudentRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-16T19:05:48+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student fromStudent(StudentRequest detail) {
        if ( detail == null ) {
            return null;
        }

        Student student = new Student();

        student.number = detail.number;
        student.subject = detail.subject;

        return student;
    }
}
