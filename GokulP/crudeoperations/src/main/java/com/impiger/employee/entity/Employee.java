package com.impiger.employee.entity;
import javax.persistence.*;

@Entity
@Table(name = "employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    Integer empId;
    
    @Column(name = "emp_name")
    String empName;

    @Column(name = "emp_email")
    String empEmail;

    @Column(name="emp_phone")
    String empPhone;

    @Column(name = "emp_dept")
    String empDept;

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

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
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
	

	public Employee() {
	
	}

	public Employee(Integer empId, String empName, String empEmail, String empPhone, String empDept) {
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empDept = empDept;
	}
    
    

}