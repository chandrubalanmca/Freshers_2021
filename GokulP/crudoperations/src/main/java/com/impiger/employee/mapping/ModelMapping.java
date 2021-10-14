package com.impiger.employee.mapping;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.impiger.employee.entity.Employee;
import com.impiger.employee.view.EmployeeDTO;


@Component
public class ModelMapping {
	
    ModelMapper modelMapper=new ModelMapper();

    public Employee employeeDTOtoEmployee(EmployeeDTO employeeDto) {
    	Employee employee=modelMapper.map(employeeDto,Employee.class);
    	return employee;
    }

    public EmployeeDTO employeetoEmployeeDto(Employee employee) {
    	EmployeeDTO employeeDto=modelMapper.map(employee,EmployeeDTO.class);
    	return employeeDto;
    }


}
