package com.suresh.employee_service.dto;

public class EmployeeDTO {

    public Long   employeeId;
    public String employeeName;
    public String employeeDepartment;
    public Long employeeSalary;

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public AddressDTO addressDTO;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeId, String employeeName, String employeeDepartment, Long employeeSalary, AddressDTO addressDTO) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
        this.addressDTO = addressDTO;
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
