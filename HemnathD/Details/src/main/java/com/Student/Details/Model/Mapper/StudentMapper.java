package com.Student.Details.Model.Mapper;

import com.Student.Details.Model.Entity.Student;
import com.Student.Details.Model.IO.StudentRequest;
import org.mapstruct.*;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(target = "number",source = "number"),
            @Mapping(target = "subject",source = "subject")
    })
    Student fromStudent(StudentRequest detail);

}
