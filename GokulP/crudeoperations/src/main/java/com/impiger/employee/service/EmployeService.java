package com.impiger.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.support.ClientResponseWrapper;

import com.impiger.employee.entity.Employee;
import com.impiger.employee.mapping.ModelMapping;
import com.impiger.employee.repository.EmployeeRepository;
import com.impiger.employee.view.EmployeeDTO;
import com.impiger.employee.view.Response;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ModelMapping mapper;

	public EmployeeDTO getEmployeeById(Integer empId) {
		return mapper.employeetoEmployeeDto(employeeRepository.getOne(empId));
	}

	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		employeeRepository.findAll().forEach(e -> employeeDTOs.add(mapper.employeetoEmployeeDto(e)));
		return employeeDTOs;
	}

	public EmployeeDTO saveEmployeeDetails(EmployeeDTO employeeDto) {
		Employee employee = mapper.employeeDTOtoEmployee(employeeDto);
		employeeRepository.save(employee);
		return mapper.employeetoEmployeeDto(employee);
	}

	public Response saveListOfEmployees(List<EmployeeDTO> employees) {
		Response response = new Response();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		employees.forEach(e -> employeeDTOs.add(saveEmployeeDetails(e)));
		response.setData(employeeDTOs);
		return response;
	}

	public void deleteEmployee(Integer empId) {
		employeeRepository.deleteById(empId);
	}

}
