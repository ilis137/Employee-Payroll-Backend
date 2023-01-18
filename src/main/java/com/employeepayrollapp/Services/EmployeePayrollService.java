package com.employeepayrollapp.Services;

import com.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.employeepayrollapp.Models.EmployeePayrollData;
import com.employeepayrollapp.Repository.EmployeePayrollRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    @Override
    public EmployeePayrollDTO createEmployeePayroll(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empPayroll = new EmployeePayrollData(employeePayrollDTO.getName(), employeePayrollDTO.getSalary());
        empPayroll=employeePayrollRepository.save(empPayroll);
        return modelMapper.map(empPayroll, EmployeePayrollDTO.class);
    }

    @Override
    public EmployeePayrollDTO getEmployeePayrollById(long empId) {
        EmployeePayrollData employeePayrollData=employeePayrollRepository.findById(empId).get();
        return modelMapper.map(employeePayrollData, EmployeePayrollDTO.class);
    }

    @Override
    public List<EmployeePayrollDTO> getAllEmployeePayroll() {
        List<EmployeePayrollData> employeePayrollList=employeePayrollRepository.findAll();
        List<EmployeePayrollDTO> employeePayrollDTOList=employeePayrollList.stream().map(empPayroll->modelMapper.map(empPayroll, EmployeePayrollDTO.class)).collect(Collectors.toList());
        return employeePayrollDTOList;
    }

    @Override
    public EmployeePayrollDTO updateEmployeePayrollById(long empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData=employeePayrollRepository.findById(empId).get();
        employeePayrollData.setName(employeePayrollDTO.getName());
        employeePayrollData.setSalary(employeePayrollDTO.getSalary());
        employeePayrollData=employeePayrollRepository.save(employeePayrollData);
        return modelMapper.map(employeePayrollData, EmployeePayrollDTO.class);
    }

    @Override
    public void deleteEmployeePayrollById(long empId) {
       employeePayrollRepository.deleteById(empId);
    }
}
