package com.impiger.employee.view;

import java.util.List;

import com.impiger.employee.entity.Employee;


public class Response {

    boolean isSuccess = true;
    Object data;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Response() {
    }

    public Response(boolean b, List<Employee> employeeList) {
        this.isSuccess = b;
        this.data = employeeList;
    }


}
