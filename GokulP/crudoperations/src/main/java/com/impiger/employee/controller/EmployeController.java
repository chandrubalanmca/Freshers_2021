package com.impiger.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.impiger.employee.entity.Employee;
import com.impiger.employee.service.EmployeService;
import com.impiger.employee.view.EmployeeDTO;
import com.impiger.employee.view.Response;

@RestController
@RequestMapping("/employee-management")
public class EmployeController {

    @Autowired
    EmployeService employeService;

    @GetMapping("/employee-details")
    public Response getAllDetails(@RequestParam(required = false) Integer empId) {
        Response response = new Response();
        if (empId != null) {
            response.setData(employeService.getEmployeeById(empId));
        } else {

            response.setData(employeService.getAllEmployees());
        }
        return response;
    }

    @PostMapping("/employee-details")
    public Response saveEmployee(@RequestBody EmployeeDTO employeeDto) {
        Response response = new Response();
        response.setData(employeService.saveEmployeeDetails(employeeDto));
        return response;

    }

    @PostMapping("/employees-details")
    public Response saveEmployees(@RequestBody List<EmployeeDTO> employee) {
        return employeService.saveEmployeesDetails(employee);
    }

    @DeleteMapping("employee-detail/{id}")
    public Response deleteEmployee(@PathVariable("id") Integer empId) {
        Response response = new Response();
        employeService.deleteEmployee(empId);
        return response;
    }
}
