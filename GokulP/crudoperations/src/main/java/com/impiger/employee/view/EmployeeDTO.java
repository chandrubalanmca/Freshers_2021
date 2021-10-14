package com.impiger.employee.view;


public class EmployeeDTO {

    private Integer empId;
    private String empName;
    private String empEmail;
    private String empPhone;
    private String empDept;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empMail) {
        this.empEmail = empMail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public EmployeeDTO(Integer empId, String empName, String empMail, String empPhone, String empDept) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empMail;
        this.empPhone = empPhone;
        this.empDept = empDept;
    }

    public EmployeeDTO() {
    }


}
