package com.suresh.employee_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name="Employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_Id")
	public Long   employeeId;

	@Column(name="emp_Name")
	public String employeeName;
	@Column(name="emp_Dep")
	public String employeeDepartment;
	@Column(name="emp_Sal")
	public Long employeeSalary;

	public Employee() {
	}

	public Employee(Long employeeId, String employeeName, String employeeDepartment, Long employeeSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeSalary = employeeSalary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", employeeName='" + employeeName + '\'' +
				", employeeDepartment='" + employeeDepartment + '\'' +
				", employeeSalary=" + employeeSalary +
				'}';
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public Long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}






}
