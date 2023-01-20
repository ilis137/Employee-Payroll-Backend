package com.employeepayrollapp.Services;

import com.employeepayrollapp.DTO.EmployeePayrollDTO;

import java.util.List;

public interface IEmployeePayrollService {
    public EmployeePayrollDTO createEmployeePayroll(EmployeePayrollDTO employeePayrollDTO);

    public EmployeePayrollDTO getEmployeePayrollById(long empId);

    public List<EmployeePayrollDTO> getAllEmployeePayroll();

    public EmployeePayrollDTO updateEmployeePayrollById(long empId, EmployeePayrollDTO employeePayrollDTO);

    public void deleteEmployeePayrollById(long empId);

    public List<EmployeePayrollDTO> getEmployeePayrollByDepartment(String department);
}
